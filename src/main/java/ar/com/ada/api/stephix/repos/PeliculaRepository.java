package ar.com.ada.api.stephix.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.stephix.entities.Pelicula;

@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula,ObjectId>{
    
}