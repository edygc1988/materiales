package com.integra.materiales.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integra.materiales.model.ListaEgreso;
import com.integra.materiales.repository.ListaEgresoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ListaEgresoService {

    // Declare the repository as final to ensure its immutability
    private final ListaEgresoRepository listaegresoRepository;

    // Use constructor-based dependency injection
    @Autowired
    public ListaEgresoService(ListaEgresoRepository listaegresoRepository) {
        this.listaegresoRepository = listaegresoRepository;
    }

    public List<ListaEgreso> getAllListaEgresos() {
        return listaegresoRepository.findAll();
    }

    public Optional<ListaEgreso> getListaEgresoById(Long id) {
        return listaegresoRepository.findById(id);
    }

    public ListaEgreso saveListaEgreso(ListaEgreso ListaEgreso) {
        return listaegresoRepository.save(ListaEgreso);
    }

    public void deleteListaEgreso(Long id) {
        listaegresoRepository.deleteById(id);
    }
}