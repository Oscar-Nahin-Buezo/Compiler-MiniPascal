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
    private String salida_input="";
    @Override public void exitSentencia_write(MiniPascalParser.Sentencia_writeContext ctx) {
        boolean correcto =true;

        for (int i =0; i<ctx.getChildCount(); i++){
            if(!ctx.ID().toString().equals("[]")){
                String identi =ctx.ID().toString();
                identi = identi.substring(1,identi.length()-1);
                variablex tengo = null;
                tengo = pila.get(identi);
                if(tengo==null|| !tengo.getRango().equals(""))
                    correcto=false;
            }
        }
        if(correcto){
            String periodico = recorrer_writeln(ctx);
            System.out.println(periodico);
            this.salida_input = periodico;
        }else{
            System.out.println("***La WRITE o WRITELN: "+ctx.getText()+" No se puede imprimir debido a variables nulas o contiene un arreglo***");
        }

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
    public String mostrar_salida(){
        return salida_input;
    }

    @Override public void enterExpresion(MiniPascalParser.ExpresionContext ctx) {
        //System.out.println("Eentramns a una asigancion");
        //System.out.println(ctx.getText());
    }
    @Override public void enterSentencia_asignacion(MiniPascalParser.Sentencia_asignacionContext ctx) {
        if (ctx.arreglo()!=null) {
            //System.out.println(ctx.ID().getText()+" "+ctx.arreglo().getText());
            almacenar_arreglo(ctx.ID().getText(), ctx.arreglo().getText());
        } else {
            int verificacion = verificar_tipo_valor(ctx.expresion().getText());
            if (verificacion == 0) {
                alamcenar_variable(ctx.ID().getText(), ctx.expresion().getText(), "String");
                variables.put(ctx.ID().getText(), ctx.expresion().getText());
            }
            if (verificacion == 1) {
                alamcenar_variable(ctx.ID().getText(), ctx.expresion().getText(), "Integer");
                variables.put(ctx.ID().getText(), ctx.expresion().getText());
            }
            if (verificacion == 2) {
                alamcenar_variable(ctx.ID().getText(), ctx.expresion().getText(), "Double");
                variables.put(ctx.ID().getText(), ctx.expresion().getText());
            }
            if (verificacion == 4) {
                //System.out.println("ENtramos a booleano");
                alamcenar_variable(ctx.ID().getText(), ctx.expresion().getText(), "Boolean");
                variables.put(ctx.ID().getText(), ctx.expresion().getText());
            }
            if (verificacion == 100) {
                //System.out.println("La expresion: "+ctx.expresion().getText());
                String addop = ctx.expresion().ADDOP().toString();
                String mulop = ctx.expresion().MULOP().toString();
                String ande = ctx.expresion().AND().toString();
                String ore = ctx.expresion().OR().toString();
                /*System.out.println("Addop: "+addop);
                System.out.println("mulop: "+mulop);
                System.out.println("and: "+ande);
                System.out.println("or: "+ore);*/
                if (!addop.equals("[]") || !mulop.equals("[]")) {
                    //System.out.println("llamaremos a la aritmetica: "+ctx.expresion().getText());
                    boolean operacion = operacion_aritmetica(ctx.ID().getText(), ctx.expresion().getText());
                    if (!operacion) {
                        //System.out.println("llamaremos a la concatenacion: "+ctx.expresion().getText());
                        operacion_concatenacion(ctx.ID().getText(), ctx.expresion().getText());
                    }
                } else if (!ande.equals("[]") || !ore.equals("[]")) {
                    String renovado = "";
                    for (int j = 0; j < ctx.expresion().getChildCount(); j++) {
                        if (j == ctx.expresion().getChildCount() - 1) {
                            renovado += ctx.expresion().getChild(j).getText();
                        } else {
                            renovado += ctx.expresion().getChild(j).getText() + " ";
                        }

                    }
                    //System.out.println("llamaremos a la operacion booleana: "+ctx.expresion().getText());
                    //System.out.println("Veamos si tiene and o or: "+ctx.expresion().OR().toString());
                    boolean exito = operaciones_booleanas(ctx.ID().getText(), renovado);
                    if (!exito) {
                        JOptionPane.showMessageDialog(null, "Error al asignar valor a la varible booleana: " + ctx.ID().getText());
                    }
                }
            }
        }

    }

    public int verificar_tipo_valor(String valor){
        if (valor.matches("^\".*\"$")) {
            //System.out.println("variable String: "+valor);
            //System.out.println("ES estring");
            return 0;//cadena
        } else if (valor.matches("\\d+")) {
            //System.out.println("ES entero");
            return 1;//entero
        } else if (valor.matches("\\d+\\.\\d+")) {
            //System.out.println("ES double");
            return 2; // decimal
        } else if(valor.matches("^(true|false)$")){
           //System.out.println("variable: "+valor);
            //System.out.println("ES booleano");
            return 4;// valor booleano

        } else {
            //System.out.println("ES operacion compleja");
            return 100;// asignacion compleja, como ser operaciones aritmeticas
        }


    }
    public void almacenar_arreglo(String name, String inicializacion){
        try{
            //System.out.println("La expresion queda asi: "+inicializacion);
            String rango = inicializacion.substring(6,12);
            rango = rango.substring(4,5);
            //System.out.println("Rango del arreglo: "+rango);
            inicializacion = inicializacion.substring(14,inicializacion.length());
            //System.out.println("Se quito el rango: "+inicializacion);
            int datos_pos1= inicializacion.indexOf("=");
            String tipo_dato = inicializacion.substring(0,datos_pos1);
            //System.out.println("El tipo de dato es: "+tipo_dato);
            inicializacion= inicializacion.substring(datos_pos1+1,inicializacion.length());
            //System.out.println("Nuevamente actualizacion inicilizacion: "+inicializacion);
            inicializacion=inicializacion.substring(1,inicializacion.length()-1);
            String datos = inicializacion;
            //System.out.println("Datos: "+datos);
            boolean todo_bien=validacion_datos_arreglo(tipo_dato,datos);
            if(todo_bien){
                variablex nueva_variable = new variablex(name, datos,tipo_dato,rango);
                pila.put(name,nueva_variable);
                //System.out.println("Arreglo almacenado");
            }else{
                System.out.println("¡Error!: No se declaro arreglo: "+name+" Verifique el tipo de dato y los valores");
            }

        }catch(Exception e){
            System.out.println("Error al declarar o inicializar el arreglo: "+name);
        }

    }
    public boolean validacion_datos_arreglo(String tipo,String datos){
        boolean pasa = true;
        try{
            int comas =0;
            int valores =0;
            String filtrado="";
            //primer filtro es qque deben haber n comas y n+1 valores
            for (int i = 0; i<datos.length(); i++){
                char letra=datos.charAt(i);
                if(letra==',')
                    comas++;
                if(letra!=',')
                    valores++;
            }
            if(comas>=valores){
                //System.out.println("Error: No se puede realizar la declaracion del arreglo ya que los datos son incorrectos");
                pasa = false;
            }else{
                String [] separador = datos.split(",");
                if(tipo.equals("INTEGER")){
                  for (String dato: separador){
                      int numero = Integer.parseInt(dato);
                  }
                  pasa= true;
                }
                if(tipo.equals("CHAR")){
                    for (String dato: separador){
                        if(dato.length()>1)
                            pasa = false;
                    }

                }
                if(tipo.equals("BOOLEAN")){
                    for (String dato: separador){
                        if(!dato.equals("true")&&!dato.equals("false"))
                            pasa = false;
                    }

                }
            }
        }catch(Exception e){
            pasa = false;
            return false;
        }
        return pasa;
    }

    public void alamcenar_variable(String name, String valor, String tipo){
        variablex variable = new variablex(name, valor, tipo);
        pila.put(name, variable);
    }

    public Boolean operacion_aritmetica(String name, String operacion){
        try{
            boolean datos_correctos =true;
           // System.out.println("entramos a operaciones aritmeticas con esto: nombre: "+name +" operacion: "+operacion);
            for (String variable : pila.keySet()) {
                String valorMan = pila.get(variable).getValue();
                operacion = operacion.replaceAll(variable, valorMan);
            }
            if (operacion.matches(".*[a-zA-Z].*")) {
                //System.out.println("El String contiene al menos una letra.");
                return false;
            } else {
                operacion = transformar_ecuacion(operacion);

                //System.out.println("Tenemos el resultado de reemplazo: "+operacion);
                Double temp = resolver_ecuacion(operacion);
                //System.out.println("Resultado de resolver la ecuacion: "+temp);
                variablex nueva_variable = new variablex(name, Double.toString(temp),"Double");
                pila.put(name,nueva_variable);
            }



        }catch (Exception f){
            System.out.println(f.getMessage());
            return false;
        }
        return true;
    }
    public void operacion_concatenacion(String name, String ecuacion){
        try{
            boolean correcto= true;
            String resultado ="";
            //System.out.println("ENtramos a concatenacion con esto: "+ecuacion);
            ecuacion = ecuacion.replace('+',':');
            String[] arreglo = ecuacion.split(":");
            for(String temp: arreglo){
               // System.out.println("Tenemos el temp: "+temp);
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
                            //System.out.println("Valor del temp: "+frase);
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
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null,"Error al intentar asignar los valores a: "+name);
        }


    }
    public boolean operaciones_booleanas(String name, String ecuacion){
        if(ecuacion.contains("and")||ecuacion.contains("or")){
            //System.out.println("pasamos las condiciones booleanas");
            // Divide la cadena en sus componentes y los almacena en un array
            String[] componentes = ecuacion.split(" ");
            //recorremos el array para remplazar las variables por su valor
            for (int z  =0; z<componentes.length; z++){
                String temp = componentes[z];
                for(String clave: pila.keySet()){
                    if(clave.equals(temp)){
                        variablex variable = pila.get(clave);
                        componentes[z]=variable.getValue();
                    }
                }
            }
            // Inicializa el resultado en el valor del primer operando
            if (!componentes[0].equals("true")&&!componentes[0].equals("false"))
                return false;
            boolean resultado = Boolean.parseBoolean(componentes[0]);

            // Itera a través de los componentes de la cadena
            for (int i = 1; i < componentes.length; i += 2) {
                // Obtiene el operador actual
                String operador = componentes[i];

                // Obtiene el operando siguiente
                if (!componentes[i+1].equals("true")&&!componentes[i+1].equals("false"))
                    return false;
                boolean operando = Boolean.parseBoolean(componentes[i + 1]);

                // Aplica el operador booleano correspondiente
                switch (operador) {
                    case "and":
                        resultado = resultado && operando;
                        break;
                    case "or":
                        resultado = resultado || operando;
                        break;
                }
            }

            // El resultado final es el valor de la operación booleana
            //System.out.println("El resultado de la operación es: " + resultado);
            variablex nueva_variable = new variablex(name, Boolean.toString(resultado),"Boolean");
            pila.put(name,nueva_variable);
            return true;
        }else{
            return false;
        }


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
                    //System.out.println("Coincide: "+temp);
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
