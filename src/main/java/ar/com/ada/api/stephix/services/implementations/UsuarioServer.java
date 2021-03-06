package ar.com.ada.api.stephix.services.implementations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Usuario;
import ar.com.ada.api.stephix.exceptions.ResourceNotFoundException;
import ar.com.ada.api.stephix.models.LoginResponse;
import ar.com.ada.api.stephix.repos.UsuarioRepository;
import ar.com.ada.api.stephix.security.Crypto;
import ar.com.ada.api.stephix.services.IUsuarioService;
import ar.com.ada.api.stephix.system.comm.EmailService;

@Service
public class UsuarioServer implements IUsuarioService{

	private static final String LOGIARSE = "iniciarSesion";
    
	private static final String LOGIARSE_ERROR = "sesionInvalida";
	
	private final UsuarioRepository usuarioRepository;

	@Autowired
	EmailService emailService;

    public UsuarioServer(UsuarioRepository uRepository) {
        this.usuarioRepository = uRepository;
    }

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(ObjectId id) throws ResourceNotFoundException {
		return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("model with id " + id + " not found"));
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
	public Usuario login(String username, String password) {
		Usuario u = this.findByName(username);
		u.cargarUsuario(username, password);
    	if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUsername()))) {
    		emailService.alertaPorRecibirPor(u,LOGIARSE_ERROR);
			throw new BadCredentialsException("Usuario o contraseña invalida");
    	}
		emailService.alertaPorRecibirPor(u,LOGIARSE);
		return u;
	}

	@Override
	public LoginResponse loginResponse(Usuario u, String token, String username) {
		LoginResponse r = new LoginResponse(); 
    	r.id = u.get_id().toHexString(); 
    	r.username = u.getUsername(); 
    	r.token = token; 
	  	return r;
	}

	public UserDetails getUserAsUserDetail(Usuario usuarioLogueado) {
		return new User(usuarioLogueado.getUsername(),usuarioLogueado.getPassword(),getAuthorities(usuarioLogueado));
	}

	private Set<? extends GrantedAuthority> getAuthorities(Usuario usuarioLogueado) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		ObjectId usuarId = usuarioLogueado.get_id();

		authorities.add(new SimpleGrantedAuthority("CLAIM_USUARIO_ID"+usuarId));

		return authorities;
	}

	public Map<String, Object> getUserClaims(Usuario usuarioLogueado) {
		Map<String, Object> claims = new HashMap<>();

		claims.put("billeteraId", usuarioLogueado.getUsername());

		return claims;
	}
    
}