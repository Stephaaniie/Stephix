package ar.com.ada.api.stephix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.bson.types.ObjectId;

import ar.com.ada.api.stephix.entities.*;
import ar.com.ada.api.stephix.services.implementations.TemporadaService;

@RestController
@RequestMapping("/api/temporadas")
public class TemporadaController {
    
    @Autowired
    TemporadaService temporadaService;

    @GetMapping
    public List<Temporada> findAll() {
        return temporadaService.findAll();
    }

    @GetMapping("/{id}")
    public Temporada findById(@PathVariable("id") String id) {
        return temporadaService.findById(new ObjectId(id));
    }

    @PostMapping
    public ResponseEntity<Temporada> save(@RequestBody  Temporada temporada) {
        return new ResponseEntity<>(temporadaService.save(temporada), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Temporada update(@PathVariable("id") String id, @RequestBody Temporada temporada) {
        temporada.set_id(new ObjectId(id));

        return temporadaService.save(temporada);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        temporadaService.deleteById(new ObjectId(id));
        return "OK";
    }

    @GetMapping("/episodios")
    public List<Episodio> findByEpisodio(@PathVariable("episodios") String episodios) {
		return temporadaService.findByEpisodios();
    }

    //@GetMapping("/id/episodios/id")
    //public Episodio fidbByEpisodio(@PathVariable())

    @PostMapping("/id/episodios")
    public ResponseEntity<Episodio> save(@RequestBody  Episodio episodio, String id) {
        return new ResponseEntity<>(temporadaService.save(episodio,new ObjectId(id)), HttpStatus.CREATED);
    }
}