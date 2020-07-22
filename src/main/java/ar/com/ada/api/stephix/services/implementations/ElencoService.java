package ar.com.ada.api.stephix.services.implementations;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Actor;
import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;
import ar.com.ada.api.stephix.repos.ActorRepository;
import ar.com.ada.api.stephix.services.IElencoService;

@Service
public class ElencoService implements IElencoService{

    private final ActorRepository actorRepository;

    public ElencoService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

	@Override
	public Actor findById(ObjectId id) throws ResourceNotFoundException {
		return  actorRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("model with id " + id + " not found"));
	}

	@Override
	public Actor save(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public void delete(Actor actor) {
		this.deleteById(actor.get_id());
	}

	@Override
	public void deleteById(int id) {
		if (!actorRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        actorRepository.deleteById(id);
	}

	@Override
	public void deleteById(ObjectId id) {
		if (!actorRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        actorRepository.deleteById(id);
	}

	@Override
	public Long count() {
		return actorRepository.count();
	}

	@Override
	public void deleteById(String id) {
		if (!actorRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        actorRepository.deleteById(id);
	}

	@Override
	public List<Actor> findAll() {
		return actorRepository.findAll();
	}
    
}