package ar.com.ada.api.stephix.entities;


public class Episodio {

    private int numero;
    private String nombre;
    private int duracionEnMinutos;
    private String descripcion;

    // Creando getters y setters

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionEnMinutos() {
        return this.duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void reproducir() {
        System.out.println("Reproduciendo episodio " + this.numero + " " + this.nombre);
    }

}