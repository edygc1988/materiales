package com.integra.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.materiales.model.EgresoMovimiento;

public interface EgresoMovimientoRepository extends JpaRepository<EgresoMovimiento, Long> {
    
}
