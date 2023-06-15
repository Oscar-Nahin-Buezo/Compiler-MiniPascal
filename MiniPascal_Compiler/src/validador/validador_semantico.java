package validador;

import parser.MiniPascalBaseListener;
import javax.script.*;

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
    private TableSymbol GlobalSymbol = new TableSymbol("Global");
    private HashMap<String, Funcion> Funciones = new HashMap<>();
    private HashMap<String, Procedimiento> Procedures = new HashMap<>();

    private Boolean correcto = true;
    private String MessageError = "";

    @Override public void exitProgram(MiniPascalParser.ProgramContext ctx) {
        System.out.println("----------Tabla global----------");
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
        }
        System.out.println(this.MessageError);
    }
    @Override public void enterVariableDeclaration(MiniPascalParser.VariableDeclarationContext ctx) {
        if(correcto){
            //System.out.println("El Scope es: "+this.ActualScope);
            //System.out.println("Se declara la variable: ");
            String []previusData = ctx.identifierList().getText().split(",");
            for (int i = 0; i<previusData.length; i++){

                if(correcto){
                    correcto = crear_variable(previusData[i],ctx.type_().getText());
                }
            }


            if(!correcto){
                String error = "Error al declarar variable, ya existe una con ese nombre";
                int linea = ctx.getStart().getLine();
                CreateMessageError(error, linea);
            }
        }


    }
    @Override public void enterAssignmentStatement(MiniPascalParser.AssignmentStatementContext ctx) {
        if(this.correcto){
           // System.out.println("ESTO ES ASIGNACION: ");
            //System.out.println(ctx.getText());
            MiniPascalParser.VariableContext leftVariable = ctx.variable(0);
            MiniPascalParser.VariableContext rightVariable = ctx.variable(1);
            MiniPascalParser.ExpressionContext expression = ctx.expression();
            int linea = ctx.getStart().getLine();
            if (rightVariable != null ) {
                Variable left = null;
                Variable right =null;
                if(this.ActualScope.equalsIgnoreCase("global")){
                    left = this.GlobalSymbol.getVariable(leftVariable.getText());
                    right = this.GlobalSymbol.getVariable(rightVariable.getText());
                    if(left == null || right == null){
                        correcto = false;
                        System.out.println("HUBO UN ERROR AL INICIALIZAR UN VARIABLE CON OTRA HAY UNA NULL");
                        String message = "";
                        if(left == null)
                            message +="La variable: "+leftVariable.getText()+" no ha sido declarada\n";
                        if(right == null)
                            message ="La variable: "+rightVariable.getText()+" no ha sido declarada\n";

                        CreateMessageError(message, linea);
                    }else{
                        inicializar_variable_con_variable(left, right, linea);
                    }
                }else if(this.Funciones.containsKey(this.ActualScope)){
                    System.out.println("Agregaremos operacion a la funcion: "+this.ActualScope);
                    String nombre = "Inicializacion-"+leftVariable.getText();
                    String expresion = ctx.getText();
                    operaciones operacion = new operaciones(nombre, expresion);
                    this.Funciones.get(this.ActualScope).AddOperacion(operacion);
                }else if(this.Procedures.containsKey(this.ActualScope)){
                    System.out.println("Agregaremos procedimiento al procedimiento: "+this.ActualScope);
                    String nombre = "Inicializacion-"+leftVariable.getText();
                    String expresion = ctx.getText();
                    operaciones operacion = new operaciones(nombre, expresion);
                    this.Procedures.get(this.ActualScope).AddOperacion(operacion);
                }

            } else if (expression != null) {

                if(this.ActualScope.equalsIgnoreCase("global")){
                    Variable left = this.GlobalSymbol.getVariable(leftVariable.getText());
                    if(left!=null){
                        //System.out.println("Se asigna una expresion: "+expression.getText());
                        if(left.getTipo().equalsIgnoreCase("integer")||left.getTipo().equalsIgnoreCase("real")
                                ||left.getTipo().equalsIgnoreCase("double")){
                            boolean isNumber = isNUmber(left.getTipo(), expression.getText());
                            if(!isNumber){
                                //System.out.println("No es numero");
                                boolean valido2 = isOperacion_aritmetica(expression.getText());
                                if(!valido2){
                                    correcto= isFunctionCall(expression.getText());
                                    if(!correcto){
                                        String message = "Valor invalido para la variable de tipo númerico: "+left.getNombre();
                                        CreateMessageError(message, linea);
                                    }else{
                                        //System.out.println("Es una llamada a funcion");
                                        MiniPascalParser.FunctionDesignatorContext designator = expression.simpleExpression().term().signedFactor().factor().functionDesignator();
                                        Funcion funcion = this.Funciones.get(designator.identifier().getText());
                                        if(funcion.getResultType().equalsIgnoreCase(left.getTipo())){
                                            llamada_de_funcion(designator);
                                            Variable result = funcion.getSimbolos().getVariable("result");
                                            Actualizar_valor_de_variable(left, result.getValor());
                                        }else{
                                            correcto = false;
                                            String message = "Valor de retorno no coincide con el tipo numerico de la variable: "+left.getNombre();
                                            CreateMessageError(message, linea);
                                        }

                                    }
                                }else{
                                    String res =""+ evaluarOperacion(expression.getText());
                                    Actualizar_valor_de_variable(left, res);
                                }

                            }else{
                                Actualizar_valor_de_variable(left, expression.getText());
                            }

                        }else if(left.getTipo().equalsIgnoreCase("Boolean")){
                            boolean isBoolean =esBooleano(expression.getText());
                            if(!isBoolean){
                                boolean valido2 = isOperacion_boolena(expression.getText());
                                if(!valido2){
                                    correcto= isFunctionCall(expression.getText());
                                    if(!correcto){
                                        String message = "Valor invalido para la variable "+left.getNombre()+" de tipo booleano";
                                        CreateMessageError(message, linea);
                                    }else{
                                       // System.out.println("Es una llamada a funcion");
                                        MiniPascalParser.FunctionDesignatorContext designator = expression.simpleExpression().term().signedFactor().factor().functionDesignator();
                                        Funcion funcion = this.Funciones.get(designator.identifier().getText());
                                        if(funcion.getResultType().equalsIgnoreCase(left.getTipo())){
                                            llamada_de_funcion(designator);
                                            Variable result = funcion.getSimbolos().getVariable("result");
                                            Actualizar_valor_de_variable(left, result.getValor());
                                        }else{
                                            correcto = false;
                                            String message = "Valor de retorno no coincide con el tipo booleano de la variable: "+left.getNombre();
                                            CreateMessageError(message, linea);
                                        }

                                    }
                                }else{
                                    String res =""+evaluateBooleanExpression(expression.getText());
                                    if(correcto){
                                        Actualizar_valor_de_variable(left, res);
                                    }else{
                                        String message = "Operacion booleana invalida para la variable "+left.getNombre()+" de tipo booleano";
                                        CreateMessageError(message, linea);
                                    }

                                }

                            }else{
                                Actualizar_valor_de_variable(left, expression.getText());
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
                    }
                }else if(this.Funciones.containsKey(this.ActualScope)){
                    String nombre = "Inicializacion-"+leftVariable.getText();
                    String expresion = ctx.getText();
                    operaciones operacion = new operaciones(nombre, expresion);
                    this.Funciones.get(this.ActualScope).AddOperacion(operacion);
                }else if(this.Procedures.containsKey(this.ActualScope)){
                    String nombre = "Inicializacion-"+leftVariable.getText();
                    String expresion = ctx.getText();
                    operaciones operacion = new operaciones(nombre, expresion);
                    this.Procedures.get(this.ActualScope).AddOperacion(operacion);
                }

            }
        }

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
            //System.out.println("Sale de declarar funcion");
        }

    }
    @Override public void enterFunctionDesignator(MiniPascalParser.FunctionDesignatorContext ctx) {
      
       // llamada_de_funcion(ctx);

    }
    @Override public void exitProcedureDeclaration(MiniPascalParser.ProcedureDeclarationContext ctx) {
        this.ActualScope="Global";
    }
    @Override public void enterProcedureDeclaration(MiniPascalParser.ProcedureDeclarationContext ctx) {
        if(correcto){
            System.out.println("Declararemos un procedimiento");
            this.ActualScope= ctx.identifier().getText();

            ArrayList<Variable>mis_parametros = new ArrayList<Variable>();
            // System.out.println("Entra a declarar funcion");

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
                    System.out.println("Procedimiento alamecenado");
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
           // System.out.println("Entra a declarar funcion");

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
        Variable variable = new Variable(name, tipo, this.ActualScope);
        if (this.ActualScope.equalsIgnoreCase("global")) {
            creado= this.GlobalSymbol.addVariable(variable);
        } else if(this.Funciones.containsKey(this.ActualScope)){
            if(name.equalsIgnoreCase("result")){
                creado = false;
            }else{
                creado = this.Funciones.get(this.ActualScope).addSymbolInTableFunction(variable);
            }

        }else if(this.Procedures.containsKey(this.ActualScope)){
            //System.out.println("Agregaremos variable  ala tabla del procedimiento: "+this.ActualScope);
            creado = this.Procedures.get(this.ActualScope).addSymbolInTableProcedimiento(variable);
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
    public void inicializar_variable_con_variable(Variable left, Variable right, Integer linea){

        if (left.getTipo().equalsIgnoreCase(right.getTipo())){
            if(left.getScope().equalsIgnoreCase(right.getScope())){
                Actualizar_valor_de_variable(left, right.getValor());
            }else{
                this.correcto = false;
                String message ="Las variables no se encuentran en el mismo ambito o scope";
                CreateMessageError(message, linea);
            }
        }else{
            System.out.println("HUBO UN ERROR AL INICIALIZAR UN VARIABLE CON OTRA ");
            this.correcto = false;
            String message ="Los tipos de variable no coinciden";
            CreateMessageError(message, linea);
        }

    }
    public void llamada_de_funcion(MiniPascalParser.FunctionDesignatorContext ctx){
        //System.out.println("Se llama a la funcion: "+ctx.getText());
        String refScope = ctx.identifier().getText();
        ArrayList<Variable> listVar = new ArrayList<>();

        for (int i = 0; i<ctx.parameterList().getChildCount(); i++){
            if(ctx.parameterList().actualParameter(i)!=null && correcto){
                MiniPascalParser.VariableContext variable = ctx.parameterList().actualParameter(i).expression().simpleExpression().term().signedFactor().factor().variable();
                if(variable== null){
                    MiniPascalParser.ExpressionContext expression = ctx.parameterList().actualParameter(i).expression();
                    //System.out.println("No habia nada de variable");
                    //System.out.println("Pero hay: "+expression.getText());
                    String name ="C"+i;
                    Variable variableTemp = crear_variable_para_parametro(name, expression.getText());
                    //System.out.println("La variable es: ");

                    listVar.add(variableTemp);
                }else{
                    //System.out.println("Es una variable");
                    if(this.ActualScope.equalsIgnoreCase("global")){
                        if(this.GlobalSymbol.exist_variable(variable.getText())){
                            //System.out.println("La variable esta en Scope GLobal");
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
                    //listVar.add(ctx.parameterList().actualParameter(i).getText());
                    //System.out.println(ctx.parameterList().actualParameter(i).getText());
                }

            }
        }
        if(this.Funciones.containsKey(refScope)){
            Funcion tempFuncion = this.Funciones.get(refScope);
            if(tempFuncion.getNumeroParametros()== listVar.size()){
                //lo siguinete es validar que el tipo de valor corresponde entre argumentos y parametros
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
                    //System.out.println("Se ejecutara la OPERACION: "+Op.getNameOperacion()+" expresion: "+Op.getExpresion());
                    valido = ejecutar_inicializacion_en_funcion(funcion, Op.getExpresion(), linea);
                }
            }else{
                correcto = false;
            }
        }
        //ahora procedemos a ejecutar instruccion de la funcion como inicializar variables etc.


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
                        //System.out.println("SE EVALUARA LA OPERACION: "+operacion);
                        operacion = "" + evaluarOperacion(operacion);
                        //System.out.println("Resultado: "+operacion);
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
                        // System.out.println("SE EVALUARA LA OPERACION: "+operacion);
                        operacion = "" + evaluateBooleanExpression(operacion);
                        // System.out.println("Resultado: "+operacion);
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
    public void Actualizar_valor_de_variable(Variable variable, String valor){
        if(variable.getScope().equalsIgnoreCase("global")){
            this.GlobalSymbol.actualizarValorDeVariable(variable, valor);
        }else{
            this.Funciones.get(this.ActualScope).actualizarValorDeVariable(variable, valor);
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

    public void CreateMessageError(String error, Integer linea){
        this.MessageError="Error en la linea: "+linea+": "+error;
    }

}
