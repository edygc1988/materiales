package com.integra.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.materiales.model.EgresoMovimiento;

// This line of code is defining an interface called `EgresoMovimientoRepository` that extends the
// `JpaRepository` interface.
public interface EgresoMovimientoRepository extends JpaRepository<EgresoMovimiento, Long> {
    
}
