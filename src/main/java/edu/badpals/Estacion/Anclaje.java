package edu.badpals.Estacion;

import edu.badpals.Bicicleta.Bicicleta;

public class Anclaje {

    private boolean ocupado = false;
    private int id;
    // Anclaje tiene una / has-a Bicicleta
    private Bicicleta bici = null;

    Anclaje(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    boolean isOcupado() {
        return this.ocupado;
    }

    Bicicleta getBici() {
        return this.bici;
    }

    void anclarBici(Bicicleta bici) {
        this.bici = bici;
        this.ocupado = true;
    }

    void liberarBici() {
        this.bici = null;
        this.ocupado = false;
    }

    @Override
    public String toString() {
        return "ocupado: " + Boolean.toString(isOcupado());
    }
}
