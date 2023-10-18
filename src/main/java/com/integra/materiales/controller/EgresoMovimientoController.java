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

import com.integra.materiales.model.EgresoMovimiento;
import com.integra.materiales.services.EgresoMovimientoService;

@RestController
@RequestMapping("/api/egresomovimiento")
public class EgresoMovimientoController {
    private final EgresoMovimientoService egresoMovimientoService;

    @Autowired
    public EgresoMovimientoController(EgresoMovimientoService egresoMovimientoService) {
        this.egresoMovimientoService = egresoMovimientoService;
    }

    @GetMapping
    public ResponseEntity<List<EgresoMovimiento>> getAllListaCorte(){
        return ResponseEntity.ok(egresoMovimientoService.getALlEgresoMov());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EgresoMovimiento> getEgresoMovimientoById(@PathVariable Long id) {
        return egresoMovimientoService.getEgresoMovimientoById(id)
            .map(entity -> ResponseEntity.ok(entity))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EgresoMovimiento> createEgresoMovimiento(@RequestBody EgresoMovimiento egresoMovimiento) {
        return ResponseEntity.ok(egresoMovimientoService.saveEgresoMovimiento(egresoMovimiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EgresoMovimiento> updateListaCorte(@PathVariable Long id, @RequestBody EgresoMovimiento egresoMovimiento) {
        return ResponseEntity.ok(egresoMovimientoService.saveEgresoMovimiento(egresoMovimiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEgresoMovimiento(@PathVariable Long id) {
        egresoMovimientoService.deleteEgreso(id);
        return ResponseEntity.noContent().build();
    }
    
}
