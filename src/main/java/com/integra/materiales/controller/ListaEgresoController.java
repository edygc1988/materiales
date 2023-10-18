package com.integra.materiales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integra.materiales.model.ListaEgreso;
import com.integra.materiales.services.ListaEgresoService;

import java.util.List;

@RestController
@RequestMapping("/api/listaegreso")
public class ListaEgresoController {

    // Declare the service as final to ensure its immutability
    private final ListaEgresoService listaegresoService;

    // Use constructor-based dependency injection
    @Autowired
    public ListaEgresoController(ListaEgresoService listaegresoService) {
        this.listaegresoService = listaegresoService;
    }

    @GetMapping
    public ResponseEntity<List<ListaEgreso>> getAlllistaEgresos() {
        return ResponseEntity.ok(listaegresoService.getAllListaEgresos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaEgreso> getlistaEgresoById(@PathVariable Long id) {
        return listaegresoService.getListaEgresoById(id)
            .map(entity -> ResponseEntity.ok(entity))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ListaEgreso> createlistaEgreso(@RequestBody ListaEgreso listaEgreso) {
        return ResponseEntity.ok(listaegresoService.saveListaEgreso(listaEgreso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaEgreso> updatelistaEgreso(@PathVariable Long id, @RequestBody ListaEgreso listaEgreso) {
        return ResponseEntity.ok(listaegresoService.saveListaEgreso(listaEgreso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletelistaEgreso(@PathVariable Long id) {
        listaegresoService.deleteListaEgreso(id);
        return ResponseEntity.noContent().build();
    }
}