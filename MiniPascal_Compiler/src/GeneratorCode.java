import parser.MiniPascalBaseListener;
import parser.MiniPascalParser;

import java.util.HashMap;

public class GeneratorCode extends MiniPascalBaseListener {
    private HashMap<String, HashMap<String, Variable>> SymbolTable = new HashMap<>();
    private HashMap<String, Variable> Global = new HashMap<>();
    @Override public void enterVarDeclaration(MiniPascalParser.VarDeclarationContext ctx) {
        System.out.println(ctx.varDeclList());
        this.Global.containsKey(ctx.varDeclList());
    }

}
