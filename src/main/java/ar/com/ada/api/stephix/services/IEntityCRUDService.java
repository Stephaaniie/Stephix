package ar.com.ada.api.stephix.services;

import java.util.List;

import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;

public interface IEntityCRUDService <E> {
    List<E> findAll();

    E findById(int id) throws ResourceNotFoundException;

    E save(E entity);

    void delete(E entity);

    void deleteById(int id);

    Long count();
}
