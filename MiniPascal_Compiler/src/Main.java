import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import static org.antlr.v4.runtime.CharStreams.fromFileName;
import static org.antlr.v4.runtime.CharStreams.fromString;
import parser.*;
import java.io.FileInputStream;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try{
            String file = "src/ejemplo";

            CharStream cs = fromFileName(file);

            MiniPascalLexer lexer = new MiniPascalLexer(cs);// depende que charStream usemos lo enviamos al lexer
            CommonTokenStream token = new CommonTokenStream(lexer);
            MiniPascalParser parser = new MiniPascalParser(token);
            ParseTree tree = parser.start();

            vista visitor = new vista();
            visitor.visit(tree);
        }catch(Exception e){
            System.out.println(e);
        }

    }
}