package org.example;

import javax.swing.*;

public class comida extends JFrame{
    private JPanel comedor;
    private JButton compilarButton;
    private JButton ASTButton;
    private JButton Seleccionar_archivo;
    private JTextArea codigo_entrada;
    private JTextArea resultado;
    private JTextField textField1;
    public  comida(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(comedor);
        this.pack();

    }
    public static void main(String[]args){
        JFrame ventana = new comida("Compilador Mini-Pascal");
        ventana.setVisible(true);
    }
}
