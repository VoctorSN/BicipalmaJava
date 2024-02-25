package edu.badpals.Estacion;

import edu.badpals.Bicicleta.Bicicleta;
import edu.badpals.TarjetaUsuario.TarjetaUsuario;

public class Estacion {

    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    public Estacion(int id, String direccion, int numeroAnclajes){
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numeroAnclajes);
    }

    private int getId() {
        return id;
    }

    private String getDireccion() {
        return direccion;
    }

    private Anclajes anclajes(){
        return anclajes;
    }

    private int numeroAnclajes(){
        return anclajes.numAnclajes();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void consultarEstacion(){
        System.out.println("id: " + getId() +
                "\ndireccion: " + getDireccion() +
                "\nnumeroAnclajes: " + anclajes.numAnclajes());
    }

    public int anclajesLibres(){
        int numeroanclajes = numeroAnclajes();
        Anclajes anclajes = anclajes();
        int anclajesVacios = 0;
        for (int i=0; i < numeroanclajes; i++){
            if (!anclajes.isAnclajeOcupado(i)){
                anclajesVacios += 1;
            }
        }
        return anclajesVacios;
    }

    public void anclarBicicleta(Bicicleta bicicleta){
        int numeroAnclajes = numeroAnclajes();
        for (int i=0;i<numeroAnclajes;i++){
            if (!anclajes.isAnclajeOcupado(i)){
                anclajes.ocuparAnclaje(i,bicicleta);
                System.out.println("bicicleta: " + bicicleta + " anclada en el anclaje: " + (i+1));
                return;
            }
        }
    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario, boolean par){
        return tarjetaUsuario.isActivada();
    }


    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario){
        if (leerTarjetaUsuario(tarjetaUsuario, true)){
            int numeroAnclajes = numeroAnclajes();
            for (int i=0; i<numeroAnclajes;i++){
                if (anclajes().isAnclajeOcupado(i)){
                    System.out.println("bicicleta retirada: " + anclajes.getBici(i) + " del anclaje: " + (i+1));
                    anclajes.liberarAnclaje(i);
                    return;
                }
            }
        }
        System.out.println("Tu tarjeta no esta activada");
    }

/**
    private void mostrarBicicleta(Bicicleta bicicleta, int numeroAnclaje){

    }

    private void mostrarAnclaje(Bicicleta bicicleta, int numeroAnclaje){

    }
**/
    public void consultarAnclajes(){
        int numeroAnclajes = numeroAnclajes();
        for (int i=0; i<numeroAnclajes ;i++) {
            String libre = "libre";
            if (anclajes.isAnclajeOcupado(i)){
                libre = anclajes.getBici(i).toString();
            }
            System.out.println("Anclje: " + (i+1) + " " + libre);
        }
    }
}
