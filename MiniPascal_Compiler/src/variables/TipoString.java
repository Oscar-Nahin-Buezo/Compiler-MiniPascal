package variables;

public class TipoString extends Variable{
    private String valor;
    public TipoString(String nombre, String tipo, String Scope) {
        super(nombre, tipo, Scope);
    }
    public TipoString(String nombre, String tipo, String Scope, String valor) {
        super(nombre, tipo, Scope);
        this.valor=valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
