package ar.com.ada.api.stephix.services;

import java.util.List;

import org.bson.types.ObjectId;
import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;

public interface IEntityCRUDService <E> {
    
    List<E> findAll();

    E findById(ObjectId id) throws ResourceNotFoundException;

    E save(E entity);

    void delete(E entity);

    void deleteById(int id);

    void deleteById(String id);

    void deleteById(ObjectId id);

    Long count();
}
