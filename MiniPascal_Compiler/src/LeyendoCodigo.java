import parser.MiniPascalBaseListener;
import parser.MiniPascalParser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.*;

import org.antlr.v4.runtime.tree.ParseTree;

public class LeyendoCodigo extends MiniPascalBaseListener {
    private Map<String, Object> variables = new HashMap<>();
    private Map<String, variablex> pila = new HashMap<>();
    @Override public void exitSentencia_write(MiniPascalParser.Sentencia_writeContext ctx) {

        String periodico = recorrer_writeln(ctx);
        System.out.println(periodico);
        /*String ref = ctx.ID().toString();
        ref = ref.substring(1,(ref.length()-1));
        for (String clave:pila.keySet()) {
            if(clave.equals(ref)){
                System.out.println("ENcontradoooo");
                variablex hola = pila.get(clave);
                System.out.println("Tiene variable asi: "+ctx.CONSTSTR() + hola.getValue());
                //System.out.println("Clave: " + hola.getName() + ", valor: " + hola.getValue());
            }

        }*/



    }

    @Override public void enterExpresion(MiniPascalParser.ExpresionContext ctx) {
        //System.out.println("Eentramns a una asigancion");
        //System.out.println(ctx.getText());
    }
    @Override public void enterSentencia_asignacion(MiniPascalParser.Sentencia_asignacionContext ctx) {
        int verificacion = verificar_tipo_valor(ctx.expresion().getText());
        if(verificacion==0){
            alamcenar_variable( ctx.ID().getText(),ctx.expresion().getText(),"String");
            variables.put(ctx.ID().getText(),ctx.expresion().getText());
        }
        if(verificacion==1){
            alamcenar_variable( ctx.ID().getText(),ctx.expresion().getText(),"Integer");
            variables.put(ctx.ID().getText(),ctx.expresion().getText());
        }
        if(verificacion==2){
            alamcenar_variable( ctx.ID().getText(),ctx.expresion().getText(),"Double");
            variables.put(ctx.ID().getText(),ctx.expresion().getText());
        }
        if(verificacion==4){
            System.out.println("ENtramos a booleano");
            alamcenar_variable( ctx.ID().getText(),ctx.expresion().getText(),"Boolean");
            variables.put(ctx.ID().getText(),ctx.expresion().getText());
        }
        if(verificacion==100){

            if(ctx.expresion().ADDOP()!=null||ctx.expresion().MULOP()!=null){
                //System.out.println("llamaremos a operaciones aritmeticas");
                boolean operacion = operacion_aritmetica(ctx.ID().getText(),ctx.expresion().getText());
                //si no es aritmetica, probaremos con concatenacion
                if(!operacion){
                    operacion_concatenacion(ctx.ID().getText(),ctx.expresion().getText());
                }
            }

        }

    }

    public int verificar_tipo_valor(String valor){
        if (valor.matches("^\".*\"$")) {
            //System.out.println("ES estring");
            return 0;//cadena
        } else if (valor.matches("\\d+")) {
            //System.out.println("ES entero");
            return 1;//entero
        } else if (valor.matches("\\d+\\.\\d+")) {
            //System.out.println("ES double");
            return 2; // decimal
        } else if(valor.matches("^(true|false)$")){
           // System.out.println("variable: "+valor);
            //System.out.println("ES booleano");
            return 4;// valor booleano
        }else if (valor.matches("\\w+")) {
           // System.out.println("variable: "+valor);
            return 3; //asignacion de variable
        } else {
            //System.out.println("ES operacion compleja");
            return 100;// asignacion compleja, como ser operaciones aritmeticas
        }


    }
    public void alamcenar_variable(String name, String valor, String tipo){
        variablex variable = new variablex(name, valor, tipo);
        pila.put(name, variable);
    }

    public Boolean operacion_aritmetica(String name, String operacion){
        try{
           // System.out.println("entramos a operaciones aritmeticas con esto: nombre: "+name +" operacion: "+operacion);
            for (String variable : pila.keySet()) {
                String valorMan = pila.get(variable).getValue();
                operacion = operacion.replaceAll(variable, valorMan);
            }
            operacion = transformar_ecuacion(operacion);
            //System.out.println("Tenemos el resultado de reemplazo: "+operacion);
            Double temp = resolver_ecuacion(operacion);
            //System.out.println("Resultado de resolver la ecuacion: "+temp);
            variablex nueva_variable = new variablex(name, Double.toString(temp),"Double");
            pila.put(name,nueva_variable);
        }catch (Exception f){
            System.out.println(f.getMessage());
            return false;
        }
        return true;
    }
    public void operacion_concatenacion(String name, String ecuacion){
        boolean correcto= true;
        String resultado ="";
        ecuacion = ecuacion.replace('+',':');
        String[] arreglo = ecuacion.split(":");
        for(String temp: arreglo){
            //System.out.println("Tenemos el temp: "+temp);
            for (String clave:pila.keySet()) {
                variablex eso = pila.get(clave);
                //System.out.println("var: "+eso.getName()+" valor: "+eso.getValue());
                if(clave.equals(temp)){
                    //System.out.println("Coincidencia");
                    variablex hola = pila.get(clave);
                    if(hola.getTipo().equals("Boolean")){
                        correcto=false;
                    }else{
                        String frase = hola.getValue();
                        frase = frase.substring(1,frase.length()-1);
                        resultado+=frase;
                    }
                }
            }
        }
        if(correcto){
            variablex nueva_variable = new variablex(name,resultado,"String");
            //System.out.println("Resultado de la concatenacion: "+resultado);
            pila.put(name,nueva_variable);
        }else{
            JOptionPane.showMessageDialog(null,"Error al intentar asignar los valores a: "+name);
        }

    }
    public void operaciones_booleanas(){

    }
    public String transformar_ecuacion(String ecuacion){
        String nueva_ecuacion = "";
        for (int i = 0; i<ecuacion.length(); i++){
            String letra = String.valueOf( ecuacion.charAt(i));
            if(letra.equals("+")||letra.equals("-")||letra.equals("*")||letra.equals("/"))
                letra =" "+letra+" ";
            nueva_ecuacion+=letra;
        }
        return nueva_ecuacion;
    }
    public double resolver_ecuacion(String ecuacion){
        Scanner sc = new Scanner(ecuacion);
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                double num = sc.nextDouble();
                numbers.push(num);
            } else {
                char op = sc.next().charAt(0);
                if (op == '(') {
                    operators.push(op);
                } else if (op == ')') {
                    while (operators.peek() != '(') {
                        double num2 = numbers.pop();
                        double num1 = numbers.pop();
                        char operator = operators.pop();
                        double result = applyOperator(num1, num2, operator);
                        numbers.push(result);
                    }
                    operators.pop();
                } else {
                    while (!operators.empty() && precedence(operators.peek()) >= precedence(op)) {
                        double num2 = numbers.pop();
                        double num1 = numbers.pop();
                        char operator = operators.pop();
                        double result = applyOperator(num1, num2, operator);
                        numbers.push(result);
                    }
                    operators.push(op);
                }
            }
        }

        while (!operators.empty()) {
            double num2 = numbers.pop();
            double num1 = numbers.pop();
            char operator = operators.pop();
            double result = applyOperator(num1, num2, operator);
            numbers.push(result);
        }

        return numbers.pop();
    }
    public static double applyOperator(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            case '^':
                return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    public String recorrer_writeln(MiniPascalParser.Sentencia_writeContext ctx){
        String impreso = "";
        for(int i = 0; i<ctx.getChildCount(); i++){

            String temp = String.valueOf(ctx.getChild(i));
            boolean bandera = false;
            for (String clave:pila.keySet()) {
                if(clave.equals(temp)){
                    bandera=true;
                    variablex hola = pila.get(clave);
                    impreso+=hola.getValue();
                }
            }
            if(!bandera&&(!temp.equals("WRITELN")&&!temp.equals("WRITE"))&&!temp.equals("'")&&!temp.equals("(")&&!temp.equals(")")&&!temp.equals(",")){
                temp = temp.substring(1,temp.length()-1);
                impreso+=temp;
            }
        }
        //System.out.println("Valor de impreso: "+impreso);
        return impreso;
    }
}
