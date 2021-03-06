package org.BSA.controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.BSA.model.User;
import org.BSA.services.UserService;
import java.awt.*;
import static org.BSA.controllers.Login.getUserCurrent;

public class PaginaClientAlegereOptiune {

    @FXML
    private Button ButonInapoi;
    @FXML
    private Button Tuns;
    @FXML
    private Button Vopsit;
    @FXML
    private Button Gene;
    @FXML
    private Button Makeup;
    @FXML
    private Button Manichiura;
    @FXML
    private Button Pedichiura;
    @FXML
    private Button Tratamentefaciale;
    @FXML
    private Text Mesaj;
    @FXML
    private TextField AlegereOptiuneClient;
    @FXML
    private User user;
    public void setUser(User user) {
        this.user = user;
    }

    public void adaugareTuns() {
        UserService.adaugareOptiune(getUserCurrent,"Tuns");
        Mesaj.setText("Optiunea de tuns a fost selectata.");
    }
    public void adaugareVopsit() {
        UserService.adaugareOptiune(getUserCurrent,"Vopsit");
        Mesaj.setText("Optiunea de vopsit a fost selectata.");
    }
    public void adaugareGene() {
        UserService.adaugareOptiune(getUserCurrent,"Gene");
        Mesaj.setText("Optiunea de gene a fost selectata.");
    }
    public void adaugareMakeup() {
        UserService.adaugareOptiune(getUserCurrent,"Makeup");
        Mesaj.setText("Optiunea de make-up a fost selectata.");
    }
    public void adaugareManichiura() {
        UserService.adaugareOptiune(getUserCurrent,"Manichiura");
        Mesaj.setText("Optiunea de manichiura a fost selectata.");
    }
    public void adaugarePedichiura() {
        UserService.adaugareOptiune(getUserCurrent,"Pedichiura");
        Mesaj.setText("Optiunea de pedichiura a fost selectata.");
    }
    public void adaugareTratamenteFaciale() {
        UserService.adaugareOptiune(getUserCurrent,"Tratamentefaciale");
        Mesaj.setText("Optiunea de tratamente faciale a fost selectata.");
    }
    @FXML
    public void handleInapoiAction() throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("paginaClient.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) (ButonInapoi.getScene().getWindow());
            stage.setScene(new Scene(root));
            PaginaClient client = loader.getController();
            client.setUser(user);
            stage.show();
        } catch (Exception e) {
            System.out.println("Eroare");
        }
    }
}
