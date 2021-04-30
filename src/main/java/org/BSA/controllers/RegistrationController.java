package org.BSA.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.BSA.exceptions.UsernameAlreadyExistsException;
import org.BSA.services.UserService;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField nume;
    @FXML
    private TextField prenume;
    @FXML
    private ChoiceBox role;
    @FXML
    private TextField telefon;
    @FXML
    private TextField email;
    @FXML
    private Button button;





    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Manager");
    }

    @FXML
    public void handleRegisterAction() throws Exception {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue(),telefon.getText(), nume.getText(),prenume.getText(),email.getText());
            registrationMessage.setText("Contul a fost creat cu succes!");

        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }


    @FXML
    public void Backaction() throws Exception{
        try{
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage stage = (Stage) (button.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){
            registrationMessage.setText("eroare!");
        }
    }


}