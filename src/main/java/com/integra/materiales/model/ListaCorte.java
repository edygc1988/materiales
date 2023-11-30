package com.integra.materiales.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaCorte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long numeroPedido;
    private String cliente;
    private String simbolo;
    private String tipoParte;
    private Date fechaIniProduccion;
    private Long listaCorte;
    private String division;
    private String proceso;
    private Long cantidadProducidaNr;
}