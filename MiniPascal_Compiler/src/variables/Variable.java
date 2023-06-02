package variables;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Variable {
    private String nombre;
    private String tipo;
   private String Scope;


    public Variable(String nombre, String tipo, String Scope) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.Scope = Scope;
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

}
