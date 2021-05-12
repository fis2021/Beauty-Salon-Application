package org.BSA.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.BSA.model.ProgAcc;
import org.BSA.model.ServiciiPreturi;
import org.BSA.model.User;
import org.BSA.services.UserService;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PaginaManagerProgramariAcceptate implements Initializable {

    @FXML
    private TableView<ProgAcc> table;
    @FXML
    private Button inapoi;
    @FXML
    private TableColumn<ProgAcc, Integer> ID;

    @FXML
    private TableColumn<ProgAcc, String> prgacc;

    private ObservableList<ProgAcc> progacc;

    ObservableList<ProgAcc> list = FXCollections.observableArrayList(
    );
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        int i = 0;
        for(User user : UserService.userRepository.find()){
            if(user.getAcceptat() == 1){
                i++;
                String info= "Client: " + user.getNume() + " " + user.getPrenume() +  ", Optiune: " + UserService.getOptiune(user.getUsername()) + ", Angajatul: " + UserService.getAngajat(user.getUsername()) + ", Ora: " + UserService.getOra(user.getUsername()) + ", Telefon Client:  " + user.getTelefon();
                list.add(new ProgAcc(info ,i)) ;
                //System.out.println(info);
            }
        }
        ID.setCellValueFactory(new PropertyValueFactory<ProgAcc,Integer>("ID"));
        prgacc.setCellValueFactory(new PropertyValueFactory<ProgAcc,String>("prgacc"));

        table.setItems(list);
    }
    @FXML
    public void handleInapoiAction() throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("paginaManager.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) (inapoi.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("Eroare");
        }
    }
}