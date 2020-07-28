package ar.com.ada.api.stephix.entities;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Series")
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
        Optional<Temporada> temporada = this.getTemporadas().stream().filter(x -> x.getNumero() == nro).findFirst();
       
        return temporada.isPresent() ? temporada.get() : null;
    }

	public Temporada findByTemporada(int id) {
		return this.buscarTemporada(id);
	}

	public void setTemporada(Temporada temporada) {
        this.temporadas.add(temporada);
	}
}