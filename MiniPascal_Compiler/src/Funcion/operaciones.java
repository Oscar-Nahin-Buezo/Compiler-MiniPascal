package Funcion;

public class operaciones {
    private String nameOperacion;
    private String expresion;

    public operaciones(String nameOperacion, String expresion) {
        this.nameOperacion = nameOperacion;
        this.expresion = expresion;
    }

    public String getNameOperacion() {
        return nameOperacion;
    }

    public void setNameOperacion(String nameOperacion) {
        this.nameOperacion = nameOperacion;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}
