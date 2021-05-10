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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.BSA.model.User;
import org.BSA.services.UserService;

import java.net.URL;
import java.util.ResourceBundle;

import static org.BSA.controllers.Login.getUserCurrent;

public class PaginaClientAlegereAngajat implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    ObservableList listOra = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> Angajat;
    @FXML
    private ChoiceBox<String> Ora;
    @FXML
    private Button buttonAlegereAngajat;

    @FXML
    private Button ButonInapoi;
    @FXML
    private User user;
    @FXML
    private Text screen;
    @FXML
    private Text screen1;
    @FXML
    private Text mesaj;
    @FXML
    private Text detalii;


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
        //AngajatService.addAngajat((String) user.getNume());
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
        loadDataOra();
    }

    private void loadData() {
        list.removeAll(list);
        String a = "Ionescu Claudiu-Tuns";
        String b = "Antonescu Maria-Vopsit";
        String c = "Para Georgiana-Tuns";
        String d = "Tomescu Lara-Gene";
        String e = "Voicu Andra-Makeup";
        String f = "Mihalache Sara-Makeup";
        String g = "Tarasinca Camelia-Manichiura";
        String h = "Georgescu Roxana-Pedichiura";
        String i = "Popovici Alina-Tratamente faciale";
        list.addAll(a, b, c, d, e, f, g, h, i);
        Angajat.getItems().addAll(list);
    }

    private void loadDataOra() {
        listOra.removeAll(listOra);
        String a = "08:00";
        String b = "09:00";
        String c = "10:00";
        String d = "11:00";
        String e = "12:00";
        String f = "13:00";
        String g = "14:00";
        String h = "15:00";
        String i = "16:00";
        String j = "17:00";
        String k = "18:00";
        String l = "19:00";
        String m = "20:00";
        listOra.addAll(a, b, c, d, e, f, g, h, i, j, k, l, m);
        Ora.getItems().addAll(listOra);
    }


    @FXML

    public void displayValue(javafx.event.ActionEvent actionEvent) {
        String angajat = Angajat.getValue();
        String optiuneUser = UserService.getOptiune(getUserCurrent);
        String ora = Ora.getValue();
        if (angajat == null) {
            screen.setText("Selectati un angajat!");
        } else if (angajat.contains(optiuneUser)) {
            mesaj.setText("Optiunea a fost selectata cu succes!");
            int index = angajat.indexOf("-");
            String numeAngajat = angajat.substring(0, index);
            UserService.setAngajat(getUserCurrent, numeAngajat);
            UserService.setOra(getUserCurrent, ora);


            if (numeAngajat.equals("Ionescu Claudiu")) {
                detalii.setText("Ati selectat Ionescu Claudiu pentru tuns. Programarea are loc la ora " + ora + ".\n" +
                        "Pentru mai multe detalii sunati la : 0722136458.");

            }
       else
        if(numeAngajat.equals("Antonescu Maria")){
            detalii.setText("Ati selectat Antonescu Maria pentru vopsit. Programarea are loc la ora " + ora + ".\n" +
                         "Pentru mai multe detalii sunati la : 0722136460.");
        }
        else
        if(numeAngajat.equals("Para Georgiana")){
            detalii.setText("Ati selectat Para Georgiana pentru tuns. Programarea are loc la ora " + ora + ".\n" +
                         "Pentru mai multe detalii sunati la : 0722136462.");
        }
        else
        if(numeAngajat.equals("Tomescu Lara")){
            detalii.setText("Ati selectat Tomescu Lara pentru gene. Programarea are loc la ora " + ora + ".\n" +
                         "Pentru mai multe detalii sunati la : 0722136464.");
        }
        else
        if(numeAngajat.equals("Voicu Andra")){
            detalii.setText("Ati selectat Voicu Andra pentru makeup. Programarea are loc la ora " + ora + ".\n" +
                         "Pentru mai multe detalii sunati la : 0722136470.");
        }
        else
        if(numeAngajat.equals("Mihalache Sara")){
            detalii.setText("Ati selectat Mihalache Sara pentru makeup. Programarea are loc la ora " + ora + ".\n" +
                         "Pentru mai multe detalii sunati la : 0722136484.");
        }
        else
        if(numeAngajat.equals("Tarasinca Camelia")){
            detalii.setText("Ati selectat Tarasinca Camelia pentru manichiura. Programarea are loc la ora " + ora + ".\n" +
                         "Pentru mai multe detalii sunati la : 0722136490.");
        }
        else
        if(numeAngajat.equals("Georgescu Roxana")){
            detalii.setText("Ati selectat Georgescu Roxana pentru pedichiura. Programarea are loc la ora " + ora + ".\n" +
                        "Pentru mai multe detalii sunati la : 0722136410.");
        }
        else
        if(numeAngajat.equals("Popovici Alina")){
            detalii.setText("Ati selectat Popovici Alina pentru tratamente faciale. Programarea are loc la ora " + ora + ".\n" +
                        "Pentru mai multe detalii sunati la : 0722136400.");
        }



        }
            else {
                mesaj.setText("Ati selectat angajatul gresit. \n Verificati optiunea deja selectata");
            }


        }
}
