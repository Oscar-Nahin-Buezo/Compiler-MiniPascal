package variables;

public class ArregloInteger extends Variable{
    private Integer[]valores;
    public ArregloInteger(String nombre, String tipo, String Scope) {
        super(nombre, tipo, Scope);
    }
    public ArregloInteger(String nombre, String tipo, String Scope, Integer[]valores) {
        super(nombre, tipo, Scope);
        this.valores=valores;
    }
    public ArregloInteger(String nombre, String tipo, String Scope, Integer rango) {
        super(nombre, tipo, Scope);
        this.valores=new Integer[rango];
    }

    public Integer[] getValores() {
        return valores;
    }

    public void setValores(Integer[] valores) {
        this.valores = valores;
    }
}
