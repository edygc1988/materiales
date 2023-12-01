package com.integra.materiales.controller;

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
@RequestMapping("/api/v1/listaegreso")
public class ListaEgresoController {

    // Declare the service as final to ensure its immutability
    private final ListaEgresoService listaegresoService;

    // Use constructor-based dependency injection
// The `@Autowired` annotation is used to automatically wire the `ListaEgresoService` bean into the
// `ListaEgresoController` class.
    public ListaEgresoController(ListaEgresoService listaegresoService) {
        this.listaegresoService = listaegresoService;
    }

    @GetMapping
    // The method `getAlllistaEgresos()` is a GET request handler that retrieves all the `ListaEgreso`
    // objects from the database. It returns a `ResponseEntity` object with a list of `ListaEgreso`
    // objects in the response body and an HTTP status code of 200 (OK).
    public ResponseEntity<List<ListaEgreso>> getAlllistaEgresos() {
        return ResponseEntity.ok(listaegresoService.getAllListaEgresos());
    }

    @GetMapping("/{id}")
    // The method `getlistaEgresoById` is a GET request handler that retrieves a `ListaEgreso` object
    // from the database based on the provided `id`.
    public ResponseEntity<ListaEgreso> getlistaEgresoById(@PathVariable Long id) {
        return listaegresoService.getListaEgresoById(id)
            .map(entity -> ResponseEntity.ok(entity))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    // The method `createlistaEgreso` is a POST request handler that creates a new `ListaEgreso` object
    // in the database. It takes a `ListaEgreso` object as a request body and saves it using the
    // `listaegresoService.saveListaEgreso()` method.
    public ResponseEntity<Map<String, Object>> createlistaEgreso(@RequestBody Map<String, Object> request) {
        // Obtener los valores del mapa
        Long listaCorte = ((Number) request.get("listaCorte")).longValue();
        String identifBobina = (String) request.get("identifBobina");
        Map<String, Object> egresoMovimientoMap = (Map<String, Object>) request.get("egresoMovimiento");

        // Crear una instancia de ListaEgreso utilizando la deserialización personalizada
        ListaEgreso listaEgreso = new ListaEgreso((long) 0, listaCorte, identifBobina, egresoMovimientoMap);

        listaegresoService.saveListaEgreso(listaEgreso);
        Map<String, Object> response = new HashMap<>();
        response.put("resultCode", HttpStatus.CREATED);
        response.put("status", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    // The method `updatelistaEgreso` is a PUT request handler that updates an existing `ListaEgreso`
    // object in the database. It takes two parameters: `id` and `listaEgreso`.
    public ResponseEntity<Map<String, Object>> updatelistaEgreso(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        // Obtener los valores del mapa
        Long listaCorte = ((Number) request.get("listaCorte")).longValue();
        String identifBobina = (String) request.get("identifBobina");
        Map<String, Object> egresoMovimientoMap = (Map<String, Object>) request.get("egresoMovimiento");

        // Crear una instancia de ListaEgreso utilizando la deserialización personalizada
        ListaEgreso listaEgreso = new ListaEgreso(id, listaCorte, identifBobina, egresoMovimientoMap);

        listaegresoService.saveListaEgreso(listaEgreso);
        Map<String, Object> response = new HashMap<>();
        response.put("resultCode", HttpStatus.CREATED);
        response.put("status", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    // The method `deletelistaEgreso` is a DELETE request handler that deletes a `ListaEgreso` object
    // from the database based on the provided `id`. It takes the `id` as a path variable and calls the
    // `listaegresoService.deleteListaEgreso(id)` method to delete the object. It returns a
    // `ResponseEntity` object with an HTTP status code of 204 (No Content) to indicate that the
    // deletion was successful.
    public ResponseEntity<Void> deletelistaEgreso(@PathVariable Long id) {
        listaegresoService.deleteListaEgreso(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/datosPorNumeroPedido")
    // The method `getDatosPorNumeroPedido` is a GET request handler that retrieves a list of
    // `DatosPorNumeroPedido` objects from the database based on the provided `numeroPedido` parameter.
    public List<DatosPorNumeroPedido> getDatosPorNumeroPedido(@RequestParam("numeroPedido") Long numeroPedido) {
        return listaegresoService.getDatosPorNumeroPedido(numeroPedido);
    }
}