package com.integra.materiales.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integra.materiales.model.ListaEgreso;
import com.integra.materiales.repository.MaterialRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    // Declare the repository as final to ensure its immutability
    private final MaterialRepository materialRepository;

    // Use constructor-based dependency injection
    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<ListaEgreso> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Optional<ListaEgreso> getMaterialById(Long id) {
        return materialRepository.findById(id);
    }

    public ListaEgreso saveMaterial(ListaEgreso material) {
        return materialRepository.save(material);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}