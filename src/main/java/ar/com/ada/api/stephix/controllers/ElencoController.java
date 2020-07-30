package ar.com.ada.api.stephix.controllers;

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

import java.util.List;

import org.bson.types.ObjectId;

import ar.com.ada.api.stephix.entities.Actor;
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