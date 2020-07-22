package ar.com.ada.api.stephix.services;

import org.springframework.stereotype.Service;

import ar.com.ada.api.stephix.entities.Usuario;
import ar.com.ada.api.stephix.services.implementations.UsuarioServer;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.*;

@Service
public class JWTUserDetailsService implements UserDetailsService {
    
    private final UsuarioServer UsuarioServer;

    public JWTUserDetailsService(UsuarioServer as) {
        this.UsuarioServer = as;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = UsuarioServer.findByName(username);

        if (usuario != null) {
            return new User(usuario.getUsername(), usuario.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}