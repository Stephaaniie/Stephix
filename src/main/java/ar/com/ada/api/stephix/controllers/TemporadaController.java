package ar.com.ada.api.stephix.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.bson.types.ObjectId;

import ar.com.ada.api.stephix.entities.*;
import ar.com.ada.api.stephix.services.*;

@RestController
@RequestMapping("/api/temporadas")
public class TemporadaController {

    private final ITemporadaService temporadaService;

    public TemporadaController(ITemporadaService as) {
        this.temporadaService = as;
    }

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
        temporadaService.deleteById(id);
        return "OK";
    }
}