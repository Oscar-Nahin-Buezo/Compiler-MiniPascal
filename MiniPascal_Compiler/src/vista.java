import parser.MiniPascalBaseVisitor;
import parser.MiniPascalParser;
public class vista extends  MiniPascalBaseVisitor<Object>{

    @Override public Object visitProgram(MiniPascalParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

}
