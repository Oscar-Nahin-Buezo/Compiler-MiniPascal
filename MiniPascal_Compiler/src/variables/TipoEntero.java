package variables;

public class TipoEntero extends Variable{
    private Integer valor;

    public TipoEntero(String nombre, String tipo, String Scope) {
        super(nombre, tipo, Scope);
    }
    public TipoEntero(String nombre, String tipo, String Scope, Integer valor) {
        super(nombre, tipo, Scope);
        this.valor=valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
    public Integer getValor() {
        return valor;
    }
}
