import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.MiniPascalBaseListener;
import parser.MiniPascalParser;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GeneratorCode extends MiniPascalBaseListener {
    private HashMap<String, HashMap<String, Variable>> tablaFunciones = new HashMap<>();
    private HashMap<String, HashMap<String, Variable>> scopeGlobals = new HashMap<>();
    private HashMap<String, Variable> Global = new HashMap<>();
    @Override public void enterVarDeclaration(MiniPascalParser.VarDeclarationContext ctx) {
        System.out.println("Declaracion de variable");
    }
    @Override public void enterVarDeclList(MiniPascalParser.VarDeclListContext ctx) {
        //DECLARAMOS VARIABLES PERO SIN INICIALIZARLAS
        boolean existe = false;
        String evidencia = "";
        for (int i = 0; i<ctx.varDecl().getChildCount(); i++){
            if (ctx.varDecl().ID()!=null && ctx.varDecl().ID(i)!=null){
              if(Global.containsKey(ctx.varDecl().ID(i).getText())){
                  evidencia+=ctx.varDecl().ID(i).getText()+" ";
                  existe = true;
              }
            }
        }
        if(existe){
            System.out.println("Las variables: "+evidencia+" ya existen");
        }else{
            for (int i = 0; i<ctx.varDecl().getChildCount(); i++){
                if (ctx.varDecl().ID()!=null && ctx.varDecl().ID(i)!=null){
                    if(!Global.containsKey(ctx.varDecl().ID(i).getText())){
                        System.out.println(ctx.varDecl().ID(i).getText());
                        String tipo = ctx.varDecl().getChild(ctx.varDecl().getChildCount()-1).getText();
                        Variable newVariable = new Variable(ctx.varDecl().ID(i).getText(),tipo);
                        Global.put(ctx.varDecl().ID(i).getText(),newVariable);
                    }
                }
            }
        }
    }
    @Override public void enterAssignmentStatement(MiniPascalParser.AssignmentStatementContext ctx) {
        if(Global.isEmpty()){
            System.out.println("No existen variables en la tabla de simbolos");
        }
    }
}
