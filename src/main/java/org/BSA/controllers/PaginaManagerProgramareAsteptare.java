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

import static org.BSA.controllers.Login.getUserCurrent;
import java.net.URL;
import java.util.ResourceBundle;

public class PaginaManagerProgramareAsteptare implements Initializable {
    private ObservableList listProg = FXCollections.observableArrayList();
    private ObservableList listAcc = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> infoProg;
    @FXML
    private ChoiceBox<String> acc;
    @FXML
    private Button inapoi;
    @FXML
    private Button selectare;
    @FXML
    private Text mesaj;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for(User user : UserService.userRepository.find()){
            if(user.areProgramare() && user.esteClient()){
                String info = user.getUsername() + " " +  UserService.getOptiune(user.getUsername()) + " " + UserService.getAngajat(user.getUsername()) + " "+ UserService.getOra(user.getUsername());
                listProg.add(info);
            }
        }
    infoProg.getItems().addAll(listProg);
    listAcc.addAll("Acceptare", "Respingere");
    acc.getItems().addAll(listAcc);


    }

    public void selectAction(){
        if(acc.getValue().equals("Acceptare")){
            String info = infoProg.getValue();
            int index = info.indexOf(" ");
            String numeuser = info.substring(0, index);
            UserService.setUserAcc(numeuser);
            mesaj.setText("Programare acceptata!");
        }
        else if(acc.getValue().equals("Respingere")){
            mesaj.setText("Programare respinsa!");
        }

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