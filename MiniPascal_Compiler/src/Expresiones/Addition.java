package Expresiones;

public class Addition extends Expresiones{
    Expresiones left;
    Expresiones right;

    public Addition(Expresiones left, Expresiones right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + "+" + right.toString();
    }
}
