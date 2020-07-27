package ar.com.ada.api.stephix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.stephix.entities.Usuario;
import ar.com.ada.api.stephix.models.*;
import ar.com.ada.api.stephix.models.request.LoginRequest;
import ar.com.ada.api.stephix.security.jwt.JWTTokenUtil;
import ar.com.ada.api.stephix.services.*;
import ar.com.ada.api.stephix.services.implementations.UsuarioServer;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/auth")
public class UsuarioController {

    @Autowired
    UsuarioServer iUsuarioServer;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private JWTUserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> postRegisterUser(@RequestBody Usuario usuario) {
        usuario.cargarUsuario(usuario.getUsername(), usuario.getPassword());
        return new ResponseEntity<>(iUsuarioServer.save(usuario), HttpStatus.CREATED);
    }

    @PostMapping("/login") 
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {
        iUsuarioServer.login(authenticationRequest.username, authenticationRequest.password);

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.username);

        String token = jwtTokenUtil.generateToken(userDetails);

        Usuario u = iUsuarioServer.findByName(authenticationRequest.username); 
        
        LoginResponse r = iUsuarioServer.loginResponse(u,token,authenticationRequest.username);
       
        return ResponseEntity.ok(r); 
    }
}