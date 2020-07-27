package ar.com.ada.api.stephix.services.implementations;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Pelicula;
import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;
import ar.com.ada.api.stephix.repos.PeliculaRepository;
import ar.com.ada.api.stephix.services.IPeliculaService;

@Service
public class PeliculaService implements IPeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

	@Override
	public List<Pelicula> findAll() {
		return peliculaRepository.findAll();
	}

	@Override
	public Pelicula findById(ObjectId id) throws ResourceNotFoundException {
		return peliculaRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("model with id " + id + " not found"));
	}

	@Override
	public Pelicula save(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public void delete(Pelicula pelicula) {
        this.deleteById(pelicula.get_id());
	}

	@Override
	public void deleteById(ObjectId id) {
		if (!peliculaRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        peliculaRepository.deleteById(id);
	}

	@Override
	public Long count() {
		return peliculaRepository.count();
	}
    
}