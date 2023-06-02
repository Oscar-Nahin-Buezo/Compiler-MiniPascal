package variables;

public class ArregloString extends Variable{
    private String[]valores;
    public ArregloString(String nombre, String tipo, String Scope) {
        super(nombre, tipo, Scope);
    }
    public ArregloString(String nombre, String tipo, String Scope, String []valores) {
        super(nombre, tipo, Scope);
        this.valores =valores;
    }
    public ArregloString(String nombre, String tipo, String Scope, Integer rango) {
        super(nombre, tipo, Scope);
        this.valores =new String[rango];
    }

    public String[] getValores() {
        return valores;
    }

    public void setValores(String[] valores) {
        this.valores = valores;
    }
}
