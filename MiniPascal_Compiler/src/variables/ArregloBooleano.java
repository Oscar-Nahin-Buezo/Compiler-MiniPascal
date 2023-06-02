package variables;

public class ArregloBooleano extends Variable{
    private Boolean[]valores;
    public ArregloBooleano(String nombre, String tipo, String Scope) {
        super(nombre, tipo, Scope);
    }
    public ArregloBooleano(String nombre, String tipo, String Scope, Boolean[]valores) {
        super(nombre, tipo, Scope);
        this.valores= valores;
    }
    public ArregloBooleano(String nombre, String tipo, String Scope, Integer rango) {
        super(nombre, tipo, Scope);
        this.valores= new Boolean[rango];
    }

    public Boolean[] getValores() {
        return valores;
    }

    public void setValores(Boolean[] valores) {
        this.valores = valores;
    }
}
