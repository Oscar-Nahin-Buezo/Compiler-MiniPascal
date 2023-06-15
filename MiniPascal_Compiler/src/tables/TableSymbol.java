package tables;

import java.util.*;

import typing.Type;
import variables.Variable;

public class TableSymbol {
     public String name;
     public HashMap<String, Variable> variable = new HashMap<>() ;
     public String Scope;
     public Integer line;
     public Integer order;
    public TableSymbol(String name){
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Variable> getVariables() {
        return variable;
    }

    public void setVariable(HashMap<String,Variable> variable) {
        this.variable = variable;
    }

    public boolean addVariable(Variable variable) {
        if(this.variable.containsKey(variable.getNombre())){
            //System.out.println("No entro a ingresar variable global");
            return false;
        }else{
            //System.out.println("ENtro a ingresar variable global");
            this.variable.put(variable.getNombre(),variable);
            return true;
        }
    }
    public boolean removeSymbol(String variable) {
        if(this.variable.containsKey(variable)){
            return false;
        }else{
            this.variable.remove(variable);
            return true;
        }
    }
    public Object getSymbol(String name) {
        if(!this.variable.containsKey(name)){
            return false;
        }else{
            return this.variable.get(name);
        }
    }
    public String getScope() {
        return Scope;
    }

    public void setScope(String scope) {
        Scope = scope;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean exist_variable(String name){
        if(this.variable.containsKey(name))
            return true;
        return false;
    }

    public Variable getVariable(String name){
        if(this.variable.containsKey(name)){
            return this.variable.get(name);
        }else{
            return null;
        }
    }

    public boolean actualizarValorDeVariable(Variable variable, String valor){
        boolean correcto = false;
        if(this.variable.containsKey(variable.getNombre())){
            this.variable.get(variable.getNombre()).setValor(valor);
            correcto = true;
        }

        return correcto;
    }
    public Integer numero_variables(){
        return this.variable.size();
    }

    public void imprimir_tablas (){
        for (Map.Entry<String, Variable> entry : this.variable.entrySet()) {
            String key = entry.getKey();
            Variable value = entry.getValue();
            System.out.println("Variable o simbolo: "+key+" tipo: "+value.getTipo()+ " valor: "+value.getValor());

        }
    }
}
