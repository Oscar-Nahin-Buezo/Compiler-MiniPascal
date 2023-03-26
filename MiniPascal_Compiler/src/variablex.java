public class variablex {
    String name="";
    String value="";
    String tipo="";
    public variablex(String name, String value, String tipo){
        this.name = name;
        this.value= value;
        this.tipo = tipo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getTipo() {
        return tipo;
    }
}
