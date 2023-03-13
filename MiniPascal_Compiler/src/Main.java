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
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al compilador Mini-Pascal!");
        int opcion =1;
        Scanner scanner = new Scanner(System.in);
        String contenido ="";
        try{
            try {
                File myObj = new File("MiniPascal_Compiler/src/codigo.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    contenido+=data+"\n";
                    System.out.println(data);
                }
                myReader.close();
            } catch (Exception f) {
                System.out.println("An error occurred.");
            }

            //leemos el archivo que tiene el codigo a probar
            String file = "MiniPascal_Compiler/src/codigo.txt";
            CharStream cs = fromFileName(file);

            //Pasamos el codigo o texto al lexer para que genere los tokens
            MiniPascalLexer lexer = new MiniPascalLexer(cs);// depende que charStream usemos lo enviamos al lexer
            CommonTokenStream token = new CommonTokenStream(lexer);

            //se procede a generar el arbol AST
            MiniPascalParser parser = new MiniPascalParser(token);
            ParseTree tree = parser.start();
            ejecutarGui(tree, parser, contenido);

            //cargamos un menu con las opciones del proyecto
           /* while(opcion!=0){
                System.out.println("Menu\n1. Ver arbol AST\n0. Salir");
                opcion= scanner.nextInt();
                if(opcion == 1){
                    //Visualizando el arbol en un panel
                    //show AST in GUI
                    TreeViewer viewer = new TreeViewer(Arrays.asList(
                            parser.getRuleNames()),tree);
                    viewer.open();
                    viewer.setScale(2); // Scale a little

                }
                if(opcion == 0)
                    break;
            }*/
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void ejecutarGui( ParseTree tree, MiniPascalParser parser, String contenido){
        vista visitor = new vista();
        visitor.visit(tree);
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);

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
                    Mostrar_resultado(tree2);
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
                    File myObj = new File("MiniPascal_Compiler/src/codigo.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
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
    public static void Mostrar_resultado(ParseTree tree){
        ParseTreeWalker caminante = new ParseTreeWalker();
        caminante.walk(new LeyendoCodigo(), tree);
    }
}