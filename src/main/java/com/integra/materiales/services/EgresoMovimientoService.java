package com.integra.materiales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integra.materiales.model.EgresoMovimiento;
import com.integra.materiales.repository.EgresoMovimientoRepository;

@Service
public class EgresoMovimientoService {
    private final EgresoMovimientoRepository egresoMovimientoRepository;

    @Autowired
    public EgresoMovimientoService(EgresoMovimientoRepository egresoMovimientoRepository) {
        this.egresoMovimientoRepository = egresoMovimientoRepository;
    }
    
    public List<EgresoMovimiento> getALlEgresoMov(){
        return egresoMovimientoRepository.findAll();
    }
    
    public Optional<EgresoMovimiento> getEgresoMovimientoById(Long id){
        return egresoMovimientoRepository.findById(id);
    }

    public EgresoMovimiento saveEgresoMovimiento(EgresoMovimiento egresoMovimiento){
        return egresoMovimientoRepository.save(egresoMovimiento);
    }

    public void deleteEgreso(Long id){
        egresoMovimientoRepository.deleteById(id);
    }
}
