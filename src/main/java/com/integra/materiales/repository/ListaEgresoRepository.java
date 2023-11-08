package com.integra.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.materiales.model.ListaEgreso;

// The code is defining an interface called `ListaEgresoRepository` that extends the `JpaRepository`
// interface.
public interface ListaEgresoRepository extends JpaRepository<ListaEgreso, Long> {
}