package ar.com.ada.api.stephix.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;

import ar.com.ada.api.stephix.entities.*;
import ar.com.ada.api.stephix.services.implementations.ElencoService;

@RestController
@RequestMapping("/api/actores")
public class ElencoController {

    @Autowired
    ElencoService elencoService;

    @GetMapping
    public List<Actor> findAll() {
        return elencoService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable("id") String id) {
        return elencoService.findById(new ObjectId(id));
    }

    @PostMapping
    public ResponseEntity<Actor> save(@RequestBody  Actor actor) {
        return new ResponseEntity<>(elencoService.save(actor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable("id") String id, @RequestBody Actor actor) {
        actor.set_id(new ObjectId(id));

        return elencoService.save(actor);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        elencoService.deleteById(new ObjectId(id));
        return "OK";
    }
}