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
@Table (name= "Servicios")
public class Servicios implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @OneToOne
    private Integer idServicio;
    @Basic
    private String descripcion;
    
}
