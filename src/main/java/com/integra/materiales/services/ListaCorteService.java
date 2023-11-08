package com.integra.materiales.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integra.materiales.model.ListaCorte;
import com.integra.materiales.repository.ListaCorteRepository;

@Service
public class ListaCorteService {
    private final ListaCorteRepository listaCorteRepository;

    @Autowired
    public ListaCorteService(ListaCorteRepository listaCorteRepository) {
        this.listaCorteRepository = listaCorteRepository;
    }

    public List<ListaCorte> getAllListaCorte(){
        return listaCorteRepository.findAll();
    }

    public Optional<ListaCorte> getListacorteById(Long id){
        return listaCorteRepository.findById(id);
    }
    
    public Optional<ListaCorte> getListacorteByDate(Date id){
        return listaCorteRepository.findBy(null, null);
    }

    public ListaCorte saveListaCorte(ListaCorte listaCorte){
        return listaCorteRepository.save(listaCorte);
    }

    public void deleteListaCorte(Long id){
        listaCorteRepository.deleteById(id);
    }
}
