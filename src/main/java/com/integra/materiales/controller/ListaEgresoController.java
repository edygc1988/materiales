package com.integra.materiales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integra.materiales.model.DatosPorNumeroPedido;
import com.integra.materiales.model.ListaEgreso;
import com.integra.materiales.services.ListaEgresoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> createlistaEgreso(@RequestBody ListaEgreso listaEgreso) {
        //return ResponseEntity.ok(listaegresoService.saveListaEgreso(listaEgreso));       
        listaegresoService.saveListaEgreso(listaEgreso);
        Map<String, Object> response = new HashMap<>();
        response.put("resultCode", HttpStatus.CREATED);
        response.put("status", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
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

    @GetMapping("/datosPorNumeroPedido")
    public List<DatosPorNumeroPedido> getDatosPorNumeroPedido(@RequestParam("numeroPedido") Long numeroPedido) {
        List<DatosPorNumeroPedido> result = listaegresoService.getDatosPorNumeroPedido(numeroPedido);
        return result;
    }
}