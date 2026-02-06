package com.mycompany.Class;

import javafx.scene.control.Alert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pollix
 */
public class CConexion {
    private final String puerto = "...";
    private final String ip = "...";
    private final String bd = "...";
    private final String usuario = "...";
    private final String password = "...";
    private final String cadena = "jdbc:postgresql://" + ip + ":" + puerto + "/" + bd;
    private static final String URL = " +cadena+ //localhost: +puerto+ / +bd+ ";
    private static final String USUARIO = "...";
    private static final String CONTRASEnA = "...";
    private Connection conectar = null;
    
    public void cerrarConexion(){
        if (conectar != null) {
            try {
                conectar.close();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Conexión Cerrada", "Conexión a la base de datos cerrada");
            } catch (SQLException e){
                System.err.println("Error al cerrar la conexion: "+ e.getMessage());
            }
        }
    }
    
    public static Connetion obtenerConexion() throws SQLException {
        Connection conexion = null;
        try {
            
            Class.forName("org.postgresql.Driver");
            
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEnA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al conectar con la base de datos", e);
        }
        return conexion;
    }
    
    public boolean establecerConexion() {
        try {
            Class.forName("org.postgresql.Driver"); 

            conectar = DriverManager.getConnection(cadena, usuario, password); 

            mostrarAlerta(Alert.AlertType.INFORMATION, "Conexión Exitosa", "Conexión exitosa a la base de datos");
            return true;

        } catch (ClassNotFoundException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Conexión", "Driver de PostgreSQL no encontrado");
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Conexión", "Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
}
