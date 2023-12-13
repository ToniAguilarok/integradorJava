package com.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "Tecnicos")
public class Tecnicos implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer idTecnico;
    @Basic
    private String nombre;
    @Basic
    private String medio_de_notificacion;
    @Basic    
    private String especialidad;
}
