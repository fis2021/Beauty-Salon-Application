package org.BSA.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.BSA.model.Angajat;
import org.BSA.model.User;
import org.BSA.services.AngajatService;

import java.net.URL;
import java.util.ResourceBundle;

public class PaginaClientAlegereAngajat implements Initializable{
   ObservableList list = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> Angajat;
    @FXML
    private Button buttonAlegereAngajat;
    @FXML
    private Button buttonDetalii;
    @FXML
    private Button ButonInapoi;
    @FXML
    private User user;
    @FXML
    private Text screen;
    @FXML
    private Text screen1;


    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    public void handleAlegereAngajat() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("clientAlegereAngajat.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) (buttonAlegereAngajat.getScene().getWindow());
        stage.setScene(new Scene(root));
        PaginaClient angajat = loader.getController();
        angajat.setUser(user);
        AngajatService.addAngajat((String) user.getNume());
        stage.show();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }

    private void loadData() {
       list.removeAll(list);
        String a = "Ionescu Claudiu-tuns";
        String b = "Antonescu Maria-vopsit";
        String c = "Para Georgiana-tuns";
        String d = "Tomescu Lara-gene";
        String e = "Voicu Andra-makeup";
        String f = "Mihalache Sara-makeup";
        String g = "Tarasinca Camelia-manichiura";
        String h=  "Georgescu Roxana-pedichiura";
        String i=  "Popovici Alina-tratamente faciale";
        list.addAll(a, b, c, d, e, f, g, h, i);
        Angajat.getItems().addAll(list);
    }

    @FXML

    public void displayValue(javafx.event.ActionEvent actionEvent) {
        String angajat = Angajat.getValue();

        if (angajat == null) {
            screen.setText("Selectati un angajat!");

        } else
            if(angajat=="Ionescu Claudiu-tuns"){
           screen.setText("Ati selectat Ionescu Claudiu pentru tuns. Programarea are loc la ora 12:00.");
                screen1.setText("Pentru mai multe detalii sunati la : 0722136458.");
            }
            else
                if(angajat=="Antonescu Maria-vopsit"){
                    screen.setText("Ati selectat Antonescu Maria pentru vopsit. Programarea are loc la ora 14:00.");
                    screen1.setText("Pentru mai multe detalii sunati la : 0722136460.");
                }
                else
                if(angajat=="Para Georgiana-tuns"){
                    screen.setText("Ati selectat Para Georgiana pentru tuns. Programarea are loc la ora 14:00.");
                    screen1.setText(" Pentru mai multe detalii sunati la : 0722136462.");
                }
                else
                if(angajat=="Tomescu Lara-gene"){
                    screen.setText("Ati selectat Tomescu Lara pentru gene. Programarea are loc la ora 16:00.");
                    screen1.setText("Pentru mai multe detalii sunati la : 0722136464.");
                }
                else
                if(angajat=="Voicu Andra-makeup"){
                    screen.setText("Ati selectat Voicu Andra pentru makeup. Programarea are loc la ora 18:00.");
                    screen1.setText("Pentru mai multe detalii sunati la : 0722136470.");
                }
                else
                if(angajat=="Mihalache Sara-makeup"){
                    screen.setText("Ati selectat Mihalache Sara pentru makeup. Programarea are loc la ora 10:00.");
                    screen1.setText("Pentru mai multe detalii sunati la : 0722136484.");
                }
                else
                if(angajat=="Tarasinca Camelia-manichiura"){
                    screen.setText("Ati selectat Tarasinca Camelia pentru manichiura. Programarea are loc la ora 09:00.");
                    screen1.setText("Pentru mai multe detalii sunati la : 0722136490.");
                }
                else
                if(angajat=="Georgescu Roxana-pedichiura"){
                    screen.setText("Ati selectat Georgescu Roxana pentru pedichiura. Programarea are loc la ora 11:00.");
                    screen1.setText("Pentru mai multe detalii sunati la : 0722136410.");
                }
                else
                if(angajat=="Popovici Alina-tratamente faciale"){
                    screen.setText("Ati selectat Popovici Alina pentru tratamente faciale. Programarea are loc la ora 13:00");
                    screen1.setText("Pentru mai multe detalii sunati la : 0722136400.");
                }

    }
}
