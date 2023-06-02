package variables;

public class TipoDouble extends Variable{
    private Double valor;
    public TipoDouble(String nombre, String tipo, String Scope) {
        super(nombre, tipo, Scope);
    }
    public TipoDouble(String nombre, String tipo, String Scope, Double valor) {
        super(nombre, tipo, Scope);
        this.valor=valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
