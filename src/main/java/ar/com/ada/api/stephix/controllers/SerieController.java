package ar.com.ada.api.stephix.controllers;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;

import ar.com.ada.api.stephix.entities.*;
import ar.com.ada.api.stephix.services.implementations.SerieService;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    @Autowired
    SerieService serieService;

    @GetMapping
    public List<Serie> findAll() {
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
}
