package com.integra.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.materiales.model.ListaEgreso;

public interface ListaEgresoRepository extends JpaRepository<ListaEgreso, Long> {
}