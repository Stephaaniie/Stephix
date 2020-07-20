package ar.com.ada.api.stephix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Serie;
import ar.com.ada.api.stephix.repos.SerieRepository;

@Service
public class SerieService {

    @Autowired
    SerieRepository sRepository;

    public void grabar(Serie serie) {
        sRepository.save(serie);
    }    
    public List<Serie> listarSeries() {
        return sRepository.findAll();
    }
}