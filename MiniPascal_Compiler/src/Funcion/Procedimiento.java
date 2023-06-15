package Funcion;

import tables.TableSymbol;
import variables.Variable;

import java.util.ArrayList;

public class Procedimiento{
    private String name;
    private ArrayList<Variable> parametros = new ArrayList<>();
    private TableSymbol simbolos ;
    private boolean returnValue;

    ArrayList< operaciones> operaciones = new ArrayList<>();

    public Procedimiento(String name, ArrayList<Variable>parametro){
        this.name= name;
        this.parametros = parametro;
        this.simbolos = new TableSymbol(name);

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
    public boolean addSymbolInTableProcedimiento ( Variable variable){
        return this.simbolos.addVariable(variable);
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



    public void imprimir_procedimiento(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Procedimiento: "+this.name );
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
