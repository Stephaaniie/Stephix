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

import ar.com.ada.api.stephix.entities.Episodio;
import ar.com.ada.api.stephix.entities.Serie;
import ar.com.ada.api.stephix.entities.Temporada;
import ar.com.ada.api.stephix.services.implementations.SerieService;
import ar.com.ada.api.stephix.services.implementations.TemporadaService;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    @Autowired
    SerieService serieService;

    @Autowired
    TemporadaService temporadaService;

    @GetMapping
    public List<Serie>findAll() {
        return serieService.findAll();
    }

    @GetMapping("/{id}")
    public Serie findById(@PathVariable("id") String id) {
        return serieService.findById(new ObjectId(id));
    }

    @PostMapping
    public ResponseEntity<Serie> save(@RequestBody  Serie serie) {
        return new ResponseEntity<>(serieService.save(serie), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Serie update(@PathVariable("id") String id, @RequestBody Serie serie) {
        serie.set_id(new ObjectId(id));

        return serieService.save(serie);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        serieService.deleteById(new ObjectId(id));
        return "OK";
    }

    @GetMapping("/temporadas")
    public List<Temporada>findAllTemporada() {
        return temporadaService.findAll();
    }

    @GetMapping("{id}/temporadas/{id1}")
    public Temporada findById(@PathVariable("id") String id, int id1) {
        return temporadaService.findById(temporadaService.findById(new ObjectId(id)).get_id());
    }

    @PostMapping("{id}/temporadas")
    public ResponseEntity<Temporada> save(@PathVariable("id") String id,@RequestBody  Temporada temporada) {
        serieService.addTemporadaASerie(this.findById(id), temporada);
        return new ResponseEntity<>(temporadaService.save(temporada), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/temporadas/{id2}")
    public Temporada update(@PathVariable("id") String id, @RequestBody Temporada temporada,int id2) {
        temporada.set_id(temporadaService.findById(new ObjectId(id)).get_id());
        return temporadaService.save(temporada);
    }

    @DeleteMapping("{id}/temporadas/{id2}")
    public String delete(@PathVariable("id") String id, int id2) {
        temporadaService.deleteById(temporadaService.findById(new ObjectId(id)).get_id());
        return "OK";
    }

    @GetMapping("/{id}/temporadas/episodios")
    public List<Episodio> findByEpisodio(@PathVariable("id") String id) {
		return temporadaService.findByEpisodios(this.findById(id));
    }
    
    @GetMapping("{id0}/temporadas/{id}/episodios/{id1}")
    public Episodio fidbByEpisodio(@PathVariable("id0") String id0,String id, String id1){
		return temporadaService.findByEpisodio(temporadaService.findById(new ObjectId(id)),id1);
    }

    @PostMapping("temporadas/{id}/episodios")
    public ResponseEntity<Episodio> save(@PathVariable("id") String id, @RequestBody  Episodio episodio) {
        return new ResponseEntity<>(temporadaService.save(episodio,new ObjectId(id)), HttpStatus.CREATED);
    }

}
