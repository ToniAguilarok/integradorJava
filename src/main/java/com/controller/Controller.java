package com.controller;

import com.models.Clientes;
import com.models.Incidentes;
import com.models.Servicios;
import com.models.Tecnicos;

public class Controller {
    
     PersistenceController control = new PersistenceController();
     
     //      CLIENTES Clientes
     
     public void agregarCliente (Clientes cliente){
         control.crearCliente(cliente);
     }
     
     public void eliminarCliente (Long id){
        control.eliminarCliente(0);
     }   
     
     public void editarCliente (Clientes cliente){
         control.editarCliente(cliente);     
     }
     
     public Clientes buscarCliente (Long id){
         Clientes cliente = new Clientes();
        cliente = control.buscarCliente(id);
        return cliente;
     }
     public void listaClientes(){
         control.listaClientes();
     }
     
     //       SERVICIOS Servicios
     
     public void agregarServicio (Servicios servicio){
         control.crearServicio(servicio);
     }
     
     public void eliminarServicio (int id){
        control.eliminarServicio(0);
     }   
     
     public void editarServicio (Servicios servicio){
         control.editarServicio(servicio);     
     }
     
     public Servicios buscarServicio (int id){
        Servicios servicio = new Servicios();
        servicio = control.buscarServicio(id);
        return servicio;
        
     }
     public void listaServicios(){
         control.listaServicios();
     }
     
     //      TECNICOS Tecnicos 
     
     public void agregarTecnico (Tecnicos tecnico){
         control.crearTecnicos(tecnico);
     }     
     public void eliminarTecnico (int id){
        control.eliminarTecnico(0);
     }        
     public void editarTecnico (Tecnicos tecnico){
         control.editarTecnico(tecnico);     
     }     
     public Tecnicos buscarTecnico (int id){
        Tecnicos tecnico = new Tecnicos();
        tecnico = control.buscarTecnico(id);
        return tecnico;        
     }
     public void listaTecnicos(){
         control.listaTecnicos();
     }
       
     //     INCIDENTES Incidentes incidente 
     
     public void agregarIncidentes (Incidentes incidente){
         control.crearIncidente(incidente);
     }     
     public void eliminarIncidentes (int id){
        control.eliminarIncidentes(0);
     }        
     public void editarIncidentes (Incidentes incidente){
         control.editarIncidente(incidente);     
     }     
     public Incidentes buscarIncidentes (int id){
        Incidentes incidente = new Incidentes();
        incidente = control.buscarIncidente(id);
        return incidente;        
     }
     public void listaIncidentes(){
         control.listaIncidentes();
     }        
}
