package com.integra.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.integra.materiales.model.ListaCorte;

import java.util.List;

// The line `public interface MyRepository extends JpaRepository<ListaCorte, Long>` is declaring an
// interface named `MyRepository` that extends the `JpaRepository` interface.
public interface MyRepository extends JpaRepository<ListaCorte, Long> {

    
/**
 * This function retrieves data from multiple tables based on a given number and returns a list of
 * objects.
 * 
 * @param numeroPedido The parameter "numeroPedido" is a Long type, which represents the number of a
 * pedido (order).
 * @return The method is returning a List of Object arrays. Each array contains two elements: the first
 * element is of type ListaCorte and the second element is of type EgresoMovimiento.
 */
    /*@Query("SELECT lc, em " +
           "FROM ListaEgreso le " +
           "JOIN EgresoMovimiento em " + //ON le.idMov = em.idMov and le.identifBobina = em.identifBobina " +
           "JOIN ListaCorte lc ON le.listaCorte = lc.listaCorte " +
           "WHERE lc.numeroPedido = :numeroPedido OR le.listaCorte = :numeroPedido")
    List<Object[]> findDatosPorNumeroPedido(
        @Param("numeroPedido") Long numeroPedido);*/
        @Query("SELECT lc, em " +
       "FROM ListaCorte lc " +
       "JOIN ListaEgreso le ON lc.listaCorte = le.listaCorte " +
       "JOIN le.egresoMovimiento em " +
       "WHERE lc.numeroPedido = :numeroPedido OR le.listaCorte = :numeroPedido")
       List<Object[]> findDatosPorNumeroPedido(@Param("numeroPedido") Long numeroPedido);

}