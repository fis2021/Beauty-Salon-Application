package org.BSA;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.BSA.exceptions.UsernameAlreadyExistsException;
import org.BSA.exceptions.UsernameDoesNotExists;
import org.BSA.services.FileSystemService;
import org.BSA.services.UserService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class LoginTest {
    @AfterEach
    void tearDown() {

        UserService.database.close();
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();

    }

    @Start
    void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("BEAUTY SALON");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }

    @Test
    void testLogin(FxRobot robot) throws UsernameAlreadyExistsException {
        UserService.addUser("denim" , "deni" , "Client", "0766532333" , "Manta", "Denisa", "denim@yahoo.com");
        robot.clickOn("#username");
        robot.write("denim");
        robot.clickOn("#password");
        robot.write("deni");
        robot.clickOn("#buttonLogin");

        robot.clickOn("#deconectare");

        robot.clickOn("#username");
        robot.write("deni");
        robot.clickOn("#password");
        robot.write("deni");

        robot.clickOn("#buttonLogin");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(String.format("Numele de utilizator si/ sau parola sunt incorecte", "denim"));


        robot.clickOn("#registrationButton");
        robot.clickOn("#backButton");


        UserService.addUser("iuliam" , "iuli" , "Manager", "0766111166" , "Mircioaga", "Iulia", "iuliam@yahoo.com");


        robot.clickOn("#username");
        robot.write("iuliam");
        robot.clickOn("#password");
        robot.write("iuli");

        robot.clickOn("#buttonLogin");

    }

}