package ar.com.ada.api.stephix.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.bson.types.ObjectId;

import ar.com.ada.api.stephix.entities.Pelicula;
import ar.com.ada.api.stephix.services.implementations.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> findAll() {
        return peliculaService.findAll();
    }

    @GetMapping("/{id}")
    public Pelicula findById(@PathVariable("id") String id) {
        return peliculaService.findById(new ObjectId(id));
    }

    @PostMapping
    public ResponseEntity<Pelicula> save(@RequestBody  Pelicula pelicula) {
        return new ResponseEntity<>(peliculaService.save(pelicula), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Pelicula update(@PathVariable("id") String id, @RequestBody Pelicula pelicula) {
        pelicula.set_id(new ObjectId(id));

        return peliculaService.save(pelicula);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        peliculaService.deleteById(new ObjectId(id));
        return "OK";
    }
}