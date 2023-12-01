package com.integra.materiales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.integra.materiales.model.ListaCorte;
import com.integra.materiales.repository.ListaCorteRepository;

@Service
public class ListaCorteService {
    // The line `private final ListaCorteRepository listaCorteRepository;` is declaring a private final
    // variable `listaCorteRepository` of type `ListaCorteRepository`. This variable is used to
    // interact with the database and perform CRUD operations on the `ListaCorte` entity. It is being
    // autowired in the constructor of the `ListaCorteService` class, which means that an instance of
    // `ListaCorteRepository` will be injected into the `listaCorteRepository` variable when an
    // instance of `ListaCorteService` is created.
    private final ListaCorteRepository listaCorteRepository;

// The `@Autowired` annotation is used to automatically wire (inject) the dependency of
// `ListaCorteRepository` into the `listaCorteRepository` variable in the `ListaCorteService` class.
    public ListaCorteService(ListaCorteRepository listaCorteRepository) {
        this.listaCorteRepository = listaCorteRepository;
    }

    /**
     * The function getAllListaCorte returns a list of all ListaCorte objects.
     * 
     * @return A List of ListaCorte objects is being returned.
     */
    public List<ListaCorte> getAllListaCorte(){
        return listaCorteRepository.findAll();
    }

    /**
     * The function returns an Optional object containing a ListaCorte object based on the provided id.
     * 
     * @param id The id parameter is of type Long and represents the unique identifier of the
     * ListaCorte object that you want to retrieve from the database.
     * @return The method is returning an Optional object that contains a List of ListaCorte objects.
     */
    public Optional<ListaCorte> getListacorteById(Long id){
        return listaCorteRepository.findById(id);
    }
    
    /**
     * The function saves a ListaCorte object in the repository.
     * 
     * @param listaCorte The parameter "listaCorte" is an object of type "ListaCorte" that represents a
     * list of cuts.
     * @return The method is returning a saved instance of the "ListaCorte" object.
     */
    public ListaCorte saveListaCorte(ListaCorte listaCorte){
        return listaCorteRepository.save(listaCorte);
    }

    /**
     * The function deletes a record from the "listaCorte" table based on the provided ID.
     * 
     * @param id The parameter "id" is of type Long and represents the unique identifier of the object
     * to be deleted from the "listaCorte" repository.
     */
    public void deleteListaCorte(Long id){
        listaCorteRepository.deleteById(id);
    }

    public boolean existeListaCorte(ListaCorte listaCorte) {
        Long numeroPedido = listaCorte.getNumeroPedido();
        Long listaCorteId = listaCorte.getListaCorte();
        Long cantidadProducidaNr = listaCorte.getCantidadProducidaNr();

        return listaCorteRepository.existsByNumeroPedidoAndListaCorteAndCantidadProducidaNr(
                numeroPedido, listaCorteId, cantidadProducidaNr);
    }
}
