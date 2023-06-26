package Funcion;

import tables.TableSymbol;
import variables.Variable;

public class subRutina {
    private String scopeSuper;
    private String name;
    private TableSymbol VariablesTemporales;

    public subRutina(String name, String scopeSuper){
        this.name= name;
        this.scopeSuper = scopeSuper;
        this.VariablesTemporales = new TableSymbol(name);
    }
    public String getScopeSuper() {
        return scopeSuper;
    }

    public void setScopeSuper(String scopeSuper) {
        this.scopeSuper = scopeSuper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TableSymbol getVariablesTemporales() {
        return VariablesTemporales;
    }

    public void setVariablesTemporales(TableSymbol variablesTemporales) {
        VariablesTemporales = variablesTemporales;
    }
    public boolean addSymbolInTableFunction ( Variable variable){
        return this.VariablesTemporales.addVariable(variable);
    }
    public boolean actualizarValorDeVariable(Variable variable, String valor){
        return this.VariablesTemporales.actualizarValorDeVariable(variable, valor);
    }
}
