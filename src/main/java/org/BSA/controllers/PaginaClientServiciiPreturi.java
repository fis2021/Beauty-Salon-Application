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
import org.BSA.model.ServiciiPreturi;
import org.BSA.model.User;


import java.net.URL;
import java.util.ResourceBundle;


public class PaginaClientServiciiPreturi implements Initializable{
    @FXML
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
    @FXML
    private Button backButton;
    @FXML
    private TableView<ServiciiPreturi> table;

    @FXML
    private TableColumn<ServiciiPreturi, Integer> id;

    @FXML
    private TableColumn<ServiciiPreturi, String> servicii;

    @FXML
    private TableColumn<ServiciiPreturi,String> preturi;

    private ObservableList<User> serviciisipreturi;
    ObservableList<ServiciiPreturi> list = FXCollections.observableArrayList(

            new ServiciiPreturi(1,"Par scurt-30 LEI, Par mediu-50 LEI, Par lung-70 LEI", "Tuns"),
            new ServiciiPreturi(2,"Suvite-130 LEI, Balayage-350 LEI, Clasic-70 LEI", "Vopsit"),
            new ServiciiPreturi(3,"Gene 1D-100 LEI, Gene 2D-150 LEI, Gene 3D-200 LEI", "Gene"),
            new ServiciiPreturi(4,"Makeup Mireasa-250 LEI, Makeup de Zi-100 LEI, Makeup de Seara-150 LEI", "Makeup"),
            new ServiciiPreturi(5,"Semi-60 LEI, Gel-100 LEI, Clasica-30 LEI", "Manichiura"),
            new ServiciiPreturi(6,"Semi-60 LEI, Gel-100 LEI, Clasica-30 LEI", "Pedichiura"),
            new ServiciiPreturi(7,"Dermabraziune-250 LEI, Peeling-300 LEI, Mezoterapie-200 LEI", "Tratamente Faciale")
    );
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        id.setCellValueFactory(new PropertyValueFactory<ServiciiPreturi,Integer>("id"));
        preturi.setCellValueFactory(new PropertyValueFactory<ServiciiPreturi,String>("preturi"));
        servicii.setCellValueFactory(new PropertyValueFactory<ServiciiPreturi,String>("servicii"));
        table.setItems(list);
    }

    public void handleBackAction() throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("paginaClient.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) (backButton.getScene().getWindow());
            stage.setScene(new Scene(root));
            PaginaClient client = loader.getController();
            client.setUser(user);
            stage.show();
        } catch (Exception e) {
            System.out.println("Eroare");
        }
    }

}