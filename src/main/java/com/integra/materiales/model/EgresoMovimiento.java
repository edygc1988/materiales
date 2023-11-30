package com.integra.materiales.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EgresoMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Esta columna será autoincremental
    private Long idMov;
    private Long nroFisico;
    private String tipoDocumento;
    private Date fecha;
    private Long turno;
    private Long idBodega;
    private String bodega;
    private String producto;
    private Long idLote;
    private String identifBobina;
    private Long tarjeta;
    private Long peso;
    private Long idProveedorFk;
    private String origen;
    private String division;
    private Long esFsc;
    private Long porcFsc;
    private String tipoFsc;

    
    @OneToMany(mappedBy = "egresoMovimiento", cascade = CascadeType.ALL)
    private List<ListaEgreso> listaEgresos;
}