package com.integra.materiales.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    private Long id_mov;
    private Long numero_pedido;
    private Long lista_corte;
    private String identif_bobina ;

}
