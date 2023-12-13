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
@Table (name= "Clientes")
public class Clientes implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 //   @OneToOne
    private Integer idCliente;          
    @Basic
    private String razonSocial;    
    @Basic
    private String CUIT;    
    @Basic
    private String email;  
    @Basic
    private String whatsapp;    
    
 }
