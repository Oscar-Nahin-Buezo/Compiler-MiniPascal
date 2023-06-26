package Funcion;

import tables.TableSymbol;
import variables.Variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Funcion {
    private String name;
    private ArrayList<Variable> parametros = new ArrayList<>();
    private TableSymbol simbolos ;
    private TableSymbol varTemporales;
    private boolean returnValue;
    private String tipoRenorno;
    private String resultType;
    ArrayList< operaciones> operaciones = new ArrayList<>();

    public Funcion(String name, ArrayList<Variable>parametro){
        this.name= name;
        this.parametros = parametro;
        this.simbolos = new TableSymbol(name);
        this.varTemporales = new TableSymbol(name);
        this.resultType="null";
    }
    public Funcion(String name, ArrayList<Variable>parametro, String resultType){
        this.name= name;
        this.parametros = parametro;
        this.simbolos = new TableSymbol(name);
        this.resultType=resultType;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(ArrayList<operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    public boolean AddOperacion(operaciones operacion) {
        boolean correcto = true;
        for(operaciones Op: operaciones){
            if(Op.getNameOperacion().equalsIgnoreCase(operacion.getNameOperacion()))
                correcto= false;
        }
        if(correcto){
            this.operaciones.add(operacion);
        }

        return false;
    }

    public Integer getNumeroParametros(){
        return this.parametros.size();
    }
    public boolean actualizar_parametro (int pos, Variable var){
        boolean correcto = false;
        try{
            this.parametros.get(pos).setValor(var.getValor());
            correcto = true;
        }catch(Exception e){
            correcto = false;
        }

        return correcto;
    }
    public boolean addSymbolInTableFunction ( Variable variable){
        return this.simbolos.addVariable(variable);
    }
    public boolean addSymbolInVarTemporales ( Variable variable){
        return this.varTemporales.addVariable(variable);
    }
    public void resetearVarTemporales (){
        this.varTemporales = new TableSymbol(this.name);
    }
    public boolean actualizarValorDeVariableTemporal(Variable variable, String valor){
        return this.varTemporales.actualizarValorDeVariable(variable, valor);
    }
    public boolean actualizarValorDeVariable(Variable variable, String valor){
        return this.simbolos.actualizarValorDeVariable(variable, valor);
    }
    public ArrayList<Variable> getParametros(){
        return this.parametros;
    }

    public void setParametros(ArrayList<Variable> parametros) {
        this.parametros = parametros;
    }
    public boolean setOperacion(String name, String expresion){
        boolean valido = false;
        for(int i = 0; i<this.operaciones.size(); i++){
            operaciones op = this.operaciones.get(i);
            if(op.getNameOperacion().equalsIgnoreCase(name)){
                this.operaciones.get(i).setExpresion(expresion);
                valido = true;
            }
        }
        return valido;
    }
    public TableSymbol getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(TableSymbol simbolos) {
        this.simbolos = simbolos;
    }

    public boolean isReturnValue() {
        return returnValue;
    }

    public void setReturnValue(boolean returnValue) {
        this.returnValue = returnValue;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public void imprimir_funcion(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Funcion: "+this.name+" Tipo de valor de retorno: "+this.resultType);
        System.out.println("Parametros: ");
        for(Variable var: this.parametros){
            System.out.println(var.getNombre()+" Tipo: "+var.getTipo()+" valor: "+var.getValor());
        }
        System.out.println("Tabla de simbolos");
        this.simbolos.imprimir_tablas();
        System.out.println("Operaciones: ");
        for (operaciones operacion : this.operaciones) {
            System.out.println(operacion.getNameOperacion()+": "+operacion.getExpresion());
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}
