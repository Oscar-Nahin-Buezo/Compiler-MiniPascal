package variables;

public class ArregloDouble extends Variable {
    private Double[] valores;
    public ArregloDouble(String nombre, String tipo, String Scope) {
        super(nombre, tipo, Scope);
    }
    public ArregloDouble(String nombre, String tipo, String Scope, Double []valores) {
        super(nombre, tipo, Scope);
        this.valores = valores;
    }
    public ArregloDouble(String nombre, String tipo, String Scope, Integer rango) {
        super(nombre, tipo, Scope);
        this.valores = new Double[rango];
    }

    public Double[] getValores() {
        return valores;
    }

    public void setValores(Double[] valores) {
        this.valores = valores;
    }
}
