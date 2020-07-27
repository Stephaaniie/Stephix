package ar.com.ada.api.stephix.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.stephix.entities.CuentaUser;

@Repository
public interface CuentaUserRepository  extends MongoRepository<CuentaUser,ObjectId> {
    
}