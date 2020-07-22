package ar.com.ada.api.stephix.repos;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.stephix.entities.Actor;
import ar.com.ada.api.stephix.entities.Pelicula;

@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula,ObjectId>{
    
    Pelicula findBy_id(ObjectId id);

    Pelicula findByNombre(String nombre);

    Pelicula findByClasificacionSerie(String clasificacion);

    List<Pelicula>findByCalificacion(double calificacion);

    List<Pelicula>findByGenero(String genero);

    List<Pelicula>findByAnio(int anio);

    List<Actor>findByElenco();

	void deleteById(int id);

	boolean existsById(String id);

	boolean existsById(int id);

	void deleteById(String id);
}