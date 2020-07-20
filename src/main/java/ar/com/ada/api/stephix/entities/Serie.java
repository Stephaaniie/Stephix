package ar.com.ada.api.stephix.entities;

import java.util.*;

public class Serie extends Contenido {

    private List<Temporada> temporadas = new ArrayList<>();

    private int cantidadDeTemporadas;

    public int getCantidadDeTemporadas() {
        return cantidadDeTemporadas;
    }

    public void setCantidadDeTemporadas(int cantidadDeTemporadas) {
        this.cantidadDeTemporadas = cantidadDeTemporadas;
    }

    public List<Temporada> getTemporadas(){
        return this.temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas){
        this.temporadas = temporadas;
    }
 
    public Temporada buscarTemporada(int nro) {
        for (Temporada tempo : this.temporadas) {
            if (tempo.getNumero() == nro) {
                return tempo;
            }

        }
        return null;
    }
}