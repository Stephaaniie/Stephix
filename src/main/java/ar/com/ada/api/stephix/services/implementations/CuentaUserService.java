package ar.com.ada.api.stephix.services.implementations;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.CuentaUser;
import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;
import ar.com.ada.api.stephix.repos.CuentaUserRepository;
import ar.com.ada.api.stephix.services.ICuentaService;

@Service
public class CuentaUserService implements ICuentaService {

    private final CuentaUserRepository userRepository;

    public CuentaUserService(CuentaUserRepository userRepository){
        this.userRepository = userRepository;
    }
    
	@Override
	public List<CuentaUser> findAll() {
		return userRepository.findAll();
	}

	@Override
	public CuentaUser findById(ObjectId id) throws ResourceNotFoundException {
		return  userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("model with id " + id + " not found"));
	}

	@Override
	public CuentaUser save(CuentaUser cuenta) {
		return userRepository.save(cuenta);
	}

	@Override
	public void delete(CuentaUser cuenta) {
		this.deleteById(cuenta.get_id());
	}

	@Override
	public void deleteById(ObjectId id) {
		if (!userRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        userRepository.deleteById(id);
	}

	@Override
	public Long count() {
		return userRepository.count();
	}

}