package com.integra.materiales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integra.materiales.model.ListaEgreso;
import com.integra.materiales.services.MaterialService;

import java.util.List;

@RestController
@RequestMapping("/api/material")
public class MaterialController {

    // Declare the service as final to ensure its immutability
    private final MaterialService materialService;

    // Use constructor-based dependency injection
    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<List<ListaEgreso>> getAllMaterials() {
        return ResponseEntity.ok(materialService.getAllMaterials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaEgreso> getMaterialById(@PathVariable Long id) {
        return materialService.getMaterialById(id)
            .map(entity -> ResponseEntity.ok(entity))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ListaEgreso> createMaterial(@RequestBody ListaEgreso material) {
        return ResponseEntity.ok(materialService.saveMaterial(material));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaEgreso> updateMaterial(@PathVariable Long id, @RequestBody ListaEgreso material) {
        return ResponseEntity.ok(materialService.saveMaterial(material));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}