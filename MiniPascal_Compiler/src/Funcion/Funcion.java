package Funcion;

import java.util.ArrayList;
import java.util.HashMap;

public class Funcion {
    private String name;
    private boolean returnValue;
    HashMap<String, operaciones> operaciones = new HashMap<>();

    public Funcion(String name){
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(HashMap<String, operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    public boolean AddOperacion(operaciones operacion) {
        boolean correcto = true;
        if(this.operaciones.containsKey(operacion.getNameOperacion())){
            correcto = false;
        }else{
            this.operaciones.put(operacion.getNameOperacion(), operacion);
        }


        return false;
    }

    public void imprimir_funcion(){
        System.out.println("Funcion: "+this.name);
        System.out.println("Operaciones: ");
        for (operaciones operacion : this.operaciones.values()) {
            System.out.println(operacion.getNameOperacion()+": "+operacion.getExpresion());
        }
    }
}
