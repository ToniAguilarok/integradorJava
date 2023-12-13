package com.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "Incidentes")

public class Incidentes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer idIncidente;
    @Basic
    private String descripcion;
    @Basic
    private String estado;
    @Basic
    private String dificultad;
    @Basic
    private LocalDateTime fecha_Incidente;
    @Basic
    private LocalDateTime fecha_finalizacion;
    @Basic
    private String tipo;
    @Basic 
    private String consideraciones;
    @OneToOne
    @JoinColumn(name = "idServicio")
    private Servicios idServicio;
    @OneToOne
    @JoinColumn(name = "idTecnico")    
    private Tecnicos idTecnico;
    @OneToOne/*(mappedBy="idCliente")  */  
    @JoinColumn(name = "idCliente")    
    private Clientes idCliente;    
    
       
}
