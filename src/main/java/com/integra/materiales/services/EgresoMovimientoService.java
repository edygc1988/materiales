package com.integra.materiales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integra.materiales.model.EgresoMovimiento;
import com.integra.materiales.model.ListaCorte;
import com.integra.materiales.repository.EgresoMovimientoRepository;
import com.integra.materiales.repository.MyRepository;

@Service
public class EgresoMovimientoService {
    private final EgresoMovimientoRepository egresoMovimientoRepository;
    private final MyRepository myRepository;
    @Autowired
    public EgresoMovimientoService(EgresoMovimientoRepository egresoMovimientoRepository, MyRepository myRepository) {
        this.egresoMovimientoRepository = egresoMovimientoRepository;
        this.myRepository = myRepository;
    }
    
    public List<EgresoMovimiento> getALlEgresoMov(){
        return egresoMovimientoRepository.findAll();
    }
    
    public Optional<EgresoMovimiento> getEgresoMovimientoById(Long id){
        return egresoMovimientoRepository.findById(id);
    }

    /*public EgresoMovimiento findEgresoMovimientoForListaCorte(ListaCorte listaCorte) {
        // Utiliza la relación entre ListaCorte y EgresoMovimiento a través de ListaEgreso
        // para encontrar el EgresoMovimiento correspondiente
        return myRepository.findEgresoMovimientoByListaCorte(listaCorte);
    }*/

    public EgresoMovimiento saveEgresoMovimiento(EgresoMovimiento egresoMovimiento){
        return egresoMovimientoRepository.save(egresoMovimiento);
    }

    public void deleteEgreso(Long id){
        egresoMovimientoRepository.deleteById(id);
    }
}
