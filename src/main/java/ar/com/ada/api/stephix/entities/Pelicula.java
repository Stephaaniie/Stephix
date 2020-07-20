package ar.com.ada.api.stephix.entities;

public class Pelicula extends Contenido {

    private int duracionEnMinutos;

    public int getDuracionEnMinutos() {
        return this.duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

}