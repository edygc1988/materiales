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
public class EgresoMovimiento {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_mov;
    private String nro_fisico;
    private String tipo_documento;
    private Date fecha;
    private Long id_bodega;
    private String bodega;
    private String producto;
    private Long id_lote;
    private String identif_bobina;
    private Long tarjeta;
    private Long peso;
    private Long id_proveedor_fk;
    private String origen;
    private String division;
    /* 
    @ManyToOne
    @JoinColumn(name = "material_id")  // Nombre de la columna de clave foránea en la tabla Caja
    private Material material;*/
}