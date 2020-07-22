package ar.com.ada.api.stephix.services;

import ar.com.ada.api.stephix.entities.Serie;

public interface ISerieService extends IEntityCRUDService<Serie>{
    
    long countBySerieId(int id);

    long countByTemporadaId(int id);
}