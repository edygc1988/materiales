package com.integra.materiales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.integra.materiales.model.ListaCorte;

import java.util.List;

public interface MyRepository extends JpaRepository<ListaCorte, Long> {

    
    @Query("SELECT lc, em " +
           "FROM ListaEgreso le " +
           "JOIN EgresoMovimiento em ON le.id_mov = em.id_mov and le.identif_bobina = em.identif_bobina " +
           "JOIN ListaCorte lc ON le.lista_corte = lc.lista_corte " +
           "WHERE lc.numero_pedido = :numeroPedido OR le.lista_corte = :numeroPedido")
    List<Object[]> findDatosPorNumeroPedido(
        @Param("numeroPedido") Long numeroPedido);
}