package ar.com.ada.api.stephix.services.implementations;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Usuario;
import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;
import ar.com.ada.api.stephix.repos.UsuarioRepository;
import ar.com.ada.api.stephix.services.IUsuarioServer;

@Service
public class UsuarioServer implements IUsuarioServer{

	private final UsuarioRepository usuarioRepository;

    public UsuarioServer(UsuarioRepository uRepository) {
        this.usuarioRepository = uRepository;
    }

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(ObjectId id) throws ResourceNotFoundException {
		return usuarioRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("model with id " + id + " not found"));
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		this.deleteById(usuario.get_id());
		
	}

	@Override
	public void deleteById(int id) {
		if (!usuarioRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        usuarioRepository.deleteById(id);	
	}

	@Override
	public void deleteById(String id) {
        if (!usuarioRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        usuarioRepository.deleteById(id);	
	}

	@Override
	public void deleteById(ObjectId id) {
		if (!usuarioRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        usuarioRepository.deleteById(id);	
	}

	@Override
	public Long count() {
		return usuarioRepository.count();
	}

	public Usuario findByName(String username) {
		return usuarioRepository.findByName();
	}
    
}