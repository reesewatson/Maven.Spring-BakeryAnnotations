package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BakerController {

    @Autowired
    private BakerService service;

    public BakerController(BakerService service) {
        this.service = service;
    }

    @RequestMapping(path="/index", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @RequestMapping(path="/show", method = RequestMethod.POST)
    public ResponseEntity<Baker> show(@RequestBody Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @RequestMapping(path="/create", method = RequestMethod.POST)
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    @RequestMapping(path="/update", method = RequestMethod.POST)
    public ResponseEntity<Baker> update(@RequestBody Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @RequestMapping(path="/destroy", method = RequestMethod.POST)
    public ResponseEntity<Boolean> destroy(@RequestBody Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
