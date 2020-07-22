package ar.com.ada.api.stephix.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.stephix.entities.Episodio;

@Repository
public interface EpisodioRepository extends MongoRepository<Episodio,ObjectId>{
    
    Episodio findBy_id(ObjectId id);

    Episodio findByNombre(String nombre);

    Episodio findByDuracionEnMinutos(int duracion);

    Episodio findByDescripcion(String descripcion);

    Episodio findByNumero(int numero);
}