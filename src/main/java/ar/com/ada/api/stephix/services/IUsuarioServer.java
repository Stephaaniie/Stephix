package ar.com.ada.api.stephix.services;

import ar.com.ada.api.stephix.entities.Usuario;
import ar.com.ada.api.stephix.models.LoginResponse;

public interface IUsuarioServer extends IEntityCRUDService<Usuario> {

	Usuario login(String username, String password);

	Usuario findByName(String username);

	LoginResponse loginResponse(Usuario u, String token, String username);
    
}