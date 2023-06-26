package validador;

import parser.MiniPascalBaseListener;
import javax.script.*;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import parser.MiniPascalLexer;
import parser.MiniPascalParser;
import tables.Tabla_de_Funciones;
import tables.TableSymbol;
import variables.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Funcion.*;
public class validador_semantico extends MiniPascalBaseListener  {
    private String ActualScope = "Global";
    private String ScopeSubRutina = "";
    private TableSymbol VarSubRutina = new TableSymbol("GlobalTemporales");
    private String condicionalSubRutina = "";
    private TableSymbol GlobalSymbol = new TableSymbol("Global");
    private HashMap<String, Funcion> Funciones = new HashMap<>();
    private HashMap<String, Procedimiento> Procedures = new HashMap<>();
    private HashMap<String, subRutina> subRutinas = new HashMap<>();
    private Boolean correcto = true;
    private String MessageError = "";
    private List<String> quads = new ArrayList<>();
    private int nextQuad = 1;
    private int contadorTexto =0;
    private  String data = "";


    @Override public void exitProgram(MiniPascalParser.ProgramContext ctx) {

        if(correcto){
           /* System.out.println("----------Tabla global----------");
            System.out.println("NUmero de variables: "+this.GlobalSymbol.numero_variables());
            this.GlobalSymbol.imprimir_tablas();
            System.out.println("--------------------------------");
            System.out.println("------------Funciones------------");
            System.out.println("----------Stack de funciones: "+this.Funciones.size()+"----------");
            for (Funcion valor : this.Funciones.values()) {
                valor.imprimir_funcion();
            }
            System.out.println("-------------------------PROCEDURES------------------------------------------");
            for (Procedimiento valor : this.Procedures.values()) {
                valor.imprimir_procedimiento();
            }*/
            String filePath = "C:\\Users\\HP\\OneDrive\\Escritorio\\codigollvm\\codigo.ll";

             data+="declare i32 @printf(i8*, ...) nounwind\n" ;

            data+="define void @main() {\n";
            for(String quad: this.quads){
                //System.out.println("EL QUAD es: "+quad);
                String llvmResult = convertToLLVM(quad);
                data+=llvmResult+"\n";
            }
            data+="}";
            //System.out.println("La data es: \n"+data);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(data);
                System.out.println("Archivo LLVM creado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo LLVM: " + e.getMessage());
            }
        }else{
            System.out.println(this.MessageError);
        }

    }
    @Override public void enterVariableDeclaration(MiniPascalParser.VariableDeclarationContext ctx) {
        try{
            if(correcto){

                String []previusData = ctx.identifierList().getText().split(",");
                for (int i = 0; i<previusData.length; i++){

                    if(correcto){

                        //System.out.println("Primero VariableDeclaration con: "+previusData[i]);
                        correcto = crear_variable(previusData[i],ctx.type_().getText());
                    }
                }


                if(!correcto){
                    String error = "Error al declarar variable, ya existe una con ese nombre";
                    int linea = ctx.getStart().getLine();
                    CreateMessageError(error, linea);
                }
            }
        }catch(Exception e){
            System.out.println("Algo fallo en el nodo de VariableDeclaration");
        }
    }
    @Override public void enterAssignmentStatement(MiniPascalParser.AssignmentStatementContext ctx) {
        if(this.correcto){
            String []partes = ctx.getText().split(":=");
            String leftVariable = partes[0];
            //MiniPascalParser.VariableContext leftVariable = ctx.variable(0);

            MiniPascalParser.ExpressionContext expression = ctx.expression();
            int linea = ctx.getStart().getLine();

                if (expression != null) {

                if(this.ActualScope.equalsIgnoreCase("global")){
                    Variable left = this.GlobalSymbol.getVariable(leftVariable);
                    if(left== null){
                        left = this.VarSubRutina.getVariable(leftVariable);
                    }
                    if(left!=null){

                        String newExpresion = reestructurar_operacion(expression.getText());
                        if(left.getTipo().equalsIgnoreCase("integer")||left.getTipo().equalsIgnoreCase("real")
                                ||left.getTipo().equalsIgnoreCase("double")){
                            boolean isNumber = isNUmber(left.getTipo(), newExpresion);
                            if(!isNumber){

                                boolean valido2 = isOperacion_aritmetica(newExpresion);
                                if(!valido2){

                                    correcto= isFunctionCall(expression.getText());
                                    if(!correcto){
                                        String message = "Valor invalido para la variable de tipo númerico: "+left.getNombre();
                                        CreateMessageError(message, linea);
                                    }else{

                                        MiniPascalParser.FunctionDesignatorContext designator = expression.simpleExpression().term().signedFactor().factor().functionDesignator();
                                        Funcion funcion = this.Funciones.get(designator.identifier().getText());
                                        if(funcion.getResultType().equalsIgnoreCase(left.getTipo())){
                                            llamada_de_funcion(designator);
                                            Variable result = funcion.getSimbolos().getVariable("result");
                                            //store i32 10, i32* %variable
                                            String quad =nextQuad + ":" + "ASSIGN," + result.getValor()+"," + result.getTipo()+","+ left.getNombre();
                                            quads.add(quad);
                                            nextQuad++;
                                            Actualizar_valor_de_variable(left, result.getValor());
                                        }else{
                                            correcto = false;
                                            String message = "Valor de retorno no coincide con el tipo numerico de la variable: "+left.getNombre();
                                            CreateMessageError(message, linea);
                                        }

                                    }
                                }else{

                                    String newOperacion = reestructurar_operacion(newExpresion);
                                    String res =""+ evaluarOperacion(newOperacion);
                                    Actualizar_valor_de_variable(left, res);
                                }

                            }else{
                                Actualizar_valor_de_variable(left, newExpresion);
                            }

                        }else if(left.getTipo().equalsIgnoreCase("Boolean")){
                            boolean isBoolean =esBooleano(newExpresion);
                            if(!isBoolean){
                                boolean valido2 = isOperacion_boolena(newExpresion);
                                if(!valido2){
                                    correcto= isFunctionCall(expression.getText());
                                    if(!correcto){
                                        String message = "Valor invalido para la variable "+left.getNombre()+" de tipo booleano";
                                        CreateMessageError(message, linea);
                                    }else{

                                        MiniPascalParser.FunctionDesignatorContext designator = expression.simpleExpression().term().signedFactor().factor().functionDesignator();
                                        Funcion funcion = this.Funciones.get(designator.identifier().getText());
                                        if(funcion.getResultType().equalsIgnoreCase(left.getTipo())){
                                            llamada_de_funcion(designator);
                                            Variable result = funcion.getSimbolos().getVariable("result");
                                            String quad =nextQuad + ":" + "ASSIGN," + result.getValor() +","+ result.getTipo()+"," + left.getNombre();
                                            quads.add(quad);
                                            nextQuad++;
                                            Actualizar_valor_de_variable(left, result.getValor());
                                        }else{
                                            correcto = false;
                                            String message = "Valor de retorno no coincide con el tipo booleano de la variable: "+left.getNombre();
                                            CreateMessageError(message, linea);
                                        }

                                    }
                                }else{
                                    String newOperacion = reestructurar_operacion(expression.getText());

                                    String res =""+evaluateBooleanExpression(newOperacion);
                                    if(correcto){
                                        Actualizar_valor_de_variable(left, res);
                                    }else{
                                        String message = "Operacion booleana invalida para la variable "+left.getNombre()+" de tipo booleano";
                                        CreateMessageError(message, linea);
                                    }

                                }

                            }else{
                                Actualizar_valor_de_variable(left, newExpresion);
                            }

                        }else if(left.getTipo().equalsIgnoreCase("char")){
                            boolean valido = esChar(expression.getText());
                            if(valido){
                                correcto = false;
                                String message = "Valor invalido para la variable "+left.getNombre()+" de tipo char, mas de un caracter encontrado";
                                CreateMessageError(message, linea);
                            }else{
                                Actualizar_valor_de_variable(left, expression.getText());
                            }

                        }else if(left.getTipo().equalsIgnoreCase("string")){
                            String primerCharacter = ""+expression.getText().charAt(0);
                            String ultimoChar =""+ expression.getText().charAt(expression.getText().length()-1);
                            boolean valido = esString(expression.getText());

                            if(valido){
                                Actualizar_valor_de_variable(left, expression.getText());
                            }else{
                                correcto = false;
                                String message = "Valor invalido para la variable "+left.getNombre()+" de tipo strin, faltan comillas '";
                                CreateMessageError(message, linea);
                            }
                        }

                        //validar_valor_de_asignacion(expression.getText());
                    }else{
                        this.correcto=false;
                        String message = "la variable no existe: "+leftVariable;
                        CreateMessageError(message, linea);
                    }
                }else if(this.Funciones.containsKey(this.ActualScope)){

                    String nombre = "Inicializacion-"+leftVariable;
                    String expresion = ctx.getText();
                    operaciones operacion = new operaciones(nombre, expresion);
                    this.Funciones.get(this.ActualScope).AddOperacion(operacion);
                }else if(this.Procedures.containsKey(this.ActualScope)){
                    String nombre = "Inicializacion-"+leftVariable;
                    String expresion = ctx.getText();
                    operaciones operacion = new operaciones(nombre, expresion);
                    this.Procedures.get(this.ActualScope).AddOperacion(operacion);
                }

            }
        }

    }
    public String reestructurar_operacion(String expresion){

        for (Map.Entry<String, Variable> entry : GlobalSymbol.getVariables().entrySet()) {
            String key = entry.getKey();
            Variable value = entry.getValue();
            if (expresion.contains(value.getNombre())){
                expresion= expresion.replace(value.getNombre(), value.getValor());
            }
        }

        for (Map.Entry<String, Variable> entry : VarSubRutina.getVariables().entrySet()) {
            String key = entry.getKey();
            Variable value = entry.getValue();
            if (expresion.contains(value.getNombre())){
                expresion= expresion.replace(value.getNombre(), value.getValor());
            }
        }

        return expresion;
    }
    public boolean isNUmber(String tipo, String number){
        return number.matches("-?\\d+(\\.\\d+)?");
    }
    public boolean isFunctionCall(String valor){
        return valor.matches("\\w+\\(.*\\)");
    }
    public boolean isOperacion_aritmetica(String expression){
        String regex = "^(?:\\d+(?:\\.\\d+)?\\s*[+\\-*/]\\s*)*\\d+(?:\\.\\d+)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        boolean isArithmeticOperation = matcher.matches();
        return isArithmeticOperation;
    }

    public  boolean esBooleano(String cadena) {
        return cadena.matches("(?i)true|false");
    }
    public boolean esChar(String valor){
        boolean valido = true;
        if(valor.length()==3){
            String firstChar=""+valor.charAt(0);
            String lastChar = ""+valor.charAt(valor.length()-1);
            if(firstChar.equalsIgnoreCase("'")&& lastChar.equalsIgnoreCase("'")){

            }else{
                valido = false;
            }
        }else{
            valido = false;
        }
        return valido;
    }
    public boolean esString(String valor){
        boolean valido = true;
        if(valor.length()>3){
            String firstChar=""+valor.charAt(0);
            String lastChar = ""+valor.charAt(valor.length()-1);
            if(firstChar.equalsIgnoreCase("'")&& lastChar.equalsIgnoreCase("'")){

            }else{
                valido = false;
            }
        }else{
            valido = false;
        }
        return valido;
    }
    public boolean isOperacion_boolena(String expression){
        String regex = "^(?:\\s*\\([^()]+\\)|[^()\\s]+\\s*(?:[=!<>]=?|and|or)\\s*[^()\\s]+\\s*)+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);
        boolean isBooleanOperation = matcher.matches();
        return isBooleanOperation;
    }

    @Override public void exitFunctionDeclaration(MiniPascalParser.FunctionDeclarationContext ctx) {
        if(correcto){
            this.ActualScope= "Global";

        }

    }
    @Override public void enterFunctionDesignator(MiniPascalParser.FunctionDesignatorContext ctx) {
      
       // llamada_de_funcion(ctx);

    }
    @Override public void enterProcedureStatement(MiniPascalParser.ProcedureStatementContext ctx) {
        llamada_de_procedure(ctx);
    }
    @Override public void exitProcedureDeclaration(MiniPascalParser.ProcedureDeclarationContext ctx) {
        this.ActualScope="Global";
    }
    @Override public void enterWrite(MiniPascalParser.WriteContext ctx) {
        try{
            if(correcto){
                if(this.ActualScope.equalsIgnoreCase("global")&& this.ScopeSubRutina.equalsIgnoreCase("")){

                    if(ctx.expressionWrite()!=null){

                        String partes = "";
                        for(int i = 0; i<ctx.getChildCount(); i++){
                            if(i!=0&&i!=1 && i!=ctx.getChildCount()-1){
                                partes+=ctx.getChild(i).getText();
                            }
                        }
                        String [] ensamble = partes.split(",");
                        String resultado = "";
                        for(String part: ensamble){
                            // resultado+= part+" ";
                            if(correcto){
                                if(part.charAt(0)=='\'' && part.charAt(part.length()-1)=='\''){
                                    for(int j = 0; j<part.length(); j++){
                                        String letra =""+part.charAt(j);
                                        if(!letra.equalsIgnoreCase("'")){
                                            resultado+=letra;
                                        }
                                    }
                                }else{
                                    if(this.GlobalSymbol.exist_variable(part)){
                                        resultado += this.GlobalSymbol.getVariable(part).getValor();
                                    }else{
                                        correcto = false;
                                        int linea = ctx.getStart().getLine();
                                        String Message="Error al declarar la sentencia write, solo permite string y variables: ";
                                        CreateMessageError(Message, linea);
                                    }
                                }
                            }

                        }
                        if(correcto){
                            System.out.println(resultado);
                            String quad =nextQuad + ":" + "WRITELN," + resultado + ",_," + "_";
                            quads.add(quad);
                            nextQuad++;
                        }

                    }
                }else if(this.ActualScope.equalsIgnoreCase("global")&& !this.ScopeSubRutina.equalsIgnoreCase("")){
                    //que no haga nada en caso de estar en subrutina, las propias subrutinas manejan su write
                }else{
                    //operaciones operacion = new operaciones("Write", ctx.getText());
                    if(this.Funciones.containsKey(this.ActualScope)){
                        String nombre = "Write-"+this.Funciones.get(this.ActualScope).getOperaciones().size();
                        operaciones operacion = new operaciones(nombre, ctx.getText());
                        this.Funciones.get(this.ActualScope).AddOperacion(operacion);
                    } else if (this.Procedures.containsKey(this.ActualScope)) {
                        String nombre = "Write-"+this.Procedures.get(this.ActualScope).getOperaciones().size();
                        operaciones operacion = new operaciones(nombre, ctx.getText());
                        this.Procedures.get(this.ActualScope).AddOperacion(operacion);
                    }else{
                        correcto = false;
                        int linea = ctx.getStart().getLine();
                        String Message="Error al declarar la sentencia write, la funcion o procedure no existe: ";
                        CreateMessageError(Message, linea);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error en el nodo de enterWrite");
        }
    }
    @Override public void enterRead(MiniPascalParser.ReadContext ctx) {
        try{
            if(correcto){
                String lector = ctx.IDENT().getText();
                if(lector!=null){
                    if(this.ActualScope.equalsIgnoreCase("global")&& this.ScopeSubRutina.equalsIgnoreCase("")){
                        if(this.GlobalSymbol.exist_variable(lector)){

                            Scanner scanner = new Scanner(System.in);
                            String valorIngresado = scanner.nextLine();
                            Variable variable = this.GlobalSymbol.getVariable(lector);
                            boolean valido= validar_valor_ingresado(variable, valorIngresado);
                            if(valido){
                                Actualizar_valor_de_variable(variable, valorIngresado);
                            }else{
                                correcto = false;
                                int linea = ctx.getStart().getLine();
                                String Message="Error al intentar leer valor desde teclado, el valor no coincide con el tipo de variable: ";
                                CreateMessageError(Message, linea);
                            }
                        }else{
                            correcto = false;
                            int linea = ctx.getStart().getLine();
                            String Message="Error al intentar leer valor desde teclado, la variable no existe en el global: ";
                            CreateMessageError(Message, linea);
                        }
                    }else if(this.ActualScope.equalsIgnoreCase("global")&& !this.ScopeSubRutina.equalsIgnoreCase("")){
                        if(this.VarSubRutina.exist_variable(lector)){

                            Scanner scanner = new Scanner(System.in);
                            String valorIngresado = scanner.nextLine();
                            Variable variable = this.VarSubRutina.getVariable(lector);
                            boolean valido= validar_valor_ingresado(variable, valorIngresado);
                            if(valido){
                                Actualizar_valor_de_variable(variable, valorIngresado);
                            }else{
                                correcto = false;
                                int linea = ctx.getStart().getLine();
                                String Message="Error al intentar leer valor desde teclado, el valor no coincide con el tipo de variable: ";
                                CreateMessageError(Message, linea);
                            }
                        }else if (this.GlobalSymbol.exist_variable(lector)){
                            Scanner scanner = new Scanner(System.in);
                            String valorIngresado = scanner.nextLine();
                            Variable variable = this.GlobalSymbol.getVariable(lector);
                            boolean valido= validar_valor_ingresado(variable, valorIngresado);
                            if(valido){
                                Actualizar_valor_de_variable(variable, valorIngresado);
                            }else{
                                correcto = false;
                                int linea = ctx.getStart().getLine();
                                String Message="Error al intentar leer valor desde teclado, el valor no coincide con el tipo de variable: ";
                                CreateMessageError(Message, linea);
                            }
                        }else{
                            correcto = false;
                            int linea = ctx.getStart().getLine();
                            String Message="Error al intentar leer valor desde teclado, la variable no existe en el global: ";
                            CreateMessageError(Message, linea);
                        }
                    }else {
                        if(this.Funciones.containsKey(this.ActualScope)){
                            String nombre = "Read-"+this.Funciones.get(this.ActualScope).getOperaciones().size();
                            operaciones operacion = new operaciones(nombre, ctx.getText());
                            this.Funciones.get(this.ActualScope).AddOperacion(operacion);
                        } else if (this.Procedures.containsKey(this.ActualScope)) {
                            String nombre = "Read-"+this.Procedures.get(this.ActualScope).getOperaciones().size();
                            operaciones operacion = new operaciones(nombre, ctx.getText());
                            this.Procedures.get(this.ActualScope).AddOperacion(operacion);
                        }else{
                            correcto = false;
                            int linea = ctx.getStart().getLine();
                            String Message="Error al declarar la sentencia write, la funcion o procedure no existe: ";
                            CreateMessageError(Message, linea);
                        }
                    }
                }else{
                    correcto = false;
                    int linea = ctx.getStart().getLine();
                    String Message="Error al intentar leer valor desde teclado: ";
                    CreateMessageError(Message, linea);
                }
            }
        }catch(Exception e){
            System.out.println("Error al readln: "+e);
        }
    }
    @Override public void exitRead(MiniPascalParser.ReadContext ctx) { }

    public boolean validar_valor_ingresado(Variable variable, String valor){
        boolean valido = false;
        if(isNUmber("",valor)){
            if(variable.getTipo().equalsIgnoreCase("integer")||variable.getTipo().equalsIgnoreCase("real")
            ||variable.getTipo().equalsIgnoreCase("double")){
                valido = true;
            }
        }
        if(esBooleano(valor)){
            if(variable.getTipo().equalsIgnoreCase("boolean")){
                valido = true;
            }
        }
        if(esChar(valor)){
            if(variable.getTipo().equalsIgnoreCase("char")){
                valido = true;
            }
        }
        if(esString(valor)){
            if(variable.getTipo().equalsIgnoreCase("string")){
                valido = true;
            }
        }

        return valido;
    }
    @Override public void enterProcedureDeclaration(MiniPascalParser.ProcedureDeclarationContext ctx) {
        if(correcto){

            this.ActualScope= ctx.identifier().getText();

            ArrayList<Variable>mis_parametros = new ArrayList<Variable>();


            if(ctx.formalParameterList()!=null ){
                String patron = "(\\w+(?:,\\s*\\w+)*):(\\w+)";

                // Compilar el patrón
                Pattern pattern = Pattern.compile(patron);

                // Crear un Matcher con el string de parámetros
                Matcher matcher = pattern.matcher(ctx.formalParameterList().getText());

                // Extraer las variables y sus tipos
                while (matcher.find()) {
                    String variables = matcher.group(1);
                    String tipo = matcher.group(2);

                    String[] nombresVariables = variables.split(",\\s*");
                    for (String variable : nombresVariables) {
                        if(correcto){
                            Variable tempVariable = new Variable(variable, tipo, this.ActualScope);
                            for(int i=0; i<mis_parametros.size(); i++){
                                Variable temp = mis_parametros.get(i);
                                if(temp.getNombre().equalsIgnoreCase(tempVariable.getNombre())){
                                    correcto = false;
                                }
                            }
                            if(correcto){
                                mis_parametros.add(tempVariable);
                            }
                        }
                    }
                }

            }
            if(correcto){
                if(this.Procedures.containsKey(this.ActualScope)){
                    this.correcto = false;
                    int linea = ctx.getStart().getLine();
                    String Message="Error al declarar el procedimiento; ya existe: "+ctx.identifier().getText();
                    CreateMessageError(Message, linea);
                }else{
                    Procedimiento nueva_funcion = new Procedimiento(this.ActualScope, mis_parametros);
                    this.Procedures.put(nueva_funcion.getName(), nueva_funcion);

                }
            }else{
                int linea = ctx.getStart().getLine();
                String Message="Error al declarar la funcion: "+ctx.identifier().getText();
                CreateMessageError(Message, linea);
            }

        }

    }
    @Override public void enterFunctionDeclaration(MiniPascalParser.FunctionDeclarationContext ctx) {
        if(correcto){
            this.ActualScope= ctx.identifier().getText();

            ArrayList<Variable>mis_parametros = new ArrayList<Variable>();


            if(ctx.formalParameterList()!=null ){
                String patron = "(\\w+(?:,\\s*\\w+)*):(\\w+)";

                // Compilar el patrón
                Pattern pattern = Pattern.compile(patron);

                // Crear un Matcher con el string de parámetros
                Matcher matcher = pattern.matcher(ctx.formalParameterList().getText());

                // Extraer las variables y sus tipos
                while (matcher.find()) {
                    String variables = matcher.group(1);
                    String tipo = matcher.group(2);

                    String[] nombresVariables = variables.split(",\\s*");
                    for (String variable : nombresVariables) {
                        if(correcto){
                            Variable tempVariable = new Variable(variable, tipo, this.ActualScope);
                            for(int i=0; i<mis_parametros.size(); i++){
                                Variable temp = mis_parametros.get(i);
                                if(temp.getNombre().equalsIgnoreCase(tempVariable.getNombre())){
                                    correcto = false;
                                }
                            }
                            if(correcto){
                                mis_parametros.add(tempVariable);
                            }
                        }
                    }
                }

            }
            if(correcto){
                if(this.Funciones.containsKey(this.ActualScope)){
                    this.correcto = false;
                    int linea = ctx.getStart().getLine();
                    String Message="Error al declarar la funcion, ya existe: "+ctx.identifier().getText();
                    CreateMessageError(Message, linea);
                }else{
                    if(ctx.resultType()!=null){
                        Variable result= new Variable("result",ctx.resultType().getText(), this.ActualScope);
                        Funcion nueva_funcion = new Funcion(this.ActualScope, mis_parametros, ctx.resultType().getText());
                        nueva_funcion.addSymbolInTableFunction(result);
                        this.Funciones.put(nueva_funcion.getName(), nueva_funcion);
                    }else{
                        Funcion nueva_funcion = new Funcion(this.ActualScope, mis_parametros);
                        this.Funciones.put(nueva_funcion.getName(), nueva_funcion);

                       /* String quad =nextQuad + ": " + "DECLARE_FUNC" + nueva_funcion.getResultType() + ", _, " + nueva_funcion.getName();
                        quads.add(quad);
                        nextQuad++;

                        if(mis_parametros.size()>0){
                            for(Variable var : mis_parametros){
                                String quad2 =nextQuad + ": " + "PARAM" + var.getNombre() + ", _, " + nueva_funcion.getName();
                                quads.add(quad2);
                                nextQuad++;
                            }

                        }*/

                    }

                }
            }else{
                int linea = ctx.getStart().getLine();
                String Message="Error al declarar la funcion: "+ctx.identifier().getText();
                CreateMessageError(Message, linea);
            }

        }

    }

    public boolean crear_variable(String name, String tipo){
        boolean creado = false;
        try{
            //System.out.println("ENtrea la variable: "+name+ "Scope: "+this.ActualScope+ " Scope Rutina: "+this.ScopeSubRutina);
            Variable variable = new Variable(name, tipo, this.ActualScope);
            if (this.ActualScope.equalsIgnoreCase("global") && this.ScopeSubRutina.equalsIgnoreCase("")) {
                creado= this.GlobalSymbol.addVariable(variable);
                if(creado){
                    String quad = nextQuad + ":" + "DECLARE"+ "," + variable.getTipo() + "," + "_"+ "," + variable.getNombre();
                    quads.add(quad);
                    nextQuad++;
                }
            } else if (this.ActualScope.equalsIgnoreCase("global") && !this.ScopeSubRutina.equalsIgnoreCase("")){
                if(this.GlobalSymbol.exist_variable(variable.getNombre())||
                        this.VarSubRutina.exist_variable(variable.getNombre())){
                    creado = false;
                }else{
                    //System.out.println("VAMOS  A GUARDAR: "+variable.getNombre()+" Tipo: "+variable.getTipo()+" Scope: "+variable.getScope());
                    creado = this.VarSubRutina.addVariable(variable);
                    //this.VarSubRutina.imprimir_tablas();
                    if(creado){
                        String newName = "temp_"+variable.getNombre();
                        String quad = nextQuad + ":" + "DECLARE"+ "," + variable.getTipo() + "," + "_"+ "," + newName;
                        quads.add(quad);
                        nextQuad++;
                    }
                }
            }

            if(this.Funciones.containsKey(this.ActualScope) && this.ScopeSubRutina.equalsIgnoreCase("")){
                if(name.equalsIgnoreCase("result")){
                    creado = false;
                }else{
                    creado = this.Funciones.get(this.ActualScope).addSymbolInTableFunction(variable);
                }

            }

            if(this.Procedures.containsKey(this.ActualScope)&& this.ScopeSubRutina.equalsIgnoreCase("")){

                creado = this.Procedures.get(this.ActualScope).addSymbolInTableProcedimiento(variable);
            }
        }catch(Exception e){
            System.out.println("Error en la funcion crear_variable");
        }

        return creado;
    }
    public Variable crear_variable_para_parametro(String name, String valor){

        String tipo ="null";
        if (valor.matches("-?\\d+"))
            tipo = "integer";
        if(valor.matches("-?\\d+(\\.\\d+)?"))
            tipo="double";
        if(valor.matches("-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?[fF]?"))
            tipo="real";
        if(esBooleano(valor))
            tipo="boolean";
        if (esChar(valor))
            tipo="char";
        if(esString(valor))
            tipo="string";

        Variable variable = new Variable(name, tipo, this.ActualScope, valor);
        return variable;
    }

    public void llamada_de_funcion(MiniPascalParser.FunctionDesignatorContext ctx){

        String refScope = ctx.identifier().getText();
        ArrayList<Variable> listVar = new ArrayList<>();

        for (int i = 0; i<ctx.parameterList().getChildCount(); i++){
            if(ctx.parameterList().actualParameter(i)!=null && correcto){
                MiniPascalParser.VariableContext variable = ctx.parameterList().actualParameter(i).expression().simpleExpression().term().signedFactor().factor().variable();
                if(variable== null){
                    MiniPascalParser.ExpressionContext expression = ctx.parameterList().actualParameter(i).expression();

                    String name ="C"+i;
                    Variable variableTemp = crear_variable_para_parametro(name, expression.getText());


                    listVar.add(variableTemp);
                }else{

                    if(this.ActualScope.equalsIgnoreCase("global")){
                        if(this.GlobalSymbol.exist_variable(variable.getText())){

                            Variable temp = GlobalSymbol.getVariable(variable.getText());
                            listVar.add(temp);
                        }else{
                            this.correcto=false;
                            int linea = ctx.getStart().getLine();
                            String Message="La variable no existe en el scope: "+variable.getText();
                            CreateMessageError(Message, linea);
                        }
                    }else{
                        if(this.Funciones.containsKey(this.ActualScope)){
                            if(this.Funciones.get(this.ActualScope).getSimbolos().exist_variable(variable.getText())){
                                Variable temp = this.Funciones.get(this.ActualScope).getSimbolos().getVariable(variable.getText());
                                listVar.add(temp);
                            }else{
                                this.correcto=false;
                                int linea = ctx.getStart().getLine();
                                String Message="La variable no existe en el scope: "+variable.getText();
                                CreateMessageError(Message, linea);
                            }
                        }else{
                            this.correcto=false;
                            int linea = ctx.getStart().getLine();
                            String Message="La funcion no existe : "+this.ActualScope;
                            CreateMessageError(Message, linea);
                        }
                    }

                }

            }
        }
        if(this.Funciones.containsKey(refScope)){
            Funcion tempFuncion = this.Funciones.get(refScope);
            if(tempFuncion.getNumeroParametros()== listVar.size()){

                if(consistencia_de_parametros(tempFuncion.getParametros(),listVar)){
                    int linea = ctx.getStart().getLine();
                    ejecutar_funcion(tempFuncion, listVar, linea);
                  
                }else{
                    correcto = false;
                    int linea = ctx.getStart().getLine();
                    String Message="El tipo de valor de los parametros de: "+refScope+" no conciden con los argumentos enviados";
                    CreateMessageError(Message, linea);
                }
            }else{
                correcto = false;
                int linea = ctx.getStart().getLine();
                String Message="El numero de parametros de: "+refScope+" no concide";
                CreateMessageError(Message, linea);
            }
        }else{
            correcto = false;
            int linea = ctx.getStart().getLine();
            String Message="La funcion: "+refScope+" no existe";
            CreateMessageError(Message, linea);
        }
    }


    public boolean consistencia_de_parametros(ArrayList<Variable> parametros, ArrayList<Variable>argumentos){
        boolean consistencia = true;
        for(int i = 0; i <parametros.size(); i++){
            Variable param = parametros.get(i);
            Variable argu = argumentos.get(i);
            if(!param.getTipo().equalsIgnoreCase(argu.getTipo()))
                consistencia=false;
        }
        return consistencia;
    }

    public void ejecutar_funcion(Funcion funcion, ArrayList<Variable>argumentos, int linea){
        //primero procedemos a actualizar el valor de los parametros de la funcion
        boolean valido = true;
        for(int i = 0; i<argumentos.size(); i++){
            Variable argu = argumentos.get(i);
            funcion.getParametros().get(i).setValor(argu.getValor());
        }
        ArrayList<operaciones> Operaciones = funcion.getOperaciones();
        for(operaciones Op: Operaciones){
            if(valido){
                if(Op.getNameOperacion().contains("Inicializacion")){

                    valido = ejecutar_inicializacion_en_funcion(funcion, Op.getExpresion(), linea);
                }
                if(Op.getNameOperacion().contains("Write")){
                    valido = ejecutar_write_funciones(funcion, Op.getExpresion(), Op.getNameOperacion(),linea);
                }
                if(Op.getNameOperacion().contains("Read")){
                    valido = ejecutar_read_funciones(funcion, Op.getExpresion(), Op.getNameOperacion(),linea);
                }
                if(Op.getNameOperacion().contains("Repeat")){

                    //valido = ejecutar_read_funciones(funcion, Op.getExpresion(), Op.getNameOperacion(),linea);
                }
            }else{
                correcto = false;
            }
        }
        //ahora procedemos a ejecutar instruccion de la funcion como inicializar variables etc.


    }
    public boolean ejecutar_read_funciones(Funcion funcion, String expresion, String nameOp, int linea){
        boolean valido = false;
        try{
            if(correcto){

                if(expresion.length()>8){
                    String operador = expresion.substring(0,6);
                    String cuerpoOperacion = expresion.substring(7, expresion.length()-1);

                    if(operador.equalsIgnoreCase("readln")){

                        if(this.Funciones.containsKey(funcion.getName())){
                            if(this.Funciones.get(funcion.getName()).getSimbolos().exist_variable(cuerpoOperacion)){
                                Variable variable = this.Funciones.get(funcion.getName()).getSimbolos().getVariable(cuerpoOperacion);
                                Scanner scanner = new Scanner(System.in);
                                String valorIngresado = scanner.nextLine();
                                boolean exacto = validar_valor_ingresado(variable,valorIngresado);
                                if(exacto){
                                    valido = true;
                                    this.Funciones.get(funcion.getName()).getSimbolos().getVariable(cuerpoOperacion).setValor(valorIngresado);
                                }else{
                                    valido= false;
                                    String Message="Error valor ingresado no corresponde al tipo de variable: "+expresion;
                                    CreateMessageError(Message, linea);
                                }
                            }
                        }
                    }
                }else{
                    valido= false;
                    String Message="Error expresion read mal declarada: "+expresion;
                    CreateMessageError(Message, linea);
                }

            }
        }catch(Exception e){
            System.out.println("Error al ejecutar el rea de funciones: "+e);
        }
        return valido;
    }

    public boolean ejecutar_write_funciones(Funcion funcion, String expresion, String nameOp, int linea){
        boolean valido = true;
        try{
            Pattern pattern = Pattern.compile("\\((.*?)\\)");
            Matcher matcher = pattern.matcher(expresion);

            if (matcher.find()) {
                String content = matcher.group(1);
                String resultado ="";
                String [] partes = content.split(",");
                if(partes.length>0){
                    for(String element: partes){
                        if(valido){
                            if(element.charAt(0)=='\'' && element.charAt(element.length()-1)=='\''){
                                resultado+= element;
                            }else{
                                if(funcion.getSimbolos().exist_variable(element)){
                                    resultado+= funcion.getSimbolos().getVariable(element).getValor();

                                }else{
                                    valido= false;
                                    String Message="Error en el contenido de la  sentencia write: "+expresion;
                                    CreateMessageError(Message, linea);
                                }
                            }
                        }
                    }
                }else{
                    resultado= content;
                }

                if(valido){
                    String newMessage = "";
                    for(int j = 0; j<resultado.length(); j++){
                        String letra =""+resultado.charAt(j);
                        if(!letra.equalsIgnoreCase("'")){
                            newMessage+=letra;
                        }
                    }
                    System.out.println(newMessage);
                    valido = this.Funciones.get(funcion.getName()).setOperacion(nameOp, resultado);
                }
            }else{
                valido = false;
                String Message="Error en el contenido de la  sentencia write: "+expresion;
                CreateMessageError(Message, linea);
            }
        }catch(Exception e){
            System.out.println("Error en la funcion ejecutar_write_funciones");
        }


        return valido;
    }
    public boolean ejecutar_inicializacion_en_funcion(Funcion funcion, String expresion, int linea){
        try {
            String[] partes = expresion.split(":=");
            String left = partes[0];
            String operacion = partes[1];
            boolean valido = true;
            Variable varLeft = null;
            if (funcion.getSimbolos().exist_variable(left)) {
                varLeft = funcion.getSimbolos().getVariable(left);
            }
            for (Variable var : funcion.getParametros()) {
                if (left.equalsIgnoreCase(var.getNombre())) {
                    varLeft = var;
                }
            }
            if (varLeft != null) {

                if (varLeft.getTipo().equalsIgnoreCase("integer") || varLeft.getTipo().equalsIgnoreCase("real")
                        || varLeft.getTipo().equalsIgnoreCase("double")) {
                    //verificamos  si la expresion de operacion contiene  variables y reeplazamos con los valores

                    for (Variable temp : funcion.getParametros()) {
                        if (operacion.contains(temp.getNombre())) {
                            operacion = operacion.replace(temp.getNombre(), temp.getValor());
                        }
                    }
                    for (Map.Entry<String, Variable> entry : funcion.getSimbolos().variable.entrySet()) {
                        Variable value = entry.getValue();
                        if (operacion.contains(value.getNombre()) && !value.getNombre().equalsIgnoreCase("result")) {

                            operacion = operacion.replace(value.getNombre(), value.getValor());
                        }

                    }
                    if (isNUmber("null", operacion)) {
                        if (this.Funciones.get(funcion.getName()).getSimbolos().exist_variable(varLeft.getNombre())) {
                            this.Funciones.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                        }
                    } else if (isOperacion_aritmetica(operacion)) {
                       // System.out.println("Es operacion aritmetica: "+operacion);
                        operacion = "" + evaluarOperacion(operacion);

                        this.Funciones.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                    } else {
                        valido = false;
                        String Message="Error al asignar valor numerico a: "+varLeft.getNombre();
                        CreateMessageError(Message, linea);
                    }
                }
                if (varLeft.getTipo().equalsIgnoreCase("String")) {

                    String nuevaString = "";
                    String[] secciones = operacion.split("\\+");
                    for (String parte : secciones) {
                        boolean isVariable = false;
                        for (Variable temp : funcion.getParametros()) {
                            if (parte.equalsIgnoreCase(temp.getNombre())) {
                                isVariable = true;
                                nuevaString += temp.getValor();
                            }
                        }
                        for (Map.Entry<String, Variable> entry : funcion.getSimbolos().variable.entrySet()) {
                            Variable value = entry.getValue();
                            if (parte.equalsIgnoreCase(value.getNombre())) {
                                isVariable = true;
                                nuevaString += value.getValor();
                            }
                        }
                        if (!isVariable) {
                            nuevaString += parte;
                        }
                    }
                    operacion = nuevaString;
                    this.Funciones.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                }
                if (varLeft.getTipo().equalsIgnoreCase("char")) {

                    for (Variable temp : funcion.getParametros()) {
                        if (operacion.equalsIgnoreCase(temp.getNombre())) {
                            operacion = temp.getValor();
                        }
                    }
                    for (Map.Entry<String, Variable> entry : funcion.getSimbolos().variable.entrySet()) {
                        Variable value = entry.getValue();
                        if (operacion.equalsIgnoreCase(value.getNombre())) {
                            operacion = value.getValor();
                        }
                    }
                    String firstChar = "" + operacion.charAt(0);
                    String lastChar = "" + operacion.charAt(operacion.length() - 1);
                    if (operacion.length() == 3 && firstChar.equalsIgnoreCase("'") && lastChar.equalsIgnoreCase("'")) {
                        this.Funciones.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                    } else {
                        valido = false;
                    }
                }
                if (varLeft.getTipo().equalsIgnoreCase("boolean")) {

                    for (Variable temp : funcion.getParametros()) {
                        if (operacion.contains(temp.getNombre())) {
                            operacion = operacion.replace(temp.getNombre(), temp.getValor());
                        }
                    }
                    for (Map.Entry<String, Variable> entry : funcion.getSimbolos().variable.entrySet()) {
                        Variable value = entry.getValue();
                        if (operacion.contains(value.getNombre()) && !value.getNombre().equalsIgnoreCase("result")) {

                            operacion = operacion.replace(value.getNombre(), value.getValor());
                        }

                    }
                    if (esBooleano(operacion)) {
                        if (this.Funciones.get(funcion.getName()).getSimbolos().exist_variable(varLeft.getNombre())) {
                            this.Funciones.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                        }
                    } else if (isOperacion_boolena(operacion)) {

                        operacion = "" + evaluateBooleanExpression(operacion);

                        this.Funciones.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                    } else {
                        valido = false;
                        String Message="Error al asignar valor booleano a: "+varLeft.getNombre();
                        CreateMessageError(Message, linea);
                    }
                }

            } else {
                valido = false;
                String Message="No existe variable recibiendo el resultado de la funcion: "+funcion.getName();
                CreateMessageError(Message, linea);
            }

            return valido;
        }catch(Exception e){
            return false;
        }
    }

    //-----------------------------------ANALIZAR Y EJECUTAR PROCEDURES-------------------------------------------
    public void llamada_de_procedure(MiniPascalParser.ProcedureStatementContext ctx){

        String refScope = ctx.identifier().getText();
        ArrayList<Variable> listVar = new ArrayList<>();

        for (int i = 0; i<ctx.parameterList().getChildCount(); i++){
            if(ctx.parameterList().actualParameter(i)!=null && correcto){
                MiniPascalParser.VariableContext variable = ctx.parameterList().actualParameter(i).expression().simpleExpression().term().signedFactor().factor().variable();
                if(variable== null){
                    MiniPascalParser.ExpressionContext expression = ctx.parameterList().actualParameter(i).expression();

                    String name ="C"+i;
                    Variable variableTemp = crear_variable_para_parametro(name, expression.getText());


                    listVar.add(variableTemp);
                }else{

                    if(this.ActualScope.equalsIgnoreCase("global")){
                        if(this.GlobalSymbol.exist_variable(variable.getText())){

                            Variable temp = GlobalSymbol.getVariable(variable.getText());
                            listVar.add(temp);
                        }else{
                            this.correcto=false;
                            int linea = ctx.getStart().getLine();
                            String Message="La variable no existe en el scope: "+variable.getText();
                            CreateMessageError(Message, linea);
                        }
                    }else{
                        if(this.Funciones.containsKey(this.ActualScope)){
                            if(this.Funciones.get(this.ActualScope).getSimbolos().exist_variable(variable.getText())){
                                Variable temp = this.Funciones.get(this.ActualScope).getSimbolos().getVariable(variable.getText());
                                listVar.add(temp);
                            }else{
                                this.correcto=false;
                                int linea = ctx.getStart().getLine();
                                String Message="La variable no existe en el scope: "+variable.getText();
                                CreateMessageError(Message, linea);
                            }
                        }else{
                            this.correcto=false;
                            int linea = ctx.getStart().getLine();
                            String Message="La funcion no existe : "+this.ActualScope;
                            CreateMessageError(Message, linea);
                        }
                        if(this.Procedures.containsKey(this.ActualScope)){
                            if(this.Procedures.get(this.ActualScope).getSimbolos().exist_variable(variable.getText())){
                                Variable temp = this.Procedures.get(this.ActualScope).getSimbolos().getVariable(variable.getText());
                                listVar.add(temp);
                            }else{
                                this.correcto=false;
                                int linea = ctx.getStart().getLine();
                                String Message="La variable no existe en el scope: "+variable.getText();
                                CreateMessageError(Message, linea);
                            }
                        }else{
                            this.correcto=false;
                            int linea = ctx.getStart().getLine();
                            String Message="El Procedure no existe : "+this.ActualScope;
                            CreateMessageError(Message, linea);
                        }
                    }
                    //listVar.add(ctx.parameterList().actualParameter(i).getText());

                }

            }
        }
        if(this.Procedures.containsKey(refScope)){
            Procedimiento tempProcedure = this.Procedures.get(refScope);
            if(tempProcedure .getNumeroParametros()== listVar.size()){
                //lo siguinete es validar que el tipo de valor corresponde entre argumentos y parametros
                if(consistencia_de_parametros(tempProcedure .getParametros(),listVar)){
                    int linea = ctx.getStart().getLine();
                    ejecutar_procedure(tempProcedure, listVar, linea);

                }else{
                    correcto = false;
                    int linea = ctx.getStart().getLine();
                    String Message="El tipo de valor de los parametros de: "+refScope+" no conciden con los argumentos enviados";
                    CreateMessageError(Message, linea);
                }
            }else{
                correcto = false;
                int linea = ctx.getStart().getLine();
                String Message="El numero de parametros de: "+refScope+" no concide";
                CreateMessageError(Message, linea);
            }
        }else{
            correcto = false;
            int linea = ctx.getStart().getLine();
            String Message="La funcion: "+refScope+" no existe";
            CreateMessageError(Message, linea);
        }
    }

    public void ejecutar_procedure(Procedimiento funcion, ArrayList<Variable>argumentos, int linea){
        //primero procedemos a actualizar el valor de los parametros de la funcion
        boolean valido = true;
        for(int i = 0; i<argumentos.size(); i++){
            Variable argu = argumentos.get(i);
            funcion.getParametros().get(i).setValor(argu.getValor());
        }
        ArrayList<operaciones> Operaciones = funcion.getOperaciones();
        for(operaciones Op: Operaciones){
            if(valido){
                if(Op.getNameOperacion().contains("Inicializacion")){
                    valido = ejecutar_inicializacion_en_procedure(funcion, Op.getExpresion(), linea);
                }
                if(Op.getNameOperacion().contains("Write")){
                    valido = ejecutar_write_procedures(funcion, Op.getExpresion(), Op.getNameOperacion(),linea);
                }
                if(Op.getNameOperacion().contains("Read")){
                    valido = ejecutar_read_Prodcedure(funcion, Op.getExpresion(), Op.getNameOperacion(),linea);
                }
            }else{
                correcto = false;
            }
        }
        //ahora procedemos a ejecutar instruccion de la funcion como inicializar variables etc.


    }
    public boolean ejecutar_write_procedures(Procedimiento funcion, String expresion, String nameOp, int linea){
        boolean valido = true;
        try{
            Pattern pattern = Pattern.compile("\\((.*?)\\)");
            Matcher matcher = pattern.matcher(expresion);

            if (matcher.find()) {
                String content = matcher.group(1);
                String resultado ="";
                String [] partes = content.split(",");
                if(partes.length>0){
                    for(String element: partes){
                        if(valido){
                            if(element.charAt(0)=='\'' && element.charAt(element.length()-1)=='\''){
                                resultado+= element;
                            }else{
                                if(funcion.getSimbolos().exist_variable(element)){
                                    resultado+= funcion.getSimbolos().getVariable(element).getValor();

                                }else{
                                    valido= false;
                                    String Message="Error en el contenido de la  sentencia write: "+expresion;
                                    CreateMessageError(Message, linea);
                                }
                            }
                        }
                    }
                }else{
                    resultado= content;
                }

                if(valido){
                    String newMessage = "";
                    for(int j = 0; j<resultado.length(); j++){
                        String letra =""+resultado.charAt(j);
                        if(!letra.equalsIgnoreCase("'")){
                            newMessage+=letra;
                        }
                    }
                    System.out.println(newMessage);
                    valido = this.Procedures.get(funcion.getName()).setOperacion(nameOp, resultado);
                }
            }else{
                valido = false;
                String Message="Error en el contenido de la  sentencia write: "+expresion;
                CreateMessageError(Message, linea);
            }
        }catch(Exception e){
            System.out.println("Error en la funcion ejecutar_write_funciones");
        }


        return valido;
    }
    public boolean ejecutar_read_Prodcedure(Procedimiento funcion, String expresion, String nameOp, int linea){
        boolean valido = false;
        try{
            if(correcto){

                if(expresion.length()>8){
                    String operador = expresion.substring(0,6);
                    String cuerpoOperacion = expresion.substring(7, expresion.length()-1);

                    if(operador.equalsIgnoreCase("readln")){

                        if(this.Procedures.containsKey(funcion.getName())){
                            if(this.Procedures.get(funcion.getName()).getSimbolos().exist_variable(cuerpoOperacion)){
                                Variable variable = this.Procedures.get(funcion.getName()).getSimbolos().getVariable(cuerpoOperacion);
                                Scanner scanner = new Scanner(System.in);
                                String valorIngresado = scanner.nextLine();
                                boolean exacto = validar_valor_ingresado(variable,valorIngresado);
                                if(exacto){
                                    valido = true;
                                    this.Procedures.get(funcion.getName()).getSimbolos().getVariable(cuerpoOperacion).setValor(valorIngresado);
                                }else{
                                    valido= false;
                                    String Message="Error valor ingresado no corresponde al tipo de variable: "+expresion;
                                    CreateMessageError(Message, linea);
                                }
                            }
                        }
                    }
                }else{
                    valido= false;
                    String Message="Error expresion read mal declarada: "+expresion;
                    CreateMessageError(Message, linea);
                }

            }
        }catch(Exception e){
            System.out.println("Error al ejecutar el rea de funciones: "+e);
        }
        return valido;
    }
    public boolean ejecutar_inicializacion_en_procedure(Procedimiento funcion, String expresion, int linea){
        try {
            String[] partes = expresion.split(":=");
            String left = partes[0];
            String operacion = partes[1];
            boolean valido = true;
            Variable varLeft = null;
            if (funcion.getSimbolos().exist_variable(left)) {
                varLeft = funcion.getSimbolos().getVariable(left);
            }
            for (Variable var : funcion.getParametros()) {
                if (left.equalsIgnoreCase(var.getNombre())) {
                    varLeft = var;
                }
            }
            if (varLeft != null) {

                if (varLeft.getTipo().equalsIgnoreCase("integer") || varLeft.getTipo().equalsIgnoreCase("real")
                        || varLeft.getTipo().equalsIgnoreCase("double")) {
                    //verificamos  si la expresion de operacion contiene  variables y reeplazamos con los valores

                    for (Variable temp : funcion.getParametros()) {
                        if (operacion.contains(temp.getNombre())) {
                            operacion = operacion.replace(temp.getNombre(), temp.getValor());
                        }
                    }
                    for (Map.Entry<String, Variable> entry : funcion.getSimbolos().variable.entrySet()) {
                        Variable value = entry.getValue();
                        if (operacion.contains(value.getNombre()) && !value.getNombre().equalsIgnoreCase("result")) {

                            operacion = operacion.replace(value.getNombre(), value.getValor());
                        }

                    }
                    if (isNUmber("null", operacion)) {
                        if (this.Procedures.get(funcion.getName()).getSimbolos().exist_variable(varLeft.getNombre())) {
                            this.Procedures.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                        }
                    } else if (isOperacion_aritmetica(operacion)) {

                        operacion = "" + evaluarOperacion(operacion);

                        this.Procedures.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                    } else {
                        valido = false;
                        String Message="Error al asignar valor numerico a: "+varLeft.getNombre();
                        CreateMessageError(Message, linea);
                    }
                }
                if (varLeft.getTipo().equalsIgnoreCase("String")) {

                    String nuevaString = "";
                    String[] secciones = operacion.split("\\+");
                    for (String parte : secciones) {
                        boolean isVariable = false;
                        for (Variable temp : funcion.getParametros()) {
                            if (parte.equalsIgnoreCase(temp.getNombre())) {
                                isVariable = true;
                                nuevaString += temp.getValor();
                            }
                        }
                        for (Map.Entry<String, Variable> entry : funcion.getSimbolos().variable.entrySet()) {
                            Variable value = entry.getValue();
                            if (parte.equalsIgnoreCase(value.getNombre())) {
                                isVariable = true;
                                nuevaString += value.getValor();
                            }
                        }
                        if (!isVariable) {
                            nuevaString += parte;
                        }
                    }
                    operacion = nuevaString;
                    this.Procedures.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                }
                if (varLeft.getTipo().equalsIgnoreCase("char")) {

                    for (Variable temp : funcion.getParametros()) {
                        if (operacion.equalsIgnoreCase(temp.getNombre())) {
                            operacion = temp.getValor();
                        }
                    }
                    for (Map.Entry<String, Variable> entry : funcion.getSimbolos().variable.entrySet()) {
                        Variable value = entry.getValue();
                        if (operacion.equalsIgnoreCase(value.getNombre())) {
                            operacion = value.getValor();
                        }
                    }
                    String firstChar = "" + operacion.charAt(0);
                    String lastChar = "" + operacion.charAt(operacion.length() - 1);
                    if (operacion.length() == 3 && firstChar.equalsIgnoreCase("'") && lastChar.equalsIgnoreCase("'")) {
                        this.Procedures.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                    } else {
                        valido = false;
                    }
                }
                if (varLeft.getTipo().equalsIgnoreCase("boolean")) {

                    for (Variable temp : funcion.getParametros()) {
                        if (operacion.contains(temp.getNombre())) {
                            operacion = operacion.replace(temp.getNombre(), temp.getValor());
                        }
                    }
                    for (Map.Entry<String, Variable> entry : funcion.getSimbolos().variable.entrySet()) {
                        Variable value = entry.getValue();
                        if (operacion.contains(value.getNombre()) && !value.getNombre().equalsIgnoreCase("result")) {

                            operacion = operacion.replace(value.getNombre(), value.getValor());
                        }

                    }
                    if (esBooleano(operacion)) {
                        if (this.Procedures.get(funcion.getName()).getSimbolos().exist_variable(varLeft.getNombre())) {
                            this.Procedures.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                        }
                    } else if (isOperacion_boolena(operacion)) {

                        operacion = "" + evaluateBooleanExpression(operacion);

                        this.Procedures.get(funcion.getName()).getSimbolos().actualizarValorDeVariable(varLeft, operacion);
                    } else {
                        valido = false;
                        String Message="Error al asignar valor booleano a: "+varLeft.getNombre();
                        CreateMessageError(Message, linea);
                    }
                }

            } else {
                valido = false;
                String Message="No existe variable recibiendo el resultado de la funcion: "+funcion.getName();
                CreateMessageError(Message, linea);
            }

            return valido;
        }catch(Exception e){
            return false;
        }
    }
    //-----------------------------------------------------------------------------------------------------------
    public void Actualizar_valor_de_variable(Variable variable, String valor){
        try{
            if(variable.getScope().equalsIgnoreCase("global")&& this.ScopeSubRutina.equalsIgnoreCase("")){
                if(this.GlobalSymbol.exist_variable(variable.getNombre())){
                    boolean valido= this.GlobalSymbol.actualizarValorDeVariable(variable, valor);
                    if(valido){
                        String quad =nextQuad + ":" + "ASSIGN," + valor +","+ variable.getTipo()+"," + variable.getNombre();
                        quads.add(quad);
                        nextQuad++;
                    }
                }

            }else {
                if(this.Funciones.containsKey(this.ActualScope)){
                    if(this.Funciones.get(this.ActualScope).getSimbolos().exist_variable(variable.getNombre())){
                        boolean valido = this.Funciones.get(this.ActualScope).actualizarValorDeVariable(variable, valor);
                        if(valido){
                            String quad =nextQuad + ":" + "ASSIGN," + valor +","+ variable.getTipo()+"," + variable.getNombre();
                            quads.add(quad);
                            nextQuad++;
                        }
                    }
                }

            }
        }catch(Exception e){
            System.out.println("Error en la funcion actualizar valor de variable"+ e);
        }

    }


    //-------------------------------Resolver operaciones aritmeticas------------------------

    public  int evaluarOperacion(String operacion) {
        operacion = operacion.replaceAll("\\s+", "");
        Stack<Integer> operandos = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < operacion.length(); i++) {
            char c = operacion.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < operacion.length() && Character.isDigit(operacion.charAt(i))) {
                    sb.append(operacion.charAt(i));
                    i++;
                }
                i--;
                operandos.push(Integer.parseInt(sb.toString()));
            } else if (esOperador(c)) {
                while (!operadores.isEmpty() && operadores.peek() != '(' && precedencia(operadores.peek()) >= precedencia(c)) {
                    int segundoOperando = operandos.pop();
                    int primerOperando = operandos.pop();
                    char operador = operadores.pop();
                    int resultado = aplicarOperacion(primerOperando, segundoOperando, operador);
                    operandos.push(resultado);
                }
                operadores.push(c);
            } else if (c == '(') {
                operadores.push(c);
            } else if (c == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    int segundoOperando = operandos.pop();
                    int primerOperando = operandos.pop();
                    char operador = operadores.pop();
                    int resultado = aplicarOperacion(primerOperando, segundoOperando, operador);
                    operandos.push(resultado);
                }
                if (!operadores.isEmpty() && operadores.peek() == '(') {
                    operadores.pop();
                }
            }
        }

        while (!operadores.isEmpty()) {
            int segundoOperando = operandos.pop();
            int primerOperando = operandos.pop();
            char operador = operadores.pop();
            int resultado = aplicarOperacion(primerOperando, segundoOperando, operador);
            operandos.push(resultado);
        }

        return operandos.pop();
    }

    public  boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public  int precedencia(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public  int aplicarOperacion(int a, int b, char operador) {
        switch (operador) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }
    //---------------------------------------------------------------------------------------

    //---------------------------RESOLVER OPERACIONES BOOLEANAS-------------------------------

    public boolean evaluateBooleanExpression(String expression) {
        expression = expression.replaceAll("\\s", ""); // Eliminar espacios en blanco de la expresión

        // Evaluar la expresión utilizando recursión
        return evaluateExpression(expression);
    }

    private boolean evaluateExpression(String expression) {
        if (!expression.contains("(")) {
            return evaluateSimpleExpression(expression);
        }

        int openingIndex = expression.lastIndexOf("(");
        int closingIndex = expression.indexOf(")", openingIndex);

        String subExpression = expression.substring(openingIndex + 1, closingIndex);
        boolean subExpressionResult = evaluateSimpleExpression(subExpression);

        String newExpression = expression.substring(0, openingIndex) + subExpressionResult + expression.substring(closingIndex + 1);
        return evaluateExpression(newExpression);
    }

    private boolean evaluateSimpleExpression(String expression) {
        if (expression.contains("&&")) {
            String[] operands = expression.split("&&");
            boolean operand1 = evaluateComparison(operands[0]);
            boolean operand2 = evaluateComparison(operands[1]);
            return operand1 && operand2;
        } else if (expression.contains("||")) {
            String[] operands = expression.split("\\|\\|");
            boolean operand1 = evaluateComparison(operands[0]);
            boolean operand2 = evaluateComparison(operands[1]);
            return operand1 || operand2;
        } else {
            return evaluateComparison(expression);
        }
    }

    private boolean evaluateComparison(String comparison) {
        if (comparison.contains("==")) {
            String[] operands = comparison.split("==");
            return operands[0].equals(operands[1]);
        } else if (comparison.contains(">=")) {
            String[] operands = comparison.split(">=");
            Double operand1 = Double.parseDouble(operands[0]);
            Double operand2 = Double.parseDouble(operands[1]);
            return operand1 >= operand2;
        } else if (comparison.contains(">")) {
            String[] operands = comparison.split(">");
            Double operand1 = Double.parseDouble(operands[0]);
            Double operand2 = Double.parseDouble(operands[1]);
            return operand1 > operand2;
        } else if (comparison.contains("<=")) {
            String[] operands = comparison.split("<=");
            Double operand1 = Double.parseDouble(operands[0]);
            Double operand2 = Double.parseDouble(operands[1]);
            return operand1 <= operand2;
        } else if (comparison.contains("<")) {
            String[] operands = comparison.split("<");
            Double operand1 = Double.parseDouble(operands[0]);
            Double operand2 = Double.parseDouble(operands[1]);
            return operand1 < operand2;
        } else {
            correcto = false;
            throw new IllegalArgumentException("Expresión de comparación inválida: " + comparison);
        }
    }
    //-----------------------------------------------------------------------------------------
    @Override public void enterRepeatStatement(MiniPascalParser.RepeatStatementContext ctx) {
        try{

            if(correcto){

                if(!this.ScopeSubRutina.equalsIgnoreCase("") && this.ActualScope.equalsIgnoreCase("global")){
                    //necesitamos validar que el until sea valido
                    if(ctx.expression()!=null){
                        String nuevaExpression = reestructurar_operacion(ctx.expression().getText());
                       // System.out.println("LA NUEVA EXPRESION DE UNTIL ES: "+nuevaExpression);
                        boolean sigue = true;
                        if(isOperacion_boolena(nuevaExpression)){

                            if(ctx.statements()!=null){
                                do {
                                    if (correcto) {
                                        //System.out.println("EL condicionar va: "+nuevaExpression);

                                        String[] procesos = ctx.statements().getText().split(";");
                                        for (String parte : procesos) {
                                            //-------------------Veremos si es writeln-------------------
                                            if(parte.contains("write")|| parte.contains("WRITE")|| parte.contains("writeln")|| parte.contains("WRITELN")){
                                                String subWrite = parte.substring(0,10);
                                                String subWriteln = parte.substring(0,12);
                                                if(subWriteln.equalsIgnoreCase("beginwriteln")||subWrite.equalsIgnoreCase("beginwrite")){
                                                    String []componentes = parte.split("\\(");
                                                    String texto = componentes[1];
                                                    String textoMejorado = texto.substring(0, texto.length()-1);
                                                    int linea = ctx.getStart().getLine();
                                                    imprimir_en_rutina(textoMejorado, linea);
                                                }else{
                                                    subWrite = parte.substring(0,5);
                                                    subWriteln = parte.substring(0,7);
                                                    if(subWriteln.equalsIgnoreCase("writeln")||subWrite.equalsIgnoreCase("write")){
                                                        int linea = ctx.getStart().getLine();
                                                        String []componentes = parte.split("\\(");
                                                        String texto = componentes[1];
                                                        String textoMejorado = texto.substring(0, texto.length()-1);
                                                        imprimir_en_rutina(textoMejorado, linea);
                                                    }
                                                }
                                            }
                                            //------------------------------Verificar si es inicializacion--------------------------
                                            String regexInicializacio = "\\b(?:\\w+(?:,\\s+)?)+\\s*:=\\s*\\S+";
                                            boolean matches = Pattern.matches(regexInicializacio, parte);
                                            if (matches) {
                                                //System.out.println(parte + " Es una inicializacion de variable existente");
                                                String[] segmentos = parte.split(":=");
                                                String left = segmentos[0];
                                                Variable variable = null;
                                                if(this.GlobalSymbol.exist_variable(left)){
                                                    variable = this.GlobalSymbol.getVariable(left);
                                                }
                                                if(this.VarSubRutina.exist_variable(left)){
                                                    variable = this.VarSubRutina.getVariable(left);
                                                }
                                                if(variable!=null){
                                                    String tipo = variable.getTipo();
                                                    boolean numerico = tipo.equalsIgnoreCase("integer")|| tipo.equalsIgnoreCase("real")
                                                            ||tipo.equalsIgnoreCase("double");

                                                    String reemplazo = reestructurar_operacion(segmentos[1]);
                                                   // System.out.println("EL originar segmento: "+segmentos[1]);
                                                   // System.out.println("El reempalzo: "+reemplazo);
                                                    if(isNUmber("0",reemplazo)&& numerico){
                                                        //System.out.println("eS NUMERO");
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                    }else if(isOperacion_aritmetica(reemplazo)&& numerico){
                                                        String solucion = ""+evaluarOperacion(reemplazo);
                                                        //System.out.println("ES OPERACION ARITMETICA "+reemplazo);
                                                        //System.out.println("solucion: "+solucion);
                                                        Actualizar_valor_de_variableRutina(variable, solucion);
                                                    }else if(variable.getTipo().equalsIgnoreCase("String")&& esString(reemplazo)){
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);

                                                    }else if(variable.getTipo().equalsIgnoreCase("char") && esChar(reemplazo)){
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                    }else if(variable.getTipo().equalsIgnoreCase("boolean")&& esBooleano(reemplazo)){
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                    }else if (variable.getTipo().equalsIgnoreCase("boolean")&& isOperacion_boolena(reemplazo)){
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                    } else{
                                                        correcto = false;
                                                        String error = "error en compatibidad de tipo y valores: "+ variable.getNombre();
                                                        int linea = ctx.getStart().getLine();
                                                        CreateMessageError(error, linea);
                                                    }
                                                }else{
                                                    correcto = false;
                                                    String error = "No existe variable en el repeat o global";
                                                    int linea = ctx.getStart().getLine();
                                                    CreateMessageError(error, linea);
                                                }

                                            }
                                            //------------------------------fin inicializacion-------------------------
                                        }
                                    }
                                    nuevaExpression = reestructurar_operacion(ctx.expression().getText());
                                    sigue = evaluateBooleanExpression(nuevaExpression);
                                }while(sigue && correcto);
                                //this.ScopeSubRutina="";
                                String quad2 =nextQuad + ":" + "FINAL_REPEAT,"+ctx.expression().getText()+",_,exit:";
                                quads.add(quad2);
                                nextQuad++;
                                this.VarSubRutina=new TableSymbol("GlobalTemporales");
                            }else{
                                correcto = false;
                                String error = "Error: debe haber argumentos o accione que permitan salir del loop";
                                int linea = ctx.getStart().getLine();
                                CreateMessageError(error, linea);
                            }
                        }else{
                            correcto = false;
                            String error = "Error el condicional, debe retornar un valor booleano";
                            int linea = ctx.getStart().getLine();
                            CreateMessageError(error, linea);
                        }


                    }else{
                        correcto = false;
                        String error = "Error el condicional, debe retornar un valor booleano";
                        int linea = ctx.getStart().getLine();
                        CreateMessageError(error, linea);
                    }

                }
            }else{
                System.out.println("ALGO FALOO");
            }
        }catch(Exception e){
            correcto = false;
            System.out.println("ALgo salio mal en el bloque repeat del global");
        }
    }
    @Override public void enterWhileStatement(MiniPascalParser.WhileStatementContext ctx) {
        try{
            if(correcto){

                if(!this.ScopeSubRutina.equalsIgnoreCase("") && this.ActualScope.equalsIgnoreCase("global")){
                    //necesitamos validar que el until sea valido
                    if(ctx.expression()!=null){
                        String nuevaExpression = reestructurar_operacion(ctx.expression().getText());
                        // System.out.println("LA NUEVA EXPRESION DE UNTIL ES: "+nuevaExpression);
                        boolean sigue = true;
                        int linea = ctx.getStart().getLine();
                        if(isOperacion_boolena(nuevaExpression)){

                            if(ctx.statements()!=null){
                                nuevaExpression = reestructurar_operacion(ctx.expression().getText());
                                sigue = evaluateBooleanExpression(nuevaExpression);

                                while(sigue && correcto) {
                                    if (correcto) {
                                        //System.out.println("EL condicionar va: "+nuevaExpression);

                                        String[] procesos = ctx.statements().getText().split(";");
                                        for (String parte : procesos) {
                                            //-------------------Veremos si es writeln-------------------
                                            if(parte.contains("write")|| parte.contains("WRITE")|| parte.contains("writeln")|| parte.contains("WRITELN")){
                                                String subWrite = parte.substring(0,10);
                                                String subWriteln = parte.substring(0,12);
                                                if(subWriteln.equalsIgnoreCase("beginwriteln")||subWrite.equalsIgnoreCase("beginwrite")){
                                                    String []componentes = parte.split("\\(");
                                                    String texto = componentes[1];
                                                    String textoMejorado = texto.substring(0, texto.length()-1);
                                                    imprimir_en_rutina(textoMejorado, linea);
                                                }else{
                                                     subWrite = parte.substring(0,5);
                                                    subWriteln = parte.substring(0,7);

                                                    if(subWriteln.equalsIgnoreCase("writeln")||subWrite.equalsIgnoreCase("write")){
                                                        String []componentes = parte.split("\\(");
                                                        String texto = componentes[1];
                                                        String textoMejorado = texto.substring(0, texto.length()-1);
                                                        imprimir_en_rutina(textoMejorado, linea);
                                                    }
                                                }
                                            }
                                            //----------Varemos si es inicializacion de variable----------------
                                            String regexInicializacio = "\\b(?:\\w+(?:,\\s+)?)+\\s*:=\\s*\\S+";
                                            boolean matches = Pattern.matches(regexInicializacio, parte);
                                            if (matches) {
                                                //System.out.println(parte + " Es una inicializacion de variable existente");
                                                String[] segmentos = parte.split(":=");
                                                String left = segmentos[0];
                                                Variable variable = null;
                                                if(this.GlobalSymbol.exist_variable(left)){
                                                    variable = this.GlobalSymbol.getVariable(left);
                                                }
                                                if(this.VarSubRutina.exist_variable(left)){
                                                    variable = this.VarSubRutina.getVariable(left);
                                                }
                                                if(variable!=null){
                                                    String tipo = variable.getTipo();
                                                    boolean numerico = tipo.equalsIgnoreCase("integer")|| tipo.equalsIgnoreCase("real")
                                                            ||tipo.equalsIgnoreCase("double");

                                                    String reemplazo = reestructurar_operacion(segmentos[1]);
                                                    // System.out.println("EL originar segmento: "+segmentos[1]);
                                                    // System.out.println("El reempalzo: "+reemplazo);
                                                    if(isNUmber("0",reemplazo)&& numerico){
                                                        //System.out.println("eS NUMERO");
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                    }else if(isOperacion_aritmetica(reemplazo)&& numerico){
                                                        String solucion = ""+evaluarOperacion(reemplazo);
                                                        //System.out.println("ES OPERACION ARITMETICA "+reemplazo);
                                                        //System.out.println("solucion: "+solucion);
                                                        Actualizar_valor_de_variableRutina(variable, solucion);
                                                    }else if(variable.getTipo().equalsIgnoreCase("String")&& esString(reemplazo)){
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);

                                                    }else if(variable.getTipo().equalsIgnoreCase("char") && esChar(reemplazo)){
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                    }else if(variable.getTipo().equalsIgnoreCase("boolean")&& esBooleano(reemplazo)){
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                    }else if (variable.getTipo().equalsIgnoreCase("boolean")&& isOperacion_boolena(reemplazo)){
                                                        Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                    } else{
                                                        correcto = false;
                                                        String error = "error en compatibidad de tipo y valores: "+ variable.getNombre();
                                                        //int linea = ctx.getStart().getLine();
                                                        CreateMessageError(error, linea);
                                                    }
                                                }else{
                                                    correcto = false;
                                                    String error = "No existe variable en el repeat o global";
                                                    //int linea = ctx.getStart().getLine();
                                                    CreateMessageError(error, linea);
                                                }

                                            }
                                            //------------------------------fin inicializacion-------------------------
                                        }
                                    }
                                    nuevaExpression = reestructurar_operacion(ctx.expression().getText());
                                    sigue = evaluateBooleanExpression(nuevaExpression);
                                };
                                //this.ScopeSubRutina="";
                                String quad2 =nextQuad + ":" + "FINAL_REPEAT,"+ctx.expression().getText()+",_,exit:";
                                quads.add(quad2);
                                nextQuad++;
                                this.VarSubRutina=new TableSymbol("GlobalTemporales");
                            }else{
                                correcto = false;
                                String error = "Error: debe haber argumentos o accione que permitan salir del loop";
                               // int linea = ctx.getStart().getLine();
                                CreateMessageError(error, linea);
                            }
                        }else{
                            correcto = false;
                            String error = "Error el condicional, debe retornar un valor booleano";
                            //int linea = ctx.getStart().getLine();
                            CreateMessageError(error, linea);
                        }


                    }else{
                        correcto = false;
                        String error = "Error el condicional, debe retornar un valor booleano";
                        int linea = ctx.getStart().getLine();
                        CreateMessageError(error, linea);
                    }

                }
            }else{
                System.out.println("ALGO FALOO");
            }
        }catch (Exception e){
            System.out.println("Error en el nodo de while");
        }
    }
    @Override public void enterForStatement(MiniPascalParser.ForStatementContext ctx) {

        try{
            if(correcto){
                if(this.ActualScope.equalsIgnoreCase("global")){
                    int linea = ctx.getStart().getLine();

                    if(ctx.forList().initialValue()!=null && ctx.forList().finalValue()!=null){
                        String valorInicial = ctx.forList().initialValue().getText();
                        String valorFinal = ctx.forList().finalValue().getText();
                        if(isNUmber("",valorInicial)&& isNUmber("",valorFinal)){
                            if(valorFinal.contains(".") && valorFinal.charAt(0)!='.'){
                                String []digitos = valorFinal.split(".");
                                valorFinal = digitos[0];
                            }
                            if(valorInicial.contains(".") && valorInicial.charAt(0)!='.'){
                                String []digitos = valorInicial.split(".");
                                valorInicial = digitos[0];
                            }
                            int valorIni = Integer.parseInt(valorInicial);
                            int valorFin = Integer.parseInt(valorFinal);

                            for(int i = valorIni; i<valorFin; i++){
                                if(ctx.statements()!=null){

                                        if (correcto) {
                                            //System.out.println("EL condicionar va: "+nuevaExpression);

                                            String[] procesos = ctx.statements().getText().split(";");
                                            for (String parte : procesos) {
                                                //-------------------Veremos si es writeln-------------------
                                                if(parte.contains("write")|| parte.contains("WRITE")|| parte.contains("writeln")|| parte.contains("WRITELN")){
                                                    String subWrite = parte.substring(0,10);
                                                    String subWriteln = parte.substring(0,12);
                                                    if(subWriteln.equalsIgnoreCase("beginwriteln")||subWrite.equalsIgnoreCase("beginwrite")){
                                                        String []componentes = parte.split("\\(");
                                                        String texto = componentes[1];
                                                        String textoMejorado = texto.substring(0, texto.length()-1);
                                                        imprimir_en_rutina(textoMejorado, linea);
                                                    }else{
                                                        subWrite = parte.substring(0,5);
                                                        subWriteln = parte.substring(0,7);

                                                        if(subWriteln.equalsIgnoreCase("writeln")||subWrite.equalsIgnoreCase("write")){
                                                            String []componentes = parte.split("\\(");
                                                            String texto = componentes[1];
                                                            String textoMejorado = texto.substring(0, texto.length()-1);
                                                            imprimir_en_rutina(textoMejorado, linea);
                                                        }
                                                    }
                                                }
                                                //----------Varemos si es inicializacion de variable----------------
                                                String regexInicializacio = "\\b(?:\\w+(?:,\\s+)?)+\\s*:=\\s*\\S+";
                                                boolean matches = Pattern.matches(regexInicializacio, parte);
                                                if (matches) {
                                                    //System.out.println(parte + " Es una inicializacion de variable existente");
                                                    String[] segmentos = parte.split(":=");
                                                    String left = segmentos[0];
                                                    Variable variable = null;
                                                    if(this.GlobalSymbol.exist_variable(left)){
                                                        variable = this.GlobalSymbol.getVariable(left);
                                                    }
                                                    if(this.VarSubRutina.exist_variable(left)){
                                                        variable = this.VarSubRutina.getVariable(left);
                                                    }
                                                    if(variable!=null){
                                                        String tipo = variable.getTipo();
                                                        boolean numerico = tipo.equalsIgnoreCase("integer")|| tipo.equalsIgnoreCase("real")
                                                                ||tipo.equalsIgnoreCase("double");

                                                        String reemplazo = reestructurar_operacion(segmentos[1]);
                                                        // System.out.println("EL originar segmento: "+segmentos[1]);
                                                        // System.out.println("El reempalzo: "+reemplazo);
                                                        if(isNUmber("0",reemplazo)&& numerico){
                                                            //System.out.println("eS NUMERO");
                                                            Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                        }else if(isOperacion_aritmetica(reemplazo)&& numerico){
                                                            String solucion = ""+evaluarOperacion(reemplazo);
                                                            //System.out.println("ES OPERACION ARITMETICA "+reemplazo);
                                                            //System.out.println("solucion: "+solucion);
                                                            Actualizar_valor_de_variableRutina(variable, solucion);
                                                        }else if(variable.getTipo().equalsIgnoreCase("String")&& esString(reemplazo)){
                                                            Actualizar_valor_de_variableRutina(variable, reemplazo);

                                                        }else if(variable.getTipo().equalsIgnoreCase("char") && esChar(reemplazo)){
                                                            Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                        }else if(variable.getTipo().equalsIgnoreCase("boolean")&& esBooleano(reemplazo)){
                                                            Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                        }else if (variable.getTipo().equalsIgnoreCase("boolean")&& isOperacion_boolena(reemplazo)){
                                                            Actualizar_valor_de_variableRutina(variable, reemplazo);
                                                        } else{
                                                            correcto = false;
                                                            String error = "error en compatibidad de tipo y valores: "+ variable.getNombre();
                                                            //int linea = ctx.getStart().getLine();
                                                            CreateMessageError(error, linea);
                                                        }
                                                    }else{
                                                        correcto = false;
                                                        String error = "No existe variable en el repeat o global";
                                                        //int linea = ctx.getStart().getLine();
                                                        CreateMessageError(error, linea);
                                                    }

                                                }
                                                //------------------------------fin inicializacion-------------------------
                                            }
                                        }


                                  /*  //this.ScopeSubRutina="";
                                    String quad2 =nextQuad + ":" + "FINAL_REPEAT,"+ctx.expression().getText()+",_,exit:";
                                    quads.add(quad2);
                                    nextQuad++;
                                    this.VarSubRutina=new TableSymbol("GlobalTemporales");*/
                                }
                            }

                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error en el nodo de FOR");
        }
    }
    @Override public void exitRepeatStatement(MiniPascalParser.RepeatStatementContext ctx) {
        this.ScopeSubRutina="";
    }
    @Override public void enterRepetetiveStatement(MiniPascalParser.RepetetiveStatementContext ctx) {
        if(this.ActualScope.equalsIgnoreCase("global")){
            this.ScopeSubRutina="GlobalTemporales";
            MiniPascalParser.RepeatStatementContext repeat = ctx.repeatStatement();
            MiniPascalParser.WhileStatementContext whilee = ctx.whileStatement();
            MiniPascalParser.ForStatementContext foor = ctx.forStatement();
            if(repeat!=null){
                String quad =nextQuad + ":" + "REPEAT," + "repeat,_,_";
                quads.add(quad);
                nextQuad++;
                if(repeat.statements()!=null){
                for(int i= 0; i< repeat.statements().statement(0).getChildCount(); i ++){
                    String expresa = repeat.statements().statement(i).getText();
                    String clave = expresa.substring(0,3);
                    String cuerpo = expresa.substring(3, expresa.length());

                    //procedemos a ver si es variable

                    String estructura = clave +" "+cuerpo;
                    String regex = "(var|VAR) [a-zA-Z][a-zA-Z0-9]*\\s*:\\s*(integer|double|real|string|char|boolean)";

                    Pattern pattern = Pattern.compile(regex);

                    Matcher matcher1 = pattern.matcher(estructura);

                    if(matcher1.matches()){

                        String []subpartes = cuerpo.split(":");
                        String nombre = subpartes[0];
                        String tipo = subpartes[1];
                       // System.out.println("Primero el repetitive con: "+nombre);
                        crear_variable(nombre, tipo);
                    }

                }

                }

            }
            if(whilee!=null){
                if(whilee.statements()!=null){
                    for(int i= 0; i< whilee.statements().statement(0).getChildCount(); i ++){
                        String expresa = whilee.statements().statement(i).getText();
                        String clave = expresa.substring(0,3);
                        String cuerpo = expresa.substring(3, expresa.length());

                        //procedemos a ver si es variable

                        String estructura = clave +" "+cuerpo;
                        String regex = "(var|VAR) [a-zA-Z][a-zA-Z0-9]*\\s*:\\s*(integer|double|real|string|char|boolean)";

                        Pattern pattern = Pattern.compile(regex);

                        Matcher matcher1 = pattern.matcher(estructura);

                        if(matcher1.matches()){
                            String []subpartes = cuerpo.split(":");
                            String nombre = subpartes[0];
                            String tipo = subpartes[1];
                            crear_variable(nombre, tipo);
                        }

                    }

                }

            }
            if(foor!=null){
                if(foor.statements()!=null){
                    for(int i= 0; i< foor.statements().statement(0).getChildCount(); i ++){
                        String expresa = foor.statements().statement(i).getText();
                        String clave = expresa.substring(0,3);
                        String cuerpo = expresa.substring(3, expresa.length());

                        //procedemos a ver si es variable

                        String estructura = clave +" "+cuerpo;
                        String regex = "(var|VAR) [a-zA-Z][a-zA-Z0-9]*\\s*:\\s*(integer|double|real|string|char|boolean)";

                        Pattern pattern = Pattern.compile(regex);

                        Matcher matcher1 = pattern.matcher(estructura);

                        if(matcher1.matches()){
                            String []subpartes = cuerpo.split(":");
                            String nombre = subpartes[0];
                            String tipo = subpartes[1];
                            crear_variable(nombre, tipo);
                        }

                    }

                }

            }
        }
    }
    public boolean Actualizar_valor_de_variableRutina(Variable variable, String valor){
        boolean valido = true;

        if(variable.getScope().equalsIgnoreCase("global")){
            boolean listo =this.GlobalSymbol.actualizarValorDeVariable(variable, valor);
            if(!listo){

                valido = this.VarSubRutina.actualizarValorDeVariable(variable, valor);
                if(valido){
                    //System.out.println("Se actualizo en la funvion de actualizar para sub rutina");
                    String quad =nextQuad + ":" + "ASSIGN," + valor +","+ variable.getTipo()+"," + "temp_"+variable.getNombre();
                    quads.add(quad);
                    nextQuad++;
                }
            }else{
                String quad =nextQuad + ":" + "ASSIGN," + valor +","+ variable.getTipo()+"," + variable.getNombre();
                quads.add(quad);
                nextQuad++;
            }

        }else {
            //this.Funciones.get(this.ActualScope).actualizarValorDeVariable(variable, valor);
        }
        return valido;
    }
    public void imprimir_en_rutina(String contexto, int linea){
        String [] ensamble = contexto.split(",");
        String resultado = "";
        for(String part: ensamble){
            // resultado+= part+" ";
            if(correcto){
                if(part.charAt(0)=='\'' && part.charAt(part.length()-1)=='\''){
                    for(int j = 0; j<part.length(); j++){
                        String letra =""+part.charAt(j);
                        if(!letra.equalsIgnoreCase("'")){
                            resultado+=letra;
                        }
                    }
                }else{
                    if(this.GlobalSymbol.exist_variable(part)){
                        resultado += this.GlobalSymbol.getVariable(part).getValor();
                    }else if(this.VarSubRutina.exist_variable(part)){
                        resultado += this.VarSubRutina.getVariable(part).getValor();
                    }else{
                        correcto = false;
                        String Message="Error al declarar la sentencia write, solo permite string y variables: ";
                        CreateMessageError(Message, linea);
                    }
                }
            }

        }
        if(correcto){
            System.out.println(resultado);
            String quad =nextQuad + ":" + "WRITELN," + resultado + ",_," + "_";
            quads.add(quad);
            nextQuad++;
        }
    }
    @Override public void enterIfStatement(MiniPascalParser.IfStatementContext ctx) {
        try{
            if(correcto){
                if(this.ActualScope.equalsIgnoreCase("Global")){
                    if(ctx.expression()!=null){
                        String condicion = ctx.expression().getText();
                        condicion = reestructurar_operacion(condicion);
                        boolean sigue = false;
                        if(isOperacion_boolena(condicion)){
                            sigue = evaluateBooleanExpression(condicion);
                        }
                        if(esBooleano(condicion)){
                            sigue = Boolean.parseBoolean(condicion);
                        }
                        if(sigue){
                            if(ctx.statements()!=null){
                                //System.out.println("EL condicionar va: "+nuevaExpression);
                                String[] procesos = ctx.statements(0).getText().split(";");
                                for (String parte : procesos) {
                                    //-------------------Veremos si es writeln-------------------
                                    if(parte.contains("write")|| parte.contains("WRITE")|| parte.contains("writeln")|| parte.contains("WRITELN")){
                                        String subWrite = parte.substring(0,10);
                                        String subWriteln = parte.substring(0,12);
                                        if(subWriteln.equalsIgnoreCase("beginwriteln")||subWrite.equalsIgnoreCase("beginwrite")){
                                            String []componentes = parte.split("\\(");
                                            String texto = componentes[1];
                                            String textoMejorado = texto.substring(0, texto.length()-1);
                                            int linea = ctx.getStart().getLine();
                                            imprimir_en_rutina(textoMejorado, linea);
                                        }else{
                                            subWrite = parte.substring(0,5);
                                            subWriteln = parte.substring(0,7);
                                            if(subWriteln.equalsIgnoreCase("writeln")||subWrite.equalsIgnoreCase("write")){
                                                int linea = ctx.getStart().getLine();
                                                String []componentes = parte.split("\\(");
                                                String texto = componentes[1];
                                                String textoMejorado = texto.substring(0, texto.length()-1);
                                                imprimir_en_rutina(textoMejorado, linea);
                                            }
                                        }
                                    }
                                    //------------------------------Verificar si es inicializacion--------------------------
                                    String regexInicializacio = "\\b(?:\\w+(?:,\\s+)?)+\\s*:=\\s*\\S+";
                                    boolean matches = Pattern.matches(regexInicializacio, parte);
                                    if (matches) {
                                        //System.out.println(parte + " Es una inicializacion de variable existente");
                                        String[] segmentos = parte.split(":=");
                                        String left = segmentos[0];
                                        Variable variable = null;
                                        if(this.GlobalSymbol.exist_variable(left)){
                                            variable = this.GlobalSymbol.getVariable(left);
                                        }
                                        if(this.VarSubRutina.exist_variable(left)){
                                            variable = this.VarSubRutina.getVariable(left);
                                        }
                                        if(variable!=null){
                                            String tipo = variable.getTipo();
                                            boolean numerico = tipo.equalsIgnoreCase("integer")|| tipo.equalsIgnoreCase("real")
                                                    ||tipo.equalsIgnoreCase("double");

                                            String reemplazo = reestructurar_operacion(segmentos[1]);
                                            // System.out.println("EL originar segmento: "+segmentos[1]);
                                            // System.out.println("El reempalzo: "+reemplazo);
                                            if(isNUmber("0",reemplazo)&& numerico){
                                                //System.out.println("eS NUMERO");
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);
                                            }else if(isOperacion_aritmetica(reemplazo)&& numerico){
                                                String solucion = ""+evaluarOperacion(reemplazo);
                                                //System.out.println("ES OPERACION ARITMETICA "+reemplazo);
                                                //System.out.println("solucion: "+solucion);
                                                Actualizar_valor_de_variableRutina(variable, solucion);
                                            }else if(variable.getTipo().equalsIgnoreCase("String")&& esString(reemplazo)){
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);

                                            }else if(variable.getTipo().equalsIgnoreCase("char") && esChar(reemplazo)){
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);
                                            }else if(variable.getTipo().equalsIgnoreCase("boolean")&& esBooleano(reemplazo)){
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);
                                            }else if (variable.getTipo().equalsIgnoreCase("boolean")&& isOperacion_boolena(reemplazo)){
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);
                                            } else{
                                                correcto = false;
                                                String error = "error en compatibidad de tipo y valores: "+ variable.getNombre();
                                                int linea = ctx.getStart().getLine();
                                                CreateMessageError(error, linea);
                                            }
                                        }else{
                                            correcto = false;
                                            String error = "No existe variable en el repeat o global";
                                            int linea = ctx.getStart().getLine();
                                            CreateMessageError(error, linea);
                                        }

                                    }
                                    //------------------------------fin inicializacion-------------------------
                                }


                        //this.ScopeSubRutina="";
                      /*  String quad2 =nextQuad + ":" + "FINAL_REPEAT,"+ctx.expression().getText()+",_,exit:";
                        quads.add(quad2);
                        nextQuad++;*/
                            }
                        }else{
                            if(ctx.statements(1)!=null){
                                //System.out.println("EL condicionar va: "+nuevaExpression);
                                String[] procesos = ctx.statements(1).getText().split(";");
                                for (String parte : procesos) {
                                    //-------------------Veremos si es writeln-------------------
                                    if(parte.contains("write")|| parte.contains("WRITE")|| parte.contains("writeln")|| parte.contains("WRITELN")){
                                        String subWrite = parte.substring(0,10);
                                        String subWriteln = parte.substring(0,12);
                                        if(subWriteln.equalsIgnoreCase("beginwriteln")||subWrite.equalsIgnoreCase("beginwrite")){
                                            String []componentes = parte.split("\\(");
                                            String texto = componentes[1];
                                            String textoMejorado = texto.substring(0, texto.length()-1);
                                            int linea = ctx.getStart().getLine();
                                            imprimir_en_rutina(textoMejorado, linea);
                                        }else{
                                            subWrite = parte.substring(0,5);
                                            subWriteln = parte.substring(0,7);
                                            if(subWriteln.equalsIgnoreCase("writeln")||subWrite.equalsIgnoreCase("write")){
                                                int linea = ctx.getStart().getLine();
                                                String []componentes = parte.split("\\(");
                                                String texto = componentes[1];
                                                String textoMejorado = texto.substring(0, texto.length()-1);
                                                imprimir_en_rutina(textoMejorado, linea);
                                            }
                                        }
                                    }
                                    //------------------------------Verificar si es inicializacion--------------------------
                                    String regexInicializacio = "\\b(?:\\w+(?:,\\s+)?)+\\s*:=\\s*\\S+";
                                    boolean matches = Pattern.matches(regexInicializacio, parte);
                                    if (matches) {
                                        //System.out.println(parte + " Es una inicializacion de variable existente");
                                        String[] segmentos = parte.split(":=");
                                        String left = segmentos[0];
                                        Variable variable = null;
                                        if(this.GlobalSymbol.exist_variable(left)){
                                            variable = this.GlobalSymbol.getVariable(left);
                                        }
                                        if(this.VarSubRutina.exist_variable(left)){
                                            variable = this.VarSubRutina.getVariable(left);
                                        }
                                        if(variable!=null){
                                            String tipo = variable.getTipo();
                                            boolean numerico = tipo.equalsIgnoreCase("integer")|| tipo.equalsIgnoreCase("real")
                                                    ||tipo.equalsIgnoreCase("double");

                                            String reemplazo = reestructurar_operacion(segmentos[1]);
                                            // System.out.println("EL originar segmento: "+segmentos[1]);
                                            // System.out.println("El reempalzo: "+reemplazo);
                                            if(isNUmber("0",reemplazo)&& numerico){
                                                //System.out.println("eS NUMERO");
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);
                                            }else if(isOperacion_aritmetica(reemplazo)&& numerico){
                                                String solucion = ""+evaluarOperacion(reemplazo);
                                                //System.out.println("ES OPERACION ARITMETICA "+reemplazo);
                                                //System.out.println("solucion: "+solucion);
                                                Actualizar_valor_de_variableRutina(variable, solucion);
                                            }else if(variable.getTipo().equalsIgnoreCase("String")&& esString(reemplazo)){
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);

                                            }else if(variable.getTipo().equalsIgnoreCase("char") && esChar(reemplazo)){
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);
                                            }else if(variable.getTipo().equalsIgnoreCase("boolean")&& esBooleano(reemplazo)){
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);
                                            }else if (variable.getTipo().equalsIgnoreCase("boolean")&& isOperacion_boolena(reemplazo)){
                                                Actualizar_valor_de_variableRutina(variable, reemplazo);
                                            } else{
                                                correcto = false;
                                                String error = "error en compatibidad de tipo y valores: "+ variable.getNombre();
                                                int linea = ctx.getStart().getLine();
                                                CreateMessageError(error, linea);
                                            }
                                        }else{
                                            correcto = false;
                                            String error = "No existe variable en el repeat o global";
                                            int linea = ctx.getStart().getLine();
                                            CreateMessageError(error, linea);
                                        }

                                    }
                                    //------------------------------fin inicializacion-------------------------
                                }


                                //this.ScopeSubRutina="";
                      /*  String quad2 =nextQuad + ":" + "FINAL_REPEAT,"+ctx.expression().getText()+",_,exit:";
                        quads.add(quad2);
                        nextQuad++;*/
                            }
                        }

                    }


                }
            }
        }catch(Exception e){
          System.out.println("ALgo salio mal con el nodo de IF");
        }
    }
    @Override public void exitIfStatement(MiniPascalParser.IfStatementContext ctx) { }
    public String convertToLLVM(String intermediateCode) {
        try{
            //WRITELN('Ingrese el primer número: ');
            // String quad =nextQuad + ":" + "WRITELN," + 'Ingrese el primer número: ' + ",_," + "_";
            String[] partes = intermediateCode.split(":");
            intermediateCode = partes[1];
            String verificar = partes[1];
            if(verificar.contains("WRITE")||verificar.contains("WRITELN")||verificar.contains("write")||verificar.contains("writeln")){
                intermediateCode+=partes[2];
            }
            StringBuilder llvmCode = new StringBuilder();
            int tempCount = 0;
            //intermediateCode = intermediateCode.replaceAll(" ","");

            String[] quad = intermediateCode.split(",");

            String operation = quad[0];
            String operand1 = quad[1];
            String operand2 = quad[2];
            String result = quad[3];
            //System.out.println("El quad es: "+intermediateCode);
           // System.out.println("La operacion es: "+operation);
            switch (operation) {

                case "ASSIGN":
                   // System.out.println("00000000000000000000ENTRO A ASIGNACION000000000000000000000000000000");
                    //store i32 10, i32* %variable
                    //String quad =nextQuad + ":" + "ASSIGN," + result.getValor()+"," + result.getTipo()+","+ left.getNombre();
                    //  String llvmCode = "store " + value + ", " + value.getType() + "* %" + variable;
                    operand2= getTypeLLVM(operand2);
                    llvmCode.append("store ").append(operand2).append(" ").append(operand1).append(",").append(operand2).append("* %").append(result).append("\n");
                    break;
                case "WRITE", "WRITELN":
                    String texto = llvmImprimir(operand1);
                    //  %1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([1["+numeroBytes+"x i8]], [1["+numeroBytes+"x i8]]* @.formato, i32 0, i32 0), i8* getelementptr inbounds ([13 x i8], [13 x i8]* @.cadena, i32 0, i32 0))
                    //llvmCode.append("%1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([["+numeroBytes+"x i8]], [["+numeroBytes+"x i8]]* @formato, i32 0, i32 0), i8* getelementptr inbounds ([13 x i8], [13 x i8]* ").append(operand1).append(", i32 0 , i32 0)").append(")\n");
                    llvmCode.append(texto);
                    break;
                case "DECLARE":
                    operand1 = getTypeLLVM(operand1);
                    llvmCode.append("%").append(result).append(" = ").append("alloca ").append(operand1).append("\n");
                    break;
                case "REPEAT":
                   // System.out.println("!!!!!!!!!!!!!!!!!!!!!!ENTRO A REPEAT °!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    //String quad =nextQuad + ":" + "REPEAT," + "repeat,_,_,_";
                    llvmCode.append(" br label %repeat\n");
                    llvmCode.append(operand1).append(":").append("\n");
                    //  %current_a = load i64, i64* %a
                    //  %current_inter = load i64, i64* %inter
                    //cargaremos las varaibles de maenra cruda
                    for (Map.Entry<String, Variable> entry : this.GlobalSymbol.getVariables().entrySet()) {
                        String key = entry.getKey();
                        Variable value = entry.getValue();
                        //System.out.println("Clave: " + key + ", Valor: " + value);
                        llvmCode.append("%current_"+value.getNombre()+" = load i64, i64* %"+value.getNombre()+"\n");
                    }
                    break;
                case "FINAL_REPEAT":
                    // String quad2 =nextQuad + ":" + "FINAL_REPEAT,"+ctx.expression().getText()+",_,exit:";
                    String operador=giveOperatorLLvm(operand1);
                    String involucrados = givePartesCondiconal(operand1);
                    String[]operadores = involucrados.split(",");
                    //  %compare = icmp slt i32 %new_i, 10

                    llvmCode.append("%compare = ").append(operador).append(" i64 %current_").append(operadores[0]).append(",").append(operadores[1]).append("\n");
                    //br i1 %compare, label %loop, label %exit
                    llvmCode.append("br i1 %compare, label %repeat, label %exit").append("\n");
                    llvmCode.append("exit:").append("\n");
                    llvmCode.append("ret void\n");
                    break;
                default:
                    //llvmCode.append("; Unsupported operation: ").append(operation).append("\n");
                    break;
            }

            // If the result of the quad is a temporary variable, create a new temporary name
           /* if (result.startsWith("t")) {
                tempCount++;
                llvmCode.append("t").append(tempCount).append(" = ").append(result).append("\n");
            }*/


            return llvmCode.toString();
        }catch(Exception e){
            return "";
        }

    }

    public String getTypeLLVM(String tipo){
        String formato="";
        if(tipo.equalsIgnoreCase("Integer")){
            formato = "i64";
        }
        if(tipo.equalsIgnoreCase("Real")){
            formato = "double";
        }
        if(tipo.equalsIgnoreCase("Double")){
            formato = "double";
        }
        if(tipo.equalsIgnoreCase("Boolean")){
            formato = "i1";
        }
        if(tipo.equalsIgnoreCase("String")){
            formato = "i64";
        }
        if(tipo.equalsIgnoreCase("Char")){
            formato = "i32";
        }
        return formato;
    }

    public String giveOperatorLLvm(String simbolo){
        String marca="";
        if(simbolo.contains(">=")){
            marca="icmp sge";
        }else if(simbolo.contains("<=")){
            marca="icmp sle";
        }else if(simbolo.contains("==")){
            marca="icmp eq";
        }else if(simbolo.contains(">")){
            marca="icmp sgt";
        }else if(simbolo.contains("<")){
            marca="icmp slt";
        }else if(simbolo.contains("!=")){
            marca = "icmp ne";
        }

        return marca;
    }
    public String givePartesCondiconal(String simbolo){
        String resultado="";


        if(simbolo.contains(">=")){
            String [] partes = simbolo.split(">=");
            if(isNUmber("",partes[0])){
                resultado+=partes[0]+",";
            }else if(esBooleano(partes[0])){
                resultado+=partes[0]+",";
            }else{
                resultado+=partes[0]+",";
            }

            if(isNUmber("",partes[1])){
                resultado+=partes[1];
            }else if(esBooleano(partes[1])){
                resultado+=partes[1];
            }else{
                resultado+=partes[1];
            }
        }else if(simbolo.contains("<=")){
            String [] partes = simbolo.split("<=");
            if(isNUmber("",partes[0])){
                resultado+=partes[0]+",";
            }else if(esBooleano(partes[0])){
                resultado+=partes[0]+",";
            }else{
                resultado+=partes[0]+",";
            }

            if(isNUmber("",partes[1])){
                resultado+=partes[1];
            }else if(esBooleano(partes[1])){
                resultado+=partes[1];
            }else{
                resultado+=partes[1];
            }
        }else if(simbolo.contains("==")){
            String [] partes = simbolo.split("==");
            if(isNUmber("",partes[0])){
                resultado+=partes[0]+",";
            }else if(esBooleano(partes[0])){
                resultado+=partes[0]+",";
            }else{
                resultado+=partes[0]+",";
            }

            if(isNUmber("",partes[1])){
                resultado+=partes[1];
            }else if(esBooleano(partes[1])){
                resultado+=partes[1];
            }else{
                resultado+=partes[1];
            }
        }else if(simbolo.contains(">")){
            String [] partes = simbolo.split(">");
            if(isNUmber("",partes[0])){
                resultado+=partes[0]+",";
            }else if(esBooleano(partes[0])){
                resultado+=partes[0]+",";
            }else{
                resultado+=partes[0]+",";
            }

            if(isNUmber("",partes[1])){
                resultado+=partes[1];
            }else if(esBooleano(partes[1])){
                resultado+=partes[1];
            }else{
                resultado+=partes[1];
            }
        }else if(simbolo.contains("<")){
            String [] partes = simbolo.split("<");
            if(isNUmber("",partes[0])){
                resultado+=partes[0]+",";
            }else if(esBooleano(partes[0])){
                resultado+=partes[0]+",";
            }else{
                resultado+=partes[0]+",";
            }

            if(isNUmber("",partes[1])){
                resultado+=partes[1];
            }else if(esBooleano(partes[1])){
                resultado+=partes[1];
            }else{
                resultado+=partes[1];
            }
        }else if(simbolo.contains("!=")){
            String [] partes = simbolo.split("!=");
            if(isNUmber("",partes[0])){
                resultado+=partes[0]+",";
            }else if(esBooleano(partes[0])){
                resultado+=partes[0]+",";
            }else{
                resultado+=partes[0]+",";
            }

            if(isNUmber("",partes[1])){
                resultado+=partes[1];
            }else if(esBooleano(partes[1])){
                resultado+=partes[1];
            }else{
                resultado+=partes[1];
            }
        }
        return resultado;
    }
    public String llvmImprimir(String texto){

        byte[] bytes = texto.getBytes();
        int numeroBytes = bytes.length;
        int longitud = numeroBytes+4;
        //System.out.println("LOGITUD: "+longitud+" Numero de bytes: "+numeroBytes);

        String encabezado= "@.formato"+ contadorTexto+"= private unnamed_addr constant [4 x i8] c\"%s\\0A\\00\"\n";
        data =encabezado+ data;
        String codigo = "  %texto"+contadorTexto+"= alloca [" + (longitud ) + " x i8]\n"
                + "  %textoPtr"+contadorTexto+"= getelementptr [" + (longitud ) + " x i8], [" + (longitud ) + " x i8]* %texto"+contadorTexto+", i32 0, i32 0\n"
                + "  store [" + (longitud ) + " x i8]  c\"%s\\0A" + texto + "\\00\", [" + (longitud ) + " x i8]* %texto"+contadorTexto+"\n"
                + "  %"+(contadorTexto+1)+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([16 x i8], [16 x i8]* @.formato"+contadorTexto+", i32 0, i32 0), i8* %textoPtr"+contadorTexto+")\n";

        contadorTexto++;
        return codigo;
    }
    public void CreateMessageError(String error, Integer linea){
        this.MessageError="Error en la linea: "+linea+": "+error;
    }

}
