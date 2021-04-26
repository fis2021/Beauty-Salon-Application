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


    public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;
    @FXML
    private TextField telefonField;
    @FXML
    private TextField numeField;
    @FXML
    private TextField prenumeField;
    @FXML
    private TextField emailField;
    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Manager");
    }
    @FXML
    private Button button1;



        public void handleRegisterAction() throws Exception {
        try {
           UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue(),telefonField.getText(), numeField.getText(), prenumeField.getText(), emailField.getText());
            registrationMessage.setText("Account created successfully!");
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("paginaprincipala.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) (button1.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
