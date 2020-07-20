package ar.com.ada.api.stephix.entities;

import java.util.*;

public class Temporada {
    
    private int numero;
    private int anio;
    private List<Episodio> episodios = new ArrayList<>();
 
    public int getNumero(){
        return this.numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
 
    public int getAnio(){
        return this.anio;
    }
      
    public void setAnio(int anio){
        this.anio = anio;
    }
 
    public List<Episodio> getEpisodios(){
        return this.episodios;
    }
     
    public void setEpisodios(List<Episodio> episodios){
        this.episodios = episodios;
    }
 
    public Episodio getEpisodio(int nro) {
        for (Episodio ep : this.episodios) {
            if (ep.getNumero() == nro) {
                return ep;
            }
        }
        return null;
    }
 
    public Episodio getEpisodioAtPosicion (int pos) {
        return this.episodios.get(pos);
    }
     
 
}