package ar.com.ada.api.stephix.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.stephix.entities.Actor;

@Repository
public interface ActorRepository extends MongoRepository<Actor,ObjectId>{

	boolean existsById(int id);

	void deleteById(int id);

	void deleteById(String id);

	boolean existsById(String id);
    
}