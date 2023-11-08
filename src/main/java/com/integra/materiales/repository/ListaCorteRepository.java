package com.integra.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.materiales.model.ListaCorte;

// The line `public interface ListaCorteRepository extends JpaRepository<ListaCorte, Long> {` is
// declaring an interface named `ListaCorteRepository` that extends the `JpaRepository` interface.
public interface ListaCorteRepository extends JpaRepository<ListaCorte, Long> {
    
}
