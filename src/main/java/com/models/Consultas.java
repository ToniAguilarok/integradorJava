package com.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
    
    
   private String url = "jdbc:mysql://localhost:3306/trabajointegrador";
   private String usuario = "root";
   private String contraseña = "";
   private int dias;
   private String especialidad;
   
   
   public void horasTrabajadas (){      
       try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Crear una declaración SQL
            Statement statement = conexion.createStatement();

            // Ejecutar la consulta SQL
            String consultaSQL = "SELECT "
                    + "idTecnico, "
                    + "SEC_TO_TIME(SUM(ABS(TIME_TO_SEC(TIMEDIFF(FECHA_FINALIZACION, FECHA_INCIDENTE))))) AS HorasTrabajadas "
                    + "FROM incidentes "
                    + "GROUP BY idTecnico "
                    + "ORDER BY HorasTrabajadas DESC";

            ResultSet resultSet = statement.executeQuery(consultaSQL);
            System.out.println("HORAS TRABAJADAS");
            System.out.println("----------------");
            // Procesar los resultados
            while (resultSet.next()) {
                // Aquí puedes obtener los datos de cada fila
                int idTecnico = resultSet.getInt("idTecnico");
                String horasTrabajadas = resultSet.getString("HorasTrabajadas");                
                // Hacer algo con los datos (imprimirlos, por ejemplo)
                System.out.println("ID Técnico: " + idTecnico + ", Horas Trabajadas: " + horasTrabajadas);
            }
            System.out.println("******************************************\n");

            // Cerrar recursos
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
        }             
   }
   
   
   public void horasTrabajadasXdias(int dias){
       this.dias= dias;
       try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Crear una consulta preparada
            String consultaSQL = "SELECT idTecnico, "
                    + "SEC_TO_TIME(ABS(SUM(TIME_TO_SEC(TIMEDIFF(FECHA_FINALIZACION, FECHA_INCIDENTE))))) AS HorasTrabajadas "
                    + "FROM incidentes "
                    + "WHERE FECHA_INCIDENTE >= CURDATE() - INTERVAL " +dias +" DAY "
                    + "GROUP BY idTecnico "
                    + "ORDER BY HorasTrabajadas DESC "
                    + "LIMIT 5";
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("HORAS TRABAJADAS EN X DIAS");
            System.out.println("--------------------------");
            // Procesar los resultados
            while (resultSet.next()) {
                int idTecnico = resultSet.getInt("idTecnico");
                String horasTrabajadas = resultSet.getString("HorasTrabajadas");

                System.out.println("ID Técnico: " + idTecnico + ", hs Trabajadas en "+ dias + " dias: " + horasTrabajadas);
            }
            System.out.println("**************************************************\n");
            // Cerrar recursos
            resultSet.close();
            preparedStatement.close();
            conexion.close();
        } catch (SQLException e) {
        }
    }
   
   public void cantDeIncidentes(){
       try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Crear una consulta preparada
            String consultaSQL = "SELECT idTecnico, COUNT(IDINCIDENTE) as CantIncidentes FROM incidentes GROUP BY idTecnico ORDER BY CantIncidentes DESC";
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("CANTIDAD DE INCIDENTES");
            System.out.println("----------------------");
            // Procesar los resultados
            while (resultSet.next()) {
                int idTecnico = resultSet.getInt("idTecnico");
                int cantIncidentes = resultSet.getInt("CantIncidentes");

                System.out.println("ID Técnico: " + idTecnico + ", Cantidad de Incidentes: " + cantIncidentes);
            }
            System.out.println("****************************************\n");
            // Cerrar recursos
            resultSet.close();
            preparedStatement.close();
            conexion.close();
        } catch (SQLException e) {
        }
   }
   public void cantDeIncidentesResueltos (){           
           try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Crear una consulta preparada
            String consultaSQL = "SELECT "
                    + "idTecnico, "
                    + "COUNT(IDINCIDENTE) as CantIncidentes "
                    + "FROM incidentes "
                    + "WHERE (ESTADO='resuelto')"
                    + "GROUP BY idTecnico "
                    + "ORDER BY CantIncidentes DESC";
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("CANTIDAD DE INCIDENTES RESUELTOS");
            System.out.println("--------------------------------");
            // Procesar los resultados
            while (resultSet.next()) {
                int idTecnico = resultSet.getInt("idTecnico");
                int cantIncidentes = resultSet.getInt("CantIncidentes");

                System.out.println("ID Técnico: " + idTecnico + ", Cant de Incidentes en RESUELTOS son: " + cantIncidentes);
            }
            System.out.println("**************************************************\n");
            // Cerrar recursos
            resultSet.close();
            preparedStatement.close();
            conexion.close();
        } catch (SQLException e) {
        }
   
   } 
       public void cantDeIncidentesResueltoXdias (int dias){
           this.dias= dias;
           try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Crear una consulta preparada
            String consultaSQL = "SELECT "
                    + "idTecnico, "
                    + "COUNT(IDINCIDENTE) as CantIncidentes "
                    + "FROM incidentes "
                    + "WHERE (ESTADO='resuelto') and FECHA_FINALIZACION >= CURDATE() - INTERVAL "+ dias + " DAY "
                    + "GROUP BY idTecnico "
                    + "ORDER BY idTecnico DESC";
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("CANTIDAD DE INCIDENTES RESUELTO EN X DIAS");
            System.out.println("--------------------------------");
            // Procesar los resultados
            while (resultSet.next()) {
                int idTecnico = resultSet.getInt("idTecnico");
                int cantIncidentes = resultSet.getInt("CantIncidentes");

                System.out.println("ID Técnico: " + idTecnico + ", Cant de Incidentes en " + dias + " dias son: " + cantIncidentes);
            }
            System.out.println("**************************************************\n");
            // Cerrar recursos
            resultSet.close();
            preparedStatement.close();
            conexion.close();
        } catch (SQLException e) {
        }
       }
       
    public void tecMasIncidentesEspecialidad(int dias, String especialidad){
        this.dias=dias;
        this.especialidad=especialidad;
        
        try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Crear una consulta preparada
            String consultaSQL = "SELECT "
                    + "incidentes.idTecnico, "
                    + "COUNT(IDINCIDENTE) as CantIncidentes "
                    + "FROM incidentes, tecnicos "
                    + "WHERE incidentes.idTecnico=tecnicos.IDTECNICO "
                    + "AND (ESTADO='resuelto') "
                    + "AND FECHA_FINALIZACION >= CURDATE() - INTERVAL " + dias + " DAY "
                    + "AND ESPECIALIDAD='"+especialidad+"'"
                    + "GROUP BY idTecnico "
                    + "ORDER BY CantIncidentes DESC";
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("TECNICO CON MAS INCIDENTES EN X DIAS Y EN X ESPECIALIDAD");
            System.out.println("--------------------------------------------------------");
            // Procesar los resultados
            while (resultSet.next()) {
                int idTecnico = resultSet.getInt("idTecnico");
                int cantIncidentes = resultSet.getInt("CantIncidentes");

                System.out.println("ID Técnico: " + idTecnico + ", Cant de Incidentes en " + dias+ " dias, en "+especialidad+" fueron: "+ cantIncidentes);
            }
            System.out.println("******************************************************************\n");
            // Cerrar recursos
            resultSet.close();
            preparedStatement.close();
            conexion.close();
        } catch (SQLException e) {
        }
    }
    
    public void ejecutarConsulta(String consultaSQL) {
      try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Crear la declaración preparada
       //     String consultaSQL = "SELECT * FROM " + tabla;
            PreparedStatement statement = conexion.prepareStatement(consultaSQL);

            // Ejecutar la consulta y obtener el conjunto de resultados
            ResultSet resultSet = statement.executeQuery();

            // Obtener información sobre las columnas
            int numColumnas = resultSet.getMetaData().getColumnCount();
            System.out.println("LA TABLA TIENE " + numColumnas + " COLUMNAS");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

            // Procesar el conjunto de resultados
            while (resultSet.next()) {
                // Acceder a todas las columnas por su índice
                for (int i = 1; i <= numColumnas; i++) {
                    String nombreColumna = resultSet.getMetaData().getColumnName(i);
                    String valorColumna = resultSet.getString(i);
                    System.out.println(nombreColumna + ": " + valorColumna);
                }
                System.out.println("\n-----\n");
            }

            // Cerrar la conexión
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }
    
}

   
   
   
   

      

