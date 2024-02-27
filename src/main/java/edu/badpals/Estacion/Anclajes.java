package edu.badpals.Estacion;

import edu.badpals.Bicicleta.Bicicleta;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Anclajes {

    private final Anclaje[] anclajes;

    Anclajes(int numAnclajes) {
        this.anclajes = new Anclaje[numAnclajes];
        crearAnclajes();
    }

    void liberarAnclaje(int anclaje){
        anclajes[anclaje].liberarBici();
    }

    void ocuparAnclaje(int anclaje, Bicicleta bicicleta){
        anclajes[anclaje].anclarBici(bicicleta);
    }

    public Anclaje[] getAnclajes() {
        return anclajes;
    }

    public int numAnclajes(){
        return getAnclajes().length;
    }

    private void crearAnclajes() {
        for (int i=0;i<anclajes.length;i++){
            anclajes[i] = new Anclaje(i+1);
        }
    }

    Anclaje[] anclajes(){
        return this.anclajes;
    }

    Bicicleta getBici(int anclaje){
        return anclajes[anclaje].getBici();
    }

    Bicicleta getBici(Anclaje anclaje){
        return anclaje.getBici();
    }

    boolean isAnclajeOcupado(int anclaje){
        return anclajes[anclaje].isOcupado();
    }

    @Override
    public String toString(){
        return "Numero de anclajes: " + this.numAnclajes();
    }

}
