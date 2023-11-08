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
// The `@Autowired` annotation is used to automatically wire the `ListaEgresoService` bean into the
// `ListaEgresoController` class.
    @Autowired
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
    public ResponseEntity<Map<String, Object>> createlistaEgreso(@RequestBody ListaEgreso listaEgreso) {
        //return ResponseEntity.ok(listaegresoService.saveListaEgreso(listaEgreso));       
        listaegresoService.saveListaEgreso(listaEgreso);
        Map<String, Object> response = new HashMap<>();
        response.put("resultCode", HttpStatus.CREATED);
        response.put("status", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    // The method `updatelistaEgreso` is a PUT request handler that updates an existing `ListaEgreso`
    // object in the database. It takes two parameters: `id` and `listaEgreso`.
    public ResponseEntity<ListaEgreso> updatelistaEgreso(@PathVariable Long id, @RequestBody ListaEgreso listaEgreso) {
        return ResponseEntity.ok(listaegresoService.saveListaEgreso(listaEgreso));
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
        List<DatosPorNumeroPedido> result = listaegresoService.getDatosPorNumeroPedido(numeroPedido);
        return result;
    }
}