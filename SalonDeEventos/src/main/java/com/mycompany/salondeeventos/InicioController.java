package com.mycompany.salondeeventos;

import com.mycompany.Class.CConexion;
import com.mycompany.DAO.MensajesDAO;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.stage.Stage;



public class InicioController {

    @FXML
    private Button btninicio;

    @FXML
    private void Iniciar(ActionEvent event) {
        
        CConexion conexion = new CConexion();
        boolean conexionExitosa = conexion.establecerConexion();
        
        if (!conexionExitosa){
            MensajesDAO.mostrarMensaje("Error de conexión", "No se pudo establecer la conexión con la base de datos", 0);
        } else {
            try {
                // Carga la nueva Scene desde el archivo FXML
                FXMLLoader loader = new FXMLLoader (getClass().getResource("/View/Vistalogin.fxml"));
                Parent root = loader.load();
                Scene newScene = new Scene(root);
                
                //Obtiene el estado actual (ventana principal)
                Scene currentScene = btninicio.getScene();
                Stage stage = (Stage) currentScene.getWindow();
                
                // Establecer la nueva escena en el Stage
                stage.setScene(newScene);
                stage.show();
            } catch (IOException e){
                e.printStackTrace();
                MensajesDAO.mostrarMensaje("Error al cargar la Ventana", "Ocurrio un error al cargar la nueva ventana.", 0);
            }
        }
    }
}