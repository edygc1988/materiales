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
public class ListasCorte {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numero_pedido;
    private String cliente;
    private String simbolo;
    private String tipo_parte;
    private Date fecha_ini_produccion;
    private Long lista_corte;
    private String division;
    private String proceso;
    private Long cantidad_producida_nr;
    /*
    @ManyToOne
    @JoinColumn(name = "material_id")  // Nombre de la columna de clave foránea en la tabla Caja
    private Material material;*/
}