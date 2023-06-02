package validador;

import parser.MiniPascalBaseListener;

import parser.MiniPascalParser;
import tables.Tabla_de_Funciones;
import tables.TableSymbol;
import variables.Variable;

public class validador_semantico extends MiniPascalBaseListener  {
    private String ActualScope = "Global";
    private TableSymbol GlobalSymbol = new TableSymbol("Global");
    private Tabla_de_Funciones Funciones = new Tabla_de_Funciones("Funciones");
    private Boolean correcto = true;
    private String MessageError = "";
    @Override public void enterVariableDeclaration(MiniPascalParser.VariableDeclarationContext ctx) {
        if(correcto){
            System.out.println("El Scope es: "+this.ActualScope);
            System.out.println(ctx.identifierList().getText());
        }


    }
    @Override public void exitFunctionDeclaration(MiniPascalParser.FunctionDeclarationContext ctx) {
        if(correcto){
            this.ActualScope= "Global";
            System.out.println("Sale de declarar funcion");
        }

    }
    @Override public void enterFunctionDeclaration(MiniPascalParser.FunctionDeclarationContext ctx) {
        if(correcto){
            this.ActualScope= ctx.identifier().getText();
            TableSymbol newTable = new TableSymbol(ctx.identifier().getText());
            boolean agregado = this.Funciones.addTablaFuncion(newTable);

            System.out.println("Entra a declarar funcion");
        }

    }
    public boolean chequeo_existencia_variable(Variable variable) {
        if (correcto) {
            if (this.ActualScope.equalsIgnoreCase("global")) {
                return this.GlobalSymbol.addVariable(variable);
            } else {
                TableSymbol newTableSymbol = new TableSymbol(this.ActualScope);
                return (this.Funciones.addTablaFuncion(newTableSymbol));
            }
        }else{
            return false;
        }
    }
}
