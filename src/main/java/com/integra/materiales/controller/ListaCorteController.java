package com.integra.materiales.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.integra.materiales.model.ListaCorte;
import com.integra.materiales.services.ListaCorteService;

@RestController
@RequestMapping("/api/listacorte")
public class ListaCorteController {
    private final ListaCorteService listaCorteService;

// The `@Autowired` annotation is used to automatically wire the `ListaCorteService` bean into the
// `ListaCorteController` class.
    @Autowired
    public ListaCorteController(ListaCorteService listaCorteService) {
        this.listaCorteService = listaCorteService;
    }

/**
 * The above function is a GET request that returns a ResponseEntity containing a list of ListaCorte
 * objects.
 * 
 * @return A ResponseEntity object is being returned.
 */
    @GetMapping
    public ResponseEntity<List<ListaCorte>> getAllListaCorte(){
        return ResponseEntity.ok(listaCorteService.getAllListaCorte());
    }

    @GetMapping("/{id}")
    // The `getMaterialById` method is a GET request that retrieves a `ListaCorte` object by its `id`.
    public ResponseEntity<ListaCorte> getMaterialById(@PathVariable Long id) {
        return listaCorteService.getListacorteById(id)
            .map(entity -> ResponseEntity.ok(entity))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    // The `createListaCorte` method is a POST request that creates a new `ListaCorte` object. It takes
    // in a `ListaCorte` object as a request body and returns a `ResponseEntity` containing a `Map`
    // object with information about the result of the operation. The `Map` object includes a
    // `resultCode` and a `status` field, which indicate the success or failure of the operation. The
    // HTTP status code returned is `HttpStatus.OK` (200) if the operation is successful.
    public ResponseEntity<Map<String, Object>> createListaCorte(@RequestBody ListaCorte listaCorte) {
        //return ResponseEntity.ok(listaCorteService.saveListaCorte(listaCorte));
        listaCorteService.saveListaCorte(listaCorte);
        Map<String, Object> response = new HashMap<>();
        response.put("resultCode", HttpStatus.CREATED);
        response.put("status", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    // The `updateListaCorte` method is a PUT request that updates an existing `ListaCorte` object. It
    // takes in two parameters: `id`, which is the identifier of the `ListaCorte` object to be updated,
    // and `listaCorte`, which is the updated `ListaCorte` object received as a request body.
    public ResponseEntity<ListaCorte> updateListaCorte(@PathVariable Long id, @RequestBody ListaCorte listaCorte) {
        return ResponseEntity.ok(listaCorteService.saveListaCorte(listaCorte));
    }

    @DeleteMapping("/{id}")
    // The `deleteMaterial` method is a DELETE request that deletes a `ListaCorte` object by its `id`.
    // It takes in the `id` as a path variable and returns a `ResponseEntity` with a `Void` response
    // body. The HTTP status code returned is `HttpStatus.NO_CONTENT` (204) if the operation is
    // successful.
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        listaCorteService.deleteListaCorte(id);
        return ResponseEntity.noContent().build();
    }
    
}
