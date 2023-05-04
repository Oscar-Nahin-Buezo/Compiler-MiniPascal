package Expresiones;

public class Variable extends Expresiones{
    String id;

    public Variable(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
