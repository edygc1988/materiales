package com.integra.materiales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ListaCorteController(ListaCorteService listaCorteService) {
        this.listaCorteService = listaCorteService;
    }

    @GetMapping
    public ResponseEntity<List<ListaCorte>> getAllListaCorte(){
        return ResponseEntity.ok(listaCorteService.getAllListaCorte());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaCorte> getMaterialById(@PathVariable Long id) {
        return listaCorteService.getListacorteById(id)
            .map(entity -> ResponseEntity.ok(entity))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ListaCorte> createListaCorte(@RequestBody ListaCorte listaCorte) {
        return ResponseEntity.ok(listaCorteService.saveListaCorte(listaCorte));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaCorte> updateListaCorte(@PathVariable Long id, @RequestBody ListaCorte listaCorte) {
        return ResponseEntity.ok(listaCorteService.saveListaCorte(listaCorte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        listaCorteService.deleteListaCorte(id);
        return ResponseEntity.noContent().build();
    }
    
}