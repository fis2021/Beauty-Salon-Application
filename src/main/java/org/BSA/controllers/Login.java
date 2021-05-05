package org.BSA.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.BSA.exceptions.UsernameAlreadyExistsException;
import org.BSA.exceptions.UsernameDoesNotExists;
import org.BSA.model.User;
import org.BSA.services.UserService;
import org.dizitart.no2.objects.ObjectRepository;

import java.io.IOException;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class Login {
    private final ObjectRepository<User> REPOSITORY = UserService.getUserRepository();
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonCreate;
    public void handleLoginAction() throws Exception {
        try {
            User user = UserService.login(usernameField.getText(), passwordField.getText());
            String detalii = user.toString();
            if(user.getRole().equals("Manager")) {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("paginaManager.fxml"));
                Parent root= loader.load();
                Stage stage = (Stage) (buttonLogin.getScene().getWindow());
                stage.setScene(new Scene(root));
                PaginaManager manager = loader.getController();
                manager.setUser(user);
                stage.show();}
            else
            if(user.getRole().equals("Client")){
                FXMLLoader loader1 = new FXMLLoader(getClass().getClassLoader().getResource("paginaClient.fxml"));
                Parent root= loader1.load();
                Stage stage = (Stage) (buttonLogin.getScene().getWindow());
                stage.setScene(new Scene(root));
                PaginaClient client = loader1.getController();
                client.setUser(user);

                stage.show();
            }
            registrationMessage.setText("Autentificarea a fost realizata cu succes!");


        } catch (UsernameDoesNotExists e) {
            registrationMessage.setText(e.getMessage());
        }
    }
    @FXML
    public void handleRegisterAction() throws Exception{
        try{
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage stage = (Stage) (buttonCreate.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){
            registrationMessage.setText("eroare!");
        }
    }
    public String getUsername(){
        return usernameField.getText();
    }
    public String getPassword(){
        return passwordField.getText();
    }

}
