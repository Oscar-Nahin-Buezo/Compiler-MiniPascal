package variables;

public class TipoBoolean extends Variable{
    private Boolean valor;
    public TipoBoolean(String nombre, String tipo, String Scope) {
        super(nombre, tipo, Scope);
    }
    public TipoBoolean(String nombre, String tipo, String Scope, Boolean valor) {
        super(nombre, tipo, Scope);
        this.valor=valor;
    }

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }
}
