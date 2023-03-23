import parser.MiniPascalBaseListener;
import parser.MiniPascalParser;

public class LeyendoCodigo extends MiniPascalBaseListener {
    @Override public void enterSentencia_write(MiniPascalParser.Sentencia_writeContext ctx) {
        if(ctx.CONSTSTR()!=null && ctx.ID()==null)
            System.out.println(ctx.CONSTSTR());

        if(ctx.CONSTSTR()!=null && ctx.ID()!=null)
            System.out.println(ctx.CONSTSTR() +""+ctx.ID());
    }
    @Override public void enterExpresion(MiniPascalParser.ExpresionContext ctx) {
        System.out.println("Eentramns a una asigancion");
        System.out.println(ctx.getText());
    }
}
