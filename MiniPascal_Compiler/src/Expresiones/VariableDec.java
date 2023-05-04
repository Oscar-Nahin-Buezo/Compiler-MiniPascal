package Expresiones;

public class VariableDec extends Expresiones{
    public String id;
    public String type;
    public int value;

    public VariableDec(String id, String type, int value){
        this.id = id;
        this.type = type;
        this.value = value;
    }
}
