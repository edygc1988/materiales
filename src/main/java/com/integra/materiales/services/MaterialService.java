package com.integra.materiales.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integra.materiales.model.Material;
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

    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Optional<Material> getMaterialById(Long id) {
        return materialRepository.findById(id);
    }

    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}