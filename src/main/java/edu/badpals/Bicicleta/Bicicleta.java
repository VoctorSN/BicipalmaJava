package edu.badpals.Bicicleta;

public class Bicicleta {
    private final int id;

    Bicicleta(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return Integer.toString(getId());
    }
}
