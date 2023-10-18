package com.integra.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.materiales.model.ListaCorte;

public interface ListaCorteRepository extends JpaRepository<ListaCorte, Long> {
    
}
