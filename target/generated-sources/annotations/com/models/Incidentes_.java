package com.models;

import com.models.Clientes;
import com.models.Servicios;
import com.models.Tecnicos;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-13T14:10:23")
@StaticMetamodel(Incidentes.class)
public class Incidentes_ { 

    public static volatile SingularAttribute<Incidentes, Integer> idIncidente;
    public static volatile SingularAttribute<Incidentes, String> descripcion;
    public static volatile SingularAttribute<Incidentes, String> estado;
    public static volatile SingularAttribute<Incidentes, String> tipo;
    public static volatile SingularAttribute<Incidentes, String> consideraciones;
    public static volatile SingularAttribute<Incidentes, Clientes> idCliente;
    public static volatile SingularAttribute<Incidentes, LocalDateTime> fecha_Incidente;
    public static volatile SingularAttribute<Incidentes, Servicios> idServicio;
    public static volatile SingularAttribute<Incidentes, LocalDateTime> fecha_finalizacion;
    public static volatile SingularAttribute<Incidentes, Tecnicos> idTecnico;
    public static volatile SingularAttribute<Incidentes, String> dificultad;

}