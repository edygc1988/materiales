package com.integra.materiales.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaEgreso {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_mov")  // Nombre de la columna de clave foránea en la tabla EgresoMovimiento
    private EgresoMovimiento egresomovimiento;

    @OneToOne
    @JoinColumn(name = "numero_pedido")  // Nombre de la columna de clave foránea en la tabla ListasCorte
    private ListasCorte listascorte;

}