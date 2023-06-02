package tables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Formatter;

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
            return false;
        }else{
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
}
