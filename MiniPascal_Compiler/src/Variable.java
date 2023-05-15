import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Variable {
    private String nombre;
    private String tipo;
    private Object valor;

    public Variable(String nombre, String tipo, Object valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Variable(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
