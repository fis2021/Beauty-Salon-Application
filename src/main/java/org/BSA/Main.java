package org.BSA;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.BSA.services.FileSystemService;
import org.BSA.services.UserService;


import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       // initDirectory();
        UserService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("BEAUTY SALON");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
