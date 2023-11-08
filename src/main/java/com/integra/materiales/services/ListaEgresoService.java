package com.integra.materiales.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integra.materiales.model.DatosPorNumeroPedido;
import com.integra.materiales.model.EgresoMovimiento;
import com.integra.materiales.model.ListaCorte;
import com.integra.materiales.model.ListaEgreso;
import com.integra.materiales.repository.ListaEgresoRepository;
import com.integra.materiales.repository.MyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListaEgresoService {

    // Declare the repository as final to ensure its immutability
    private final ListaEgresoRepository listaegresoRepository;
    private final MyRepository myRepository;

    // Use constructor-based dependency injection
    @Autowired
    public ListaEgresoService(ListaEgresoRepository listaegresoRepository, MyRepository myRepository) {
        this.listaegresoRepository = listaegresoRepository;
        this.myRepository = myRepository;

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

    public List<DatosPorNumeroPedido> getDatosPorNumeroPedido(Long numeroPedido) {
        List<Object[]> listaCorteResults = myRepository.findDatosPorNumeroPedido(numeroPedido);

        List<DatosPorNumeroPedido> datosList = new ArrayList<>();
        for (Object[] result : listaCorteResults) {
            ListaCorte lc = (ListaCorte) result[0];
            EgresoMovimiento em = (EgresoMovimiento) result[1];
            DatosPorNumeroPedido datos = new DatosPorNumeroPedido(
                em.getId_mov(),
                em.getNro_fisico(),
                em.getTipo_documento(),
                em.getFecha(),
                em.getId_bodega(),
                em.getBodega(),
                em.getProducto(),
                em.getId_lote(),
                em.getIdentif_bobina(),
                em.getTarjeta(),
                em.getPeso(),
                em.getId_proveedor_fk(),
                em.getOrigen(),
                em.getDivision(),
                em.getEs_fsc(),
                em.getPorc_fsc(),
                em.getTipo_fsc(),
                lc.getNumero_pedido(),
                lc.getCliente(),
                lc.getSimbolo(),
                lc.getTipo_parte(),
                lc.getFecha_ini_produccion(),
                lc.getLista_corte(),
                lc.getProceso(),
                lc.getCantidad_producida_nr()
            );
            datosList.add(datos);
        }
        return datosList;
        
    }
}