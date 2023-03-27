import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import static org.antlr.v4.runtime.CharStreams.fromFileName;
import static org.antlr.v4.runtime.CharStreams.fromString;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.*;
import parser.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al compilador Mini-Pascal!");
        String contenido ="";
        try{
            contenido = lectura_archivo();
            if(contenido!=""){
                CharStream cs = fromString(contenido);
                //Pasamos el codigo o texto al lexer para que genere los tokens
                MiniPascalLexer lexer = new MiniPascalLexer(cs);// depende que charStream usemos lo enviamos al lexer
                lexer.removeErrorListeners();
                lexer.addErrorListener(new MyErrorListener());
                CommonTokenStream token = new CommonTokenStream(lexer);

                //se procede a generar el arbol AST
                MiniPascalParser parser = new MiniPascalParser(token);
                parser.removeErrorListeners();
                parser.addErrorListener(new MyErrorListener());
                ParseTree tree = parser.start();
                ejecutarGui(tree, parser, contenido);
            }else{
                JOptionPane.showMessageDialog(null,"Selecciones un archivo");
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void ejecutarGui( ParseTree tree, MiniPascalParser parser, String contenido){
        vista visitor = new vista();
        visitor.visit(tree);
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        //TreeViewer viewer = null;
        JTextArea  entrada = new JTextArea(25,25);
        entrada.setText(contenido);
        JTextArea  salida = new JTextArea(25,25);
        JButton Compilar = new JButton("compilar");
        JButton Ver_AST = new JButton("Ver AST");
        JButton Seleccionar_archivo = new JButton("Seleccionar Archivo");
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();

        //************Eventos de botones***********************************************************
        Compilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = "";
                texto = entrada.getText();
                if(texto.isEmpty()){
                    JOptionPane.showMessageDialog(frame,
                            "Debe de escribir codigo de entrada\nArea de texto izquierda",
                            "Falta texto de entrada",
                            JOptionPane.ERROR_MESSAGE);
                }else{
                    //leemos el archivo que tiene el codigo a probar
                    CharStream cs = fromString(texto);

                    //Pasamos el codigo o texto al lexer para que genere los tokens
                    MiniPascalLexer lexer = new MiniPascalLexer(cs);// depende que charStream usemos lo enviamos al lexer
                    CommonTokenStream token = new CommonTokenStream(lexer);

                    //se procede a generar el arbol AST
                    MiniPascalParser parser = new MiniPascalParser(token);
                    ParseTree tree2 = parser.start();
                    visitor.visit(tree2);
                    viewer.setTree(tree2);
                    String resultados =Mostrar_resultado(tree2);
                    salida.setText(resultados);
                }
            }
        });
        Ver_AST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Visualizando el arbol en un panel
                //show AST in GUI

                viewer.open();
                viewer.setScale(2); // Scale a little
            }
        });

        Seleccionar_archivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                   String contenido="";
                   contenido = lectura_archivo();
                   if(contenido !=""){
                       entrada.setText(contenido);
                   }
                } catch (Exception f) {
                    System.out.println("An error occurred.");
                }
            }
        });
        //******************************************************************************************
        panel.add(entrada);
        panel.add(Compilar);
        panel.add(Ver_AST);
        panel.add(Seleccionar_archivo);
        panel.add(salida);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static String Mostrar_resultado(ParseTree tree){
        ParseTreeWalker caminante = new ParseTreeWalker();
        LeyendoCodigo lector = new LeyendoCodigo();
        caminante.walk(new LeyendoCodigo(), tree);
        String resultado = lector.mostrar_salida();
        return resultado;
    }
    public static String lectura_archivo() throws FileNotFoundException {
        String ruta2="";
        String contenido ="";
        try {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                ruta2 = selectedFile.getAbsolutePath();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                File myObj = new File(ruta2);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    contenido += data + "\n";
                    //System.out.println(data);
                }
                myReader.close();
            } else {
                System.out.println("Operacion canceleda");
            }
            return contenido;
        }catch (Exception f){
            System.out.println("Fallo en lectura de archivo");
            return contenido;
        }

    }

    public static ParseTree Crear_AST(String contenido){
        ParseTree tree = null;
        try {
            CharStream cs = fromString(contenido);

            //Pasamos el codigo o texto al lexer para que genere los tokens
            MiniPascalLexer lexer = new MiniPascalLexer(cs);// depende que charStream usemos lo enviamos al lexer
            CommonTokenStream token = new CommonTokenStream(lexer);

            //se procede a generar el arbol AST
            MiniPascalParser parser = new MiniPascalParser(token);
            tree = parser.start();
            return tree;
        }catch(Exception j){
            System.out.println(j);
            return tree;
        }

    }

}