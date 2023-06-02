package tables;

import java.util.HashMap;
import java.util.List;
import typing.Type;
import variables.Variable;

import java.util.Formatter;

public class Tabla_de_Funciones  {
    private String name;
    private HashMap<String, TableSymbol> funciones = new HashMap<>();
    public Tabla_de_Funciones(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, TableSymbol> getFunciones() {
        return funciones;
    }

    public TableSymbol getTablaFuncion(String name) {
        return funciones.get(name);
    }

    public void setFunciones(HashMap<String, TableSymbol> funciones) {
        this.funciones = funciones;
    }

    public boolean addTablaFuncion(TableSymbol funcion) {
        if(this.funciones.containsKey(funcion.getName())){
            return false;
        }else{
            this.funciones.put(funcion.getName(), funcion);
            return true;
        }

    }

    public boolean addSymbolInTableFunction (String name, Variable variable){
        //verificamos si la tabla existe
        if(funciones.containsKey(name)){
            TableSymbol tempTable = funciones.get(name);
            if(tempTable.variable.containsKey(variable.getNombre())){
                return false;
            }else{
                funciones.get(name).variable.put(variable.getNombre(), variable);
                return true;
            }

        }else{
            return false;
        }
    }
}
