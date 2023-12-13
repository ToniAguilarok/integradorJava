
package com.controller;

import com.controller.exceptions.NonexistentEntityException;
import com.models.Clientes;
import com.models.Incidentes;
import com.models.Servicios;
import com.models.Tecnicos;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersistenceController {
    ClientesJpaController clientesjpa = new ClientesJpaController();
    ServiciosJpaController serviciosjpa = new ServiciosJpaController();
    TecnicosJpaController tecnicosjpa = new TecnicosJpaController();
    IncidentesJpaController incidentejpa = new IncidentesJpaController();
    
    //          CLIENTES Clientes cliente
    
    public void crearCliente(Clientes cliente) {
        clientesjpa.create(cliente);
    }
    public void eliminarCliente(int id) {
        try {
            clientesjpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarCliente(Clientes cliente) {
        try {
            clientesjpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }          
    public Clientes buscarCliente(Long id) {
        return clientesjpa.findClientes(0);
    }
    public ArrayList<Clientes> listaClientes() {
        List<Clientes> listaTemp = clientesjpa.findClientesEntities();
        ArrayList<Clientes> lista = new ArrayList(listaTemp);
        return lista;
        }
    
    
    //          SERVICIOS Servicios servi
        
    public void crearServicio(Servicios servi) {
        serviciosjpa.create(servi);
    }
    public void eliminarServicio(int id) {
        try {
            serviciosjpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarServicio(Servicios servi) {
        try {
            serviciosjpa.edit(servi);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Servicios buscarServicio(int id) {
        return serviciosjpa.findServicios(0);
    }
    public ArrayList<Servicios> listaServicios() {
        List<Servicios> listaTemp = serviciosjpa.findServiciosEntities();
        ArrayList<Servicios> lista = new ArrayList(listaTemp);
        return lista;
        }
        
    //          TECNICOS Tecnicos tecnico tecnicosjpa
        
    public void crearTecnicos(Tecnicos tecnico) {
        tecnicosjpa.create(tecnico);
    }
    public void eliminarTecnico(int id) {
        try {
            tecnicosjpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarTecnico(Tecnicos tecnico) {
        try {
            tecnicosjpa.edit(tecnico);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Tecnicos buscarTecnico(int id) {
        return tecnicosjpa.findTecnicos(0);
    }
    public ArrayList<Tecnicos> listaTecnicos() {
        List<Tecnicos> listaTemp = tecnicosjpa.findTecnicosEntities();
        ArrayList<Tecnicos> lista = new ArrayList(listaTemp);
        return lista;
        }  

    
    //      INCIDENTES Incidentes Incidente incidente incidentejpa
    
    public void crearIncidente(Incidentes incidente) {
        incidentejpa.create(incidente);
    }
    public void eliminarIncidentes(int id) {
        try {
            incidentejpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarIncidente(Incidentes incidente) {
        try {
            incidentejpa.edit(incidente);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Incidentes buscarIncidente(int id) {
        return incidentejpa.findIncidentes(0);
    }
    public ArrayList<Incidentes> listaIncidentes() {
        List<Incidentes> listaTemp = incidentejpa.findIncidentesEntities();
        ArrayList<Incidentes> lista = new ArrayList(listaTemp);
        return lista;
        }     
}