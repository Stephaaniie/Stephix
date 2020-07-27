package ar.com.ada.api.stephix.controllers;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.stephix.entities.Usuario;
import ar.com.ada.api.stephix.models.*;
import ar.com.ada.api.stephix.models.request.LoginRequest;
import ar.com.ada.api.stephix.security.jwt.JWTTokenUtil;
import ar.com.ada.api.stephix.services.*;
import ar.com.ada.api.stephix.services.implementations.CuentaUserService;
import ar.com.ada.api.stephix.services.implementations.UsuarioServer;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/auth")
public class UsuarioController {

    @Autowired
    UsuarioServer usuarioService;

    @Autowired
    CuentaUserService cuentaService;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private JWTUserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> postRegisterUser(@RequestBody Usuario usuario) {
        usuario.cargarUsuario(usuario.getUsername(), usuario.getPassword());
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    @PostMapping("/login") 
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {
        Usuario usuarioLogueado = usuarioService.login(authenticationRequest.username, authenticationRequest.password);

        UserDetails userDetails = usuarioService.getUserAsUserDetail(usuarioLogueado);
        
        Map<String,Object> claims = usuarioService.getUserClaims(usuarioLogueado);

        String token = jwtTokenUtil.generateToken(userDetails, claims);

        Usuario u = usuarioService.findByName(authenticationRequest.username); 
               
        return ResponseEntity.ok(usuarioService.loginResponse(u,token,authenticationRequest.username)); 
    }

    @DeleteMapping("/deleter/{id}")
    public String delete(@PathVariable("id") String id) {
        cuentaService.deleteById(new ObjectId(id));
        return "OK";
    }
}