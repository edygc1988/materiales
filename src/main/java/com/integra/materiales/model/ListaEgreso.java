package com.integra.materiales.model;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaEgreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Agregar una clave primaria, puede ser cualquier campo adecuado.
    
    private Long listaCorte;
    private String identifBobina ;

    @ManyToOne
    @JsonIgnore
    @JoinColumns({
        @JoinColumn(name = "idMov", referencedColumnName = "idMov"),
        @JoinColumn(name = "idLote", referencedColumnName = "idLote")
    })
    private EgresoMovimiento egresoMovimiento;
    
    // Constructor para deserialización desde JSON
    public ListaEgreso(Long id, Long listaCorte, String identifBobina, Map<String, Object> egresoMovimiento) {
        this.id = id;
        this.listaCorte = listaCorte;
        this.identifBobina = identifBobina;

        if (egresoMovimiento != null) {
            this.egresoMovimiento = new EgresoMovimiento();
            this.egresoMovimiento.setIdMov(((Number) egresoMovimiento.get("idMov")).longValue());
            this.egresoMovimiento.setIdLote(((Number) egresoMovimiento.get("idLote")).longValue());
        }
    }
}
