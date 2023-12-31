package com.integra.materiales.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.integra.materiales.model.DatosPorNumeroPedido;
import com.integra.materiales.model.EgresoMovimiento;
import com.integra.materiales.model.ListaCorte;
import com.integra.materiales.model.ListaEgreso;
import com.integra.materiales.repository.EgresoMovimientoRepository;
import com.integra.materiales.repository.ListaEgresoRepository;
import com.integra.materiales.repository.MyRepository;

@Service
public class ListaEgresoService {

    // Declare the repository as final to ensure its immutability
    // The line `private final ListaEgresoRepository listaegresoRepository;` is declaring a private
    // final variable `listaegresoRepository` of type `ListaEgresoRepository`. This variable is used to
    // interact with the repository for the `ListaEgreso` entity. It is typically used to perform CRUD
    // (Create, Read, Update, Delete) operations on the `ListaEgreso` objects in the database.
    private final ListaEgresoRepository listaegresoRepository;

    // The line `private final MyRepository myRepository;` is declaring a private final variable
    // `myRepository` of type `MyRepository`. This variable is used to interact with the repository for
    // a custom query defined in the `MyRepository` interface. It is typically used to perform custom
    // database operations that are not provided by the default methods in the `ListaEgresoRepository`.
    private final MyRepository myRepository;
    private final EgresoMovimientoRepository egresoMovimientoRepository;

    // Use constructor-based dependency injection
// The `@Autowired` annotation is used to automatically wire (inject) the dependencies of a Spring
// bean. In this case, the `ListaEgresoService` class has two dependencies: `ListaEgresoRepository` and
// `MyRepository`.
    public ListaEgresoService(ListaEgresoRepository listaegresoRepository, MyRepository myRepository, EgresoMovimientoRepository egresoMovimientoRepository) {
        this.listaegresoRepository = listaegresoRepository;
        this.myRepository = myRepository;
        this.egresoMovimientoRepository = egresoMovimientoRepository;
    }

    /**
     * The function getAllListaEgresos returns a list of all ListaEgreso objects.
     * 
     * @return The method is returning a List of objects of type ListaEgreso.
     */
    public List<ListaEgreso> getAllListaEgresos() {
        return listaegresoRepository.findAll();
    }

    /**
     * The function returns an Optional object containing a ListaEgreso object found by its id.
     * 
     * @param id The parameter "id" is of type Long and represents the unique identifier of a
     * ListaEgreso object.
     * @return The method is returning an Optional object that contains a List of ListaEgreso objects.
     */
    public Optional<ListaEgreso> getListaEgresoById(Long id) {
        return listaegresoRepository.findById(id);
    }

    /**
     * The function saves a ListaEgreso object to the repository.
     * 
     * @param ListaEgreso The parameter "ListaEgreso" is an object of type "ListaEgreso".
     * @return The method is returning a saved instance of the ListaEgreso object.
     */
    public ListaEgreso saveListaEgreso(ListaEgreso listaEgreso) {
        EgresoMovimiento egresoMovimiento = egresoMovimientoRepository.findByIdMovAndIdLote(listaEgreso.getEgresoMovimiento().getIdMov(), listaEgreso.getEgresoMovimiento().getIdLote());
        listaEgreso.setEgresoMovimiento(egresoMovimiento);
        return listaegresoRepository.save(listaEgreso);
    }

    /**
     * The function deletes a record from the "listaegreso" table based on the provided ID.
     * 
     * @param id The parameter "id" is of type Long and represents the unique identifier of the object
     * to be deleted from the "listaegreso" repository.
     */
    public void deleteListaEgreso(Long id) {
        listaegresoRepository.deleteById(id);
    }

    /**
     * The function retrieves a list of data objects based on a given order number.
     * 
     * @param numeroPedido The parameter "numeroPedido" is of type Long and represents the number of
     * the pedido (order).
     * @return The method is returning a List of objects of type DatosPorNumeroPedido.
     */
    public List<DatosPorNumeroPedido> getDatosPorNumeroPedido(Long numeroPedido) {
        List<Object[]> listaCorteResults = myRepository.findDatosPorNumeroPedido(numeroPedido);

        List<DatosPorNumeroPedido> datosList = new ArrayList<>();
        for (Object[] result : listaCorteResults) {
            ListaCorte lc = (ListaCorte) result[0];
            EgresoMovimiento em = (EgresoMovimiento) result[1];
            DatosPorNumeroPedido datos = new DatosPorNumeroPedido(
                em.getIdMov(),
                em.getNroFisico(),
                em.getTipoDocumento(),
                em.getFecha(),
                em.getIdBodega(),
                em.getBodega(),
                em.getProducto(),
                em.getIdLote(),
                em.getIdentifBobina(),
                em.getTarjeta(),
                em.getPeso(),
                em.getIdProveedorFk(),
                em.getOrigen(),
                em.getDivision(),
                em.getEsFsc(),
                em.getPorcFsc(),
                em.getTipoFsc(),
                lc.getNumeroPedido(),
                lc.getCliente(),
                lc.getSimbolo(),
                lc.getTipoParte(),
                lc.getFechaIniProduccion(),
                lc.getListaCorte(),
                lc.getProceso(),
                lc.getCantidadProducidaNr()
            );
            datosList.add(datos);
        }
        return datosList;
        
    }
}