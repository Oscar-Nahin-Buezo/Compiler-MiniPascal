package Expresiones;

import java.util.ArrayList;
import java.util.List;
public class Program {
    public List<Expresiones> expresiones;

    public Program(){
        this.expresiones = new ArrayList<>();
    }
    public void addExpresion(Expresiones e){
        expresiones.add(e);
    }
}
