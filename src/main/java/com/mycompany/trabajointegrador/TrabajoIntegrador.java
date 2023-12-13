package com.mycompany.trabajointegrador;

import com.controller.Controller;
import com.models.Clientes;
import com.models.Consultas;
import com.models.Incidentes;
import com.models.Servicios;
import com.models.Tecnicos;
import java.time.LocalDateTime;


public class TrabajoIntegrador {

    public static void main(String[] args) {
        
        Controller control = new Controller ();                     
        
        //AGREGANDO CLIENTE
        Clientes cli1 = new Clientes (1,"Tango" ,"23-123456-9", "fulanito@gmail.com", "03755-142536");
        Clientes cli2 = new Clientes (1,"Sap" ,"23-654321-9", "menganito@gmail.com", "03755-874955");
        Clientes cli3 = new Clientes (1,"MacOS" ,"23-852741-9", "pepito@gmail.com", "03755-685734");
    
        
    //              CRUD A TRAVES DEL CONTROLADOR EL CLIENTE A LA BASE DE DATOS 
    //                          AGREGAR A LA BASE DE DATOS    
    
        control.agregarCliente(cli1);
        control.agregarCliente(cli2);
        control.agregarCliente(cli3);
        
        //                      EDITANDO CLIENTE
        //          EDITANDO LA RAZON SOCIAL DE TANGO A OTROS
        
        cli1.setRazonSocial("OTROS");
        control.editarCliente(cli1);
        
       
       //                       AGREGANDO TECNICO
       
       Tecnicos tec1 = new Tecnicos(1, "Carlos", "Email", "Windows"); 
       Tecnicos tec2 = new Tecnicos(2, "Ramon", "Email", "Linux");
       Tecnicos tec3 = new Tecnicos(3, "Miguel", "Email", "Windows"); 
       control.agregarTecnico(tec1);
       control.agregarTecnico(tec2);
       control.agregarTecnico(tec3);
       
       //                       EDITANDO TECNICO
       
     /*  
       //EDITANDO EL NOMBRE DEL TECNICO, DE Carlos a Miguel y de medio de notificacion de Email a Whatsapp
       
       tec1.setNombre("Miguel");
       tec1.setMedio_de_notificacion("Whatsapp");
       control.editarTecnico(tec1);
    */
     
     
       //                       AGREGANDO SERVICIO
       
       Servicios serv1 = new Servicios (1, "WINDOWS");
       Servicios serv2 = new Servicios (2, "LINUX");
       Servicios serv3 = new Servicios (3, "MacOS");
       control.agregarServicio(serv1);
       control.agregarServicio(serv2);
       control.agregarServicio(serv3);       

       
       //                       AGREGANDO INCIDENTE
       
       Incidentes inci1 = new Incidentes (1, "PANTALLA AZUL", "resuelto", "COMPLEJO", LocalDateTime.of(2023,11 , 18, 8, 0), LocalDateTime.of(2023, 11, 20, 12, 0), "Windows", "Usar Anti-Malware", serv1, tec1, cli1);
       Incidentes inci2 = new Incidentes (2, "NO ARRANCA EL SIST.", "resuelto", "COMPLEJO", LocalDateTime.of(2023,11 , 25, 8, 0), LocalDateTime.of(2023, 11, 28, 18, 0), "Linux", "Apagar bien el sist.", serv2, tec2, cli2);
       Incidentes inci3 = new Incidentes (3, "ERROR 404", "resuelto", "COMPLEJO",LocalDateTime.of(2023,11 , 27, 8, 0), LocalDateTime.of(2023, 11, 30, 18, 0), "Windows", "No usar software que no esten en el AppleStore", serv3, tec1, cli2);
       Incidentes inci4 = new Incidentes (3, "ERROR 1404", "resuelto", "COMPLEJO", LocalDateTime.of(2023,11 , 20, 8, 0), LocalDateTime.of(2023, 11, 22, 18, 0), "Windows", "No prestar la pc a menores", serv3, tec3, cli2);
       Incidentes inci5 = new Incidentes (3, "ERROR 14", "resuelto", "COMPLEJO", LocalDateTime.of(2023,11 , 17, 8, 0), LocalDateTime.of(2023, 11, 22, 18, 0), "Windows", "No prestar la pc a menores", serv3, tec3, cli2);
       Incidentes inci6 = new Incidentes (3, "ERROR 404", "resuelto", "COMPLEJO", LocalDateTime.of(2023,11 , 22, 8, 0), LocalDateTime.of(2023, 11, 25, 18, 0), "Windows", "No usar software que no esten en el AppleStore", serv3, tec1, cli2);
       control.agregarIncidentes(inci1);
       control.agregarIncidentes(inci2);
       control.agregarIncidentes(inci3);
       control.agregarIncidentes(inci4);
       control.agregarIncidentes(inci5);
       control.agregarIncidentes(inci6);       
       
       /*   
                                FORMAS DE USAR EL CRUD 
       
       
        EDITANDO INCIDENTE, fecha de finalizacion, del 2023-12-03 al 2023-12-10 a las 8am (AGREGANDO "COLCHON" DE TIEMPO)
        inci1.setFecha_finalizacion(LocalDateTime.of(2023, 12, 10, 8, 0));
        control.editarIncidentes(inci1);
        
        ELIMINAR DE LA BASE DE DATOS
        controlador.eliminarCliente(3);
    
        BUSCAR EN LA BASE DE DATOS
        System.out.println(controlador.buscarCliente(2));
       
        EDITAR EN LA BASE DE DATOS   
        cli1.setNombre("Mengano");
        controlador.editarCliente(cli1);
       
        System.out.println(controlador.listaClientes());
       
     */      
       
        //                         CONSULTAS
          
        Consultas consulta = new Consultas ();
        System.out.println("\n");
        // PARA ESCRIBIR LA CONSULTA SQL Y LLAMAR A LA TABLA QUE DESEE, EJEMPLO select * from incidentes
        
        consulta.ejecutarConsulta("select * from incidentes"); 
        
        
        // CALCULA Y DEVUELVE LAS HORAS TRABAJADAS LLAMANDO A LA CONSULTA A TRAVES DE UN OBJETO (CONSULTA) CON SU VOID CREADO
        // EN DICHA CLASE
        
        consulta.horasTrabajadas();
        
        
        // CALCULA Y DEVUELVE LAS HORAS TRABAJADAS LLAMANDO A LA CONSULTA A TRAVES DE UN OBJETO (CONSULTA) CON SU VOID CREADO
        // EN DICHA CLASE SOLCITANDO LOS DIAS QUE DESEA CALCULAR. EJEMPLO 15 DIAS
        
        consulta.horasTrabajadasXdias(15);   
        
        
        // DEVUELVE LAS CANTIDAD DE INCIDENTES LLAMANDO A LA CONSULTA A TRAVES DE UN OBJETO (CONSULTA) CON SU VOID CREADO
        
        consulta.cantDeIncidentes(); 
        
        
        // CALCULA Y DEVUELVE LA CANTIDAD DE INCIDENTES RESUELTOS LLAMANDO A LA CONSULTA A TRAVES DE UN OBJETO (CONSULTA) CON SU VOID CREADO        
        
        consulta.cantDeIncidentesResueltos();
                
        
        // CALCULA Y DEVUELVE LA CANTIDAD DE INCIDENTES RESUELTOS LLAMANDO A LA CONSULTA A TRAVES DE UN OBJETO (CONSULTA) CON SU VOID CREADO
        // EN DICHA CLASE SOLCITANDO LOS DIAS QUE DESEA CALCULAR. EJEMPLO 5 DIAS
        
        consulta.cantDeIncidentesResueltoXdias(5);   
        
        
        // CALCULA Y DEVUELVE LA CANTIDAD DE INCIDENTES RESUELTOS LLAMANDO A LA CONSULTA A TRAVES DE UN OBJETO (CONSULTA) CON SU VOID CREADO
        // EN DICHA CLASE SOLCITANDO LOS DIAS QUE DESEA CALCULAR Y LA ESPECIALIDAD. EJEMPLO 15 DIAS ESPECIALIDAD Windows
        
        consulta.tecMasIncidentesEspecialidad(15, "Windows");        

    }
    
}                  



    
    
    
