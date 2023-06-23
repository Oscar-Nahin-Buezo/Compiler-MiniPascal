package validador;

import parser.MiniPascalBaseListener;

import parser.MiniPascalParser;
import tables.Tabla_de_Funciones;
import tables.TableSymbol;
import variables.*;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Funcion.*;
public class validador_semantico extends MiniPascalBaseListener  {
    private String ActualScope = "Global";
    private TableSymbol GlobalSymbol = new TableSymbol("Global");
    private Tabla_de_Funciones Funciones = new Tabla_de_Funciones("Funciones");
    private HashMap<String, Funcion> StackFunciones = new HashMap<>();
    private Boolean correcto = true;
    private String MessageError = "";

    @Override public void exitProgram(MiniPascalParser.ProgramContext ctx) {
        System.out.println("----------Tabla global----------");
        System.out.println("NUmero de variables: "+this.GlobalSymbol.numero_variables());
        this.GlobalSymbol.imprimir_tablas();
        System.out.println("--------------------------------");
        System.out.println("----------Tabla de funciones----------");
        this.Funciones.imprimir_tablas();
        System.out.println("--------------------------------");
        System.out.println("----------Stack de funciones: "+this.StackFunciones.size()+"----------");
        for (Funcion valor : this.StackFunciones.values()) {
            valor.imprimir_funcion();
        }
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
            System.out.println("ESTO ES ASIGNACION: ");
            System.out.println(ctx.getText());
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
                }else{
                    String nombre = "Inicializacion-"+leftVariable.getText();
                    String expresion = ctx.getText();
                    operaciones operacion = new operaciones(nombre, expresion);
                    this.StackFunciones.get(this.ActualScope).AddOperacion(operacion);
                }

            } else if (expression != null) {
                if(this.ActualScope.equalsIgnoreCase("global")){

                }else{
                    // Se asigna una expresión a una variable
                    System.out.println("Asignación de expresión a variable: " + leftVariable.getText()
                            + " = " + expression.getText());
                    String nombre = "Inicializacion-"+leftVariable.getText();
                    String expresion = ctx.getText();
                    operaciones operacion = new operaciones(nombre, expresion);
                    this.StackFunciones.get(this.ActualScope).AddOperacion(operacion);
                }

            }
        }

    }

    @Override public void exitFunctionDeclaration(MiniPascalParser.FunctionDeclarationContext ctx) {
        if(correcto){
            this.ActualScope= "Global";
            //System.out.println("Sale de declarar funcion");
        }

    }
    @Override public void enterFunctionDesignator(MiniPascalParser.FunctionDesignatorContext ctx) {
        System.out.println("Se llama a la funcion: "+ctx.parameterList().actualParameter().get(0).getText());
        for (int i = 0; i<ctx.parameterList().getChildCount(); i++){
            if(ctx.parameterList().actualParameter(i)!=null){
                MiniPascalParser.VariableContext leftVariable = ctx.parameterList().actualParameter(i).expression().simpleExpression().term().signedFactor().factor().variable();
                if(leftVariable== null){
                    System.out.println("No habia nada de variable");
                }else{
                    System.out.println(ctx.parameterList().actualParameter(i).getText());
                }

            }
        }
    }
    @Override public void enterFunctionDeclaration(MiniPascalParser.FunctionDeclarationContext ctx) {
        if(correcto){
            this.ActualScope= ctx.identifier().getText();
            TableSymbol newTable = new TableSymbol(ctx.identifier().getText());
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
                            correcto = newTable.addVariable(tempVariable);
                        }
                        System.out.println("Variable: " + variable + ", Tipo: " + tipo);
                    }
                }

            }
            if(correcto){
                correcto= this.Funciones.addTablaFuncion(newTable);
                if(correcto){
                    Funcion newFuncion = new Funcion(ctx.identifier().getText());
                    if(this.StackFunciones.containsKey(newFuncion.getName())){
                        correcto =false;
                        int linea = ctx.getStart().getLine();
                        String Message="Error al guardar funcion en el stack: "+ctx.identifier().getText();
                        CreateMessageError(Message, linea);
                    }else{
                        this.StackFunciones.put(newFuncion.getName(),newFuncion);
                    }
                }
            }else{
                int linea = ctx.getStart().getLine();
                String Message="Error al guardar parametros de la funcion: "+ctx.identifier().getText();
                CreateMessageError(Message, linea);
            }

        }

    }

    public boolean crear_variable(String name, String tipo){
        boolean creado = false;
        Variable variable = new Variable(name, tipo, this.ActualScope);
        if (this.ActualScope.equalsIgnoreCase("global")) {
            creado= this.GlobalSymbol.addVariable(variable);
        } else {
            creado = this.Funciones.addSymbolInTableFunction(this.ActualScope, variable);
        }
        return creado;
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

    public void inicializar_variable_con_expresion(){

    }

    public void Actualizar_valor_de_variable(Variable variable, String valor){
        if(variable.getScope().equalsIgnoreCase("global")){
            this.GlobalSymbol.actualizarValorDeVariable(variable, valor);
        }else{
            this.Funciones.actualizarValorDeVariable(variable, valor);
        }
    }
    public void CreateMessageError(String error, Integer linea){
        this.MessageError="Error en la linea: "+linea+": "+error;
    }

     public void enterWhileStatement(MiniPascalParser.WhileStatementContext ctx) {
        MiniPascalParser.ExpressionContext conditionContext = ctx.expression();
        String condition = conditionContext.getText();
        System.out.println("Entered while statement with condition: " + condition);
        
        if (!isValidCondition(condition)) {
            System.err.println("Invalid condition: " + condition);
        }
        
        MiniPascalParser.BlockContext blockContext = ctx.block();
        processStatements(blockContext);
    }
    
    private void processStatements(MiniPascalParser.BlockContext blockContext) {
        for (MiniPascalParser.StatementContext statementContext : blockContext.statement()) {
            if (statementContext.ifStatement() != null) {
                // Process if statement
                processIfStatement(statementContext.ifStatement());
            } else if (statementContext.whileStatement() != null) {
                // Process while statement
                processWhileStatement(statementContext.whileStatement());
            }
            // Add more conditions for other types of statements if needed
        }
    }
    
    private void processIfStatement(MiniPascalParser.IfStatementContext ifStatementContext) {
        MiniPascalParser.ExpressionContext conditionContext = ifStatementContext.expression();
        String condition = conditionContext.getText();
        System.out.println("Entered if statement with condition: " + condition);
        
        if (!isValidCondition(condition)) {
            System.err.println("Invalid condition: " + condition);
        }
        
        MiniPascalParser.BlockContext blockContext = ifStatementContext.block();
        processStatements(blockContext);
        
        // Process optional else statement
        if (ifStatementContext.elseStatement() != null) {
            processElseStatement(ifStatementContext.elseStatement());
        }
    }
    
    private void processElseStatement(MiniPascalParser.ElseStatementContext elseStatementContext) {
        MiniPascalParser.BlockContext blockContext = elseStatementContext.block();
        processStatements(blockContext);
    }
    
    private void processWhileStatement(MiniPascalParser.WhileStatementContext whileStatementContext) {
        MiniPascalParser.ExpressionContext conditionContext = whileStatementContext.expression();
        String condition = conditionContext.getText();
        System.out.println("Entered while statement with condition: " + condition);
        
        if (!isValidCondition(condition)) {
            System.err.println("Invalid condition: " + condition);
        }
        
        MiniPascalParser.BlockContext blockContext = whileStatementContext.block();
        processStatements(blockContext);
    }
    
    private boolean isValidCondition(String condition) {
        return condition.equals("true") || condition.equals("false");
    }
    
}
