package com.mycompany.salondeeventos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.mycompany.DAO.LoginDAO;
import com.mycompany.DAO.MensajesDAO;

public class LoginController {

    @FXML
    private TextField txtMatricula;
    @FXML
    private Button btnLogin;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private Button btnexit;

    // 
    @FXML
    private void validarUsuario(ActionEvent event) throws Exception {
        
        LoginDAO loginDAO = new LoginDAO();
       
        String matricula = txtMatricula.getText();
       
        if (matricula.matches("[0-9]{6}"))
        {
            //Falta conectarse con el SQL para que se pueda validar el usuario
            if(loginDAO.validarUsurio(matricula)){
               //En "+ matricula" se podra cambiar por un string del nombre del admin del programa
               MensajesDAO.mostrarMensaje("Acceso concedido", "Bienvenido, " + matricula,1);
               //Si se tiene una ventana de inicio del programa, solo se cambia la ruta del "secundary.fxml"
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/secundary.fxml"));
               Parent root = loader.load();
               Scene scene = new Scene(root);
               
               Stage stage = new Stage();
               stage.setScene(scene);
               stage.setTitle("Eventos");
               stage.show();
               
               ((Node) event.getSource()).getScene().getWindow().hide();
            } else {
               MensajesDAO.mostrarMensaje("Acceso denegado", "Matricula Incorrecta", 0);
            }  
        } else {
            MensajesDAO.mostrarMensaje("Error", "La matricula debe de ser de 6 digitos numéricos.",0);
        }       
    }
    

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
}
