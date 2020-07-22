package ar.com.ada.api.stephix.services.implementations;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Serie;
import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;
import ar.com.ada.api.stephix.repos.SerieRepository;
import ar.com.ada.api.stephix.services.ISerieService;

@Service
public class SerieService implements ISerieService{

    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

	@Override
	public List<Serie> findAll() {
		return serieRepository.findAll();
	}

	@Override
	public Serie findById(ObjectId id) throws ResourceNotFoundException {
		return serieRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("model with id " + id + " not found"));
	}

	@Override
	public Serie save(Serie serie) {
		return serieRepository.save(serie);
	}

	@Override
	public void delete(Serie serie) {
		this.deleteById(serie.get_id());
	}

	@Override
	public void deleteById(ObjectId id) {
        if (!serieRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        serieRepository.deleteById(id);
	}

    @Override
    public Long count() {
        return serieRepository.count();
    }

	@Override
	public void deleteById(int id) {
        if (!serieRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        serieRepository.deleteById(id);		
	}

	@Override
	public void deleteById(String id) {
        if (!serieRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        serieRepository.deleteById(id);	
	}
}