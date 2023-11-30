package com.integra.materiales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integra.materiales.model.EgresoMovimiento;
import com.integra.materiales.repository.EgresoMovimientoRepository;
import com.integra.materiales.repository.MyRepository;

@Service
public class EgresoMovimientoService {
    // The line `private final EgresoMovimientoRepository egresoMovimientoRepository;` is declaring a
    // private final variable `egresoMovimientoRepository` of type `EgresoMovimientoRepository`. This
    // variable is used to interact with the repository for the `EgresoMovimiento` entity, allowing the
    // service to perform CRUD operations on the `EgresoMovimiento` objects.
    private final EgresoMovimientoRepository egresoMovimientoRepository;
    
// The `@Autowired` annotation is used to automatically wire the dependencies of a Spring bean. In this
// case, it is used to inject the `EgresoMovimientoRepository` and `MyRepository` dependencies into the
// `EgresoMovimientoService` constructor.
    @Autowired
    public EgresoMovimientoService(EgresoMovimientoRepository egresoMovimientoRepository, MyRepository myRepository) {
        this.egresoMovimientoRepository = egresoMovimientoRepository;
    }
    

    /**
     * The function returns a list of all EgresoMovimiento objects.
     * 
     * @return A List of EgresoMovimiento objects is being returned.
     */
    public List<EgresoMovimiento> getAllEgresoMov(){
        return egresoMovimientoRepository.findAll();
    }
    
    /**
     * The function returns an Optional object containing an EgresoMovimiento object based on the
     * provided id.
     * 
     * @param id The id parameter is of type Long and represents the unique identifier of the
     * EgresoMovimiento object that you want to retrieve from the repository.
     * @return The method is returning an Optional object of type EgresoMovimiento.
     */
    public Optional<EgresoMovimiento> getEgresoMovimientoById(Long id){
        return egresoMovimientoRepository.findById(id);
    }

    public List<EgresoMovimiento> getEgresoMovimientoByNroFisico(Long nroFisico){
        return egresoMovimientoRepository.findByNroFisico(nroFisico);
    }

    /*public EgresoMovimiento findEgresoMovimientoForListaCorte(ListaCorte listaCorte) {
        // Utiliza la relación entre ListaCorte y EgresoMovimiento a través de ListaEgreso
        // para encontrar el EgresoMovimiento correspondiente
        return myRepository.findEgresoMovimientoByListaCorte(listaCorte);
    }*/

    /**
     * The function saves an EgresoMovimiento object in the repository and returns the saved object.
     * 
     * @param egresoMovimiento The parameter "egresoMovimiento" is an object of type EgresoMovimiento,
     * which represents a movement of an expense.
     * @return The method is returning an object of type EgresoMovimiento.
     */
    public EgresoMovimiento saveEgresoMovimiento(EgresoMovimiento egresoMovimiento){
        return egresoMovimientoRepository.save(egresoMovimiento);
    }

    /**
     * The function deletes an egreso (expense) by its ID.
     * 
     * @param id The parameter "id" is of type Long and represents the unique identifier of the egreso
     * (expense) that needs to be deleted.
     */
    public void deleteEgreso(Long id){
        egresoMovimientoRepository.deleteById(id);
    }
}
