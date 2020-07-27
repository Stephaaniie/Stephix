package ar.com.ada.api.stephix.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.ada.api.stephix.entities.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario,ObjectId> {

	Usuario findByUsername(String nombre);
    
}