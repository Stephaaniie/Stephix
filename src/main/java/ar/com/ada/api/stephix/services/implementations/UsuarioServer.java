package ar.com.ada.api.stephix.services.implementations;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Usuario;
import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;
import ar.com.ada.api.stephix.models.LoginResponse;
import ar.com.ada.api.stephix.repos.UsuarioRepository;
import ar.com.ada.api.stephix.security.Crypto;
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
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public void login(String username, String password) {
		Usuario u = this.findByName(username);
		u.cargarUsuario(username, password);
    	if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUsername()))) {
    		//emailService.alertaPorRecibirPor(u,LOGIARSE_ERROR);
			throw new BadCredentialsException("Usuario o contraseña invalida");
    	}
    	//emailService.alertaPorRecibirPor(u,LOGIARSE);
	}

	@Override
	public LoginResponse loginResponse(Usuario u, String token, String username) {
		LoginResponse r = new LoginResponse(); 
    	r.id = u.get_id().toHexString(); 
    	r.username = u.getUsername(); 
    	r.token = token; 
	  	return r;
	}
    
}