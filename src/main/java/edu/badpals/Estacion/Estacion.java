package edu.badpals.Estacion;

public class Estacion {

    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    Estacion(int id, String direccion, int numeroAnclajes){
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numeroAnclajes);
    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String  consultarEstacion(){
        return "id: " + getId() +
                "\ndireccion: " + getDireccion() +
                "\nnumeroAnclajes: " + this.anclajes.getAnclajes().length();
    }


}
