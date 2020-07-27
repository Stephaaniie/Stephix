package ar.com.ada.api.stephix.entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Contenido {

    private ObjectId _id;
    
    private String nombre;

    private String clasificacion;

    private double calificacion;

    private String genero;

    private int anio;

    private String descripcion;

    private List<Actor> actores = new ArrayList<>();

    public void reproducir () {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	public ObjectId get_id() {
		return _id;
	}
}
