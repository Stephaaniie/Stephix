package ar.com.ada.api.stephix.repos;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.stephix.entities.*;

@Repository
public interface TemporadaRepository extends MongoRepository<Temporada,ObjectId>{
    
    Temporada findBy_id(ObjectId id);

    Temporada findByNumero(int numero);

    List<Episodio> findByEpisodios();

    Temporada findByAnio(int anio);
}