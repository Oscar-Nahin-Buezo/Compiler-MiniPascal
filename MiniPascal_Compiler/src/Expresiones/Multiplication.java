package Expresiones;

public class Multiplication extends Expresiones{
    Expresiones left;
    Expresiones right;

    public Multiplication(Expresiones left, Expresiones right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + "*" + right.toString();
    }
}
