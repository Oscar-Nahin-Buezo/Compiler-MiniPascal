import parser.MiniPascalBaseVisitor;
import parser.MiniPascalParser;
public class vista extends  MiniPascalBaseVisitor<Object>{

    @Override public Object visitStart(MiniPascalParser.StartContext ctx) {
        System.out.println("Entramos a visita de comienzo");
        System.out.println(ctx.toString());
        return visitChildren(ctx);
    }
    @Override public Object visitInicializar_variable(MiniPascalParser.Inicializar_variableContext ctx) {
        String cadena = ctx.getText();
        System.out.println("Tenemos esto en inicalizacion de variable: "+cadena);
        return visitChildren(ctx);
    }
}
