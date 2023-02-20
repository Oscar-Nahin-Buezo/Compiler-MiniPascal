import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import static org.antlr.v4.runtime.CharStreams.fromFileName;
import static org.antlr.v4.runtime.CharStreams.fromString;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.*;
import parser.*;
import java.util.Scanner;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al compilador Mini-Pascal!");
        int opcion =1;
        Scanner scanner = new Scanner(System.in);
        try{
            //leemos el archivo que tiene el codigo a probar
            String file = "src/ejemplo";
            CharStream cs = fromFileName(file);

            //Pasamos el codigo o texto al lexer para que genere los tokens
            MiniPascalLexer lexer = new MiniPascalLexer(cs);// depende que charStream usemos lo enviamos al lexer
            CommonTokenStream token = new CommonTokenStream(lexer);

            //se procede a generar el arbol AST
            MiniPascalParser parser = new MiniPascalParser(token);
            ParseTree tree = parser.start();
            vista visitor = new vista();
            visitor.visit(tree);

            //cargamos un menu con las opciones del proyecto
            while(opcion!=0){
                System.out.println("Menu\n1. Ver arbol AST\n0. Salir");
                opcion= scanner.nextInt();
                if(opcion == 1){
                    //Visualizando el arbol en un panel
                    //show AST in GUI
                    TreeViewer viewer = new TreeViewer(Arrays.asList(
                            parser.getRuleNames()),tree);
                    viewer.open();
                    viewer.setScale(2); // Scale a little
                    /*JFrame frame = new JFrame("Antlr AST");
                    JPanel panel = new JPanel();
                    panel.add(viewer);
                    frame.add(panel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);*/
                }
                if(opcion == 0)
                    break;
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }

}