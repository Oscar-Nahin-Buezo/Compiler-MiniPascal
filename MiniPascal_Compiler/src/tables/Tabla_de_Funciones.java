package tables;

import java.util.HashMap;
import java.util.List;
import typing.Type;
import variables.Variable;

import java.util.Formatter;
import java.util.Map;

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

    public boolean existe_variable_en_tabla(String nameTable, String nameVariable){
        boolean existe = false;
        if(this.funciones.containsKey(nameTable)){
            TableSymbol tabla = this.funciones.get(nameTable);
            existe = tabla.exist_variable(nameVariable);
        }
        return existe;
    }
    public Variable getVariableFromTable(String name, String scope){
        if(this.funciones.containsKey(scope)){
            TableSymbol tabla = this.funciones.get(scope);
            if(tabla.exist_variable(name))
                return tabla.getVariable(name);
        }
            return null;

    }
    public boolean actualizarValorDeVariable(Variable variable, String valor){
        boolean correcto = false;
        if(this.funciones.containsKey(variable.getScope())){
            this.funciones.get(variable.getScope()).getVariable(variable.getNombre()).setValor(valor);
            correcto = true;
        }

        return correcto;
    }

    public boolean exist_table(String name){
        if(this.funciones.containsKey(name)){
            return true;
        }
        return false;
    }

    public void imprimir_tablas (){
        for (Map.Entry<String, TableSymbol> entry : this.funciones.entrySet()) {
            String key = entry.getKey();
            TableSymbol value = entry.getValue();
            System.out.println("Tabla de: "+key);
            System.out.println("NUmero de variables: "+value.numero_variables());
            for (Map.Entry<String, Variable> entry2 : value.getVariables().entrySet()) {
                String key2 = entry2.getKey();
                Variable value2 = entry2.getValue();
                System.out.println("Symbolo o variable: " + key2 + ", Tipo: " + value2.getTipo());
            }

        }
    }
}
