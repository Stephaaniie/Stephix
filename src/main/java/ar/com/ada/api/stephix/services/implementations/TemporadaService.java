package ar.com.ada.api.stephix.services.implementations;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Episodio;
import ar.com.ada.api.stephix.entities.Serie;
import ar.com.ada.api.stephix.entities.Temporada;
import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;
import ar.com.ada.api.stephix.repos.EpisodioRepository;
import ar.com.ada.api.stephix.repos.TemporadaRepository;
import ar.com.ada.api.stephix.services.ITemporadaService;

@Service
public class TemporadaService implements ITemporadaService {

	@Autowired
	EpisodioRepository eRepository;
	
    private final TemporadaRepository temporadaRepository;

	public TemporadaService(TemporadaRepository temporadaRepository){
        this.temporadaRepository = temporadaRepository;
    }

	@Override
	public List<Temporada> findAll() {
		return temporadaRepository.findAll();
	}

	@Override
	public Temporada findById(ObjectId id) throws ResourceNotFoundException {
        return temporadaRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("model with id " + id + " not found"));
	}

	@Override
	public Temporada save(Temporada temporada) {
		return temporadaRepository.save(temporada);
	}

	@Override
	public void delete(Temporada temporada) {
        this.deleteById(temporada.get_id());
	}

	@Override
	public void deleteById(ObjectId id) {
		if (!temporadaRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        temporadaRepository.deleteById(id);
	}

	@Override
	public Long count() {
		return temporadaRepository.count();
	}

	public List<Episodio> findByEpisodios(Serie serie) {
		return temporadaRepository.findByEpisodios();
	}

	public Episodio save(Episodio episodio, ObjectId objectId) {
		Temporada temporada = this.findById(objectId);
		temporada.setEpisodio(episodio);
		return eRepository.save(episodio);
	}

	public Episodio findByEpisodio(Temporada temporada, String id1) {
		return eRepository.findByNombre(id1);
	}
}