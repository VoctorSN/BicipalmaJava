package edu.badpals.Estacion;

import edu.badpals.Bicicleta.Bicicleta;
import edu.badpals.TarjetaUsuario.TarjetaUsuario;

import java.util.Arrays;
import java.util.Optional;

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

    private Anclaje[] anclajes(){
        return this.anclajes.anclajes();
    }

    private int numeroAnclajes(){
        return anclajes.numAnclajes();
    }


    public void consultarEstacion(){
        System.out.println(this);
    }

    @Override
    public String toString(){
        return "id: " + getId() +
                " \ndireccion: " + getDireccion() +
                " \nanclajes: " + anclajes.numAnclajes();
    }

    public long anclajesLibres(){
        return Arrays.stream(anclajes()).filter(c -> !c.isOcupado()).count();
    }

    public void anclarBicicleta(Bicicleta bicicleta){
        Optional<Anclaje> anclajeLibre = Arrays.stream(anclajes()).filter(a -> !a.isOcupado()).findFirst();
        if (anclajeLibre.isPresent()) {
            anclajeLibre.get().anclarBici(bicicleta);
        } else {
            System.out.println("No hay bicis Libres");
        }
        return;
    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario){
        return tarjetaUsuario.isActivada();
    }


    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario){
        if (leerTarjetaUsuario(tarjetaUsuario)){
            Optional<Anclaje> anclajeOcupado = Arrays.stream(anclajes()).filter(a -> a.isOcupado()).findFirst();
            if (anclajeOcupado.isPresent()){
                mostrarBicicleta(anclajeOcupado.get().getBici());
                anclajeOcupado.get().liberarBici();
            } else {
                System.out.println("No hay bicis en los anclajes");
            }
        }
        System.out.println("Tu tarjeta no esta activada");
    }


    private void mostrarBicicleta(Bicicleta bicicleta){
        System.out.println("bicicleta retirada: " + bicicleta.getId());
    }
 /**
    private void mostrarAnclaje(Bicicleta bicicleta, int numeroAnclaje){

    }
**/
    public void consultarAnclajes(){

        Arrays.stream(anclajes()).forEach(anclaje ->
        {System.out.println("Anclaje: " + anclaje.getId() + " "
                + (anclaje.isOcupado() ? anclaje.getBici():"libre"));});

    }
}
