import parser.MiniPascalBaseVisitor;
import parser.MiniPascalParser;
public class vista extends  MiniPascalBaseVisitor<Object>{

    @Override public Object visitStart(MiniPascalParser.StartContext ctx) {
        System.out.println("Entramos a visita de comienzo");
        System.out.println(ctx.toString());
        return visitChildren(ctx);
    }
}
