package variables;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Variable {
    private String nombre;
    private String tipo;
   private String Scope;
   private boolean inicializada;
   private String valor;

    public Variable(String nombre, String tipo, String Scope) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.Scope = Scope;
        this.inicializada =false;
    }

    public Variable(String nombre, String tipo, String Scope, String valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.Scope = Scope;
        this.valor =valor;
        this.inicializada =true;
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

    public String getScope() {
        return Scope;
    }

    public void setScope(String scope) {
        Scope = scope;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
        this.inicializada = true;
    }
    public boolean isInicializada(){
        return this.inicializada;
    }

    public void imprimir_variable(){
        System.out.println("Scope: "+this.Scope+" nombre: "+this.nombre+" tipo: "+this.tipo+ " valor: "+this.valor);
    }
}
