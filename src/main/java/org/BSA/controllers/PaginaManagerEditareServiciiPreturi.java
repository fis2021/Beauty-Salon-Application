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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.BSA.model.EditareServiciiPreturi;
import org.BSA.model.ServiciiPreturi;
import org.BSA.model.User;


import java.net.URL;
import java.util.ResourceBundle;


public class  PaginaManagerEditareServiciiPreturi implements Initializable{
    @FXML
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
    @FXML
    private Button inapoi;
    @FXML
    public static  TableView<EditareServiciiPreturi> table_2;

    @FXML
    private TableView<EditareServiciiPreturi> table;

    @FXML
    private TableColumn<EditareServiciiPreturi, String> id;

    @FXML
    private TableColumn<EditareServiciiPreturi, String> servicii;

    @FXML
    private TableColumn<EditareServiciiPreturi,String> preturi;

    @FXML
    private TableColumn<EditareServiciiPreturi,Button> editare;
    public static ObservableList<EditareServiciiPreturi>  editareserviciipreturi;




   ObservableList<EditareServiciiPreturi> list1 = FXCollections.observableArrayList(

           new EditareServiciiPreturi("1","Par scurt-30 LEI, Par mediu-50 LEI, Par lung-70 LEI", "Tuns", new Button("update")),
           new EditareServiciiPreturi("2","Suvite-130 LEI, Balayage-350 LEI, Clasic-70 LEI", "Vopsit", new Button("update")),
           new EditareServiciiPreturi("3","Gene 1D-100 LEI, Gene 2D-150 LEI, Gene 3D-200 LEI", "Gene", new Button("update")),
           new EditareServiciiPreturi("4","Makeup Mireasa-250 LEI, Makeup de Zi-100 LEI, Makeup de Seara-150 LEI", "Makeup", new Button("update")),
           new EditareServiciiPreturi("5","Semi-60 LEI, Gel-100 LEI, Clasica-30 LEI", "Manichiura", new Button("update")),
           new EditareServiciiPreturi("6","Semi-60 LEI, Gel-100 LEI, Clasica-30 LEI", "Pedichiura", new Button("update")),
           new EditareServiciiPreturi("7","Dermabraziune-250 LEI, Peeling-300 LEI, Mezoterapie-200 LEI", "Tratamente Faciale", new Button("update")),
           new EditareServiciiPreturi("","", "", new Button("update")),
           new EditareServiciiPreturi("","", "", new Button("update")),
           new EditareServiciiPreturi("","", "", new Button("update"))


    );

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {    table_2=table;
        initTable();
        loadData();
        table.setItems(list1);


    }

    private void initTable(){
        intiCols();
    }

    private void intiCols(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        preturi.setCellValueFactory(new PropertyValueFactory<>("preturi"));
        servicii.setCellValueFactory(new PropertyValueFactory<>("servicii"));
        editare.setCellValueFactory(new PropertyValueFactory<>("update"));

       editableCols();
    }
    private void editableCols(){
        id.setCellFactory(TextFieldTableCell.forTableColumn());
        id.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
        });
        preturi.setCellFactory(TextFieldTableCell.forTableColumn());
        preturi.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPreturi(e.getNewValue());
        });
        servicii.setCellFactory(TextFieldTableCell.forTableColumn());
        servicii.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setServicii(e.getNewValue());
        });
       table.setEditable(true);
    }

    private void loadData(){
        editareserviciipreturi= FXCollections.observableArrayList();
        for(int i=0; i<6; i++){
           editareserviciipreturi.add(new EditareServiciiPreturi(String.valueOf(i), "preturi " + i, "servicii " + i, new Button("update")));
        }
        table.setItems(editareserviciipreturi);
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