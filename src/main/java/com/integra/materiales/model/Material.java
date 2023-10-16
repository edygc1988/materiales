package com.integra.materiales.model;

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
public class Material {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String Last_Name;
    private String Phone;

}
            