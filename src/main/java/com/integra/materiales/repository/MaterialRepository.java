package com.integra.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.materiales.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}