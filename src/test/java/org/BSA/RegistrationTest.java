package org.BSA;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
class RegistrationTest {
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

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("BEAUTY SALON");
        primaryStage.setScene(new Scene(root, 450, 700));
        primaryStage.show();
    }

    @Test
    void testRegistration(FxRobot robot) {
        robot.clickOn("#nume");
        robot.write("Manta");
        robot.clickOn("#prenume");
        robot.write("Denisa");
        robot.clickOn("#username");
        robot.write("denim");
        robot.clickOn("#password");
        robot.write("deni");
        robot.clickOn("#telefon");
        robot.write("0766532333");
        robot.clickOn("#email");
        robot.write("denim@yahoo.com");
        robot.clickOn("#role");
        robot.clickOn("Client");

        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Contul a fost creat cu succes!");

        robot.clickOn("#backButton");
        robot.clickOn("#registrationButton");
        robot.clickOn("#nume");
        robot.write("Manta");
        robot.clickOn("#prenume");
        robot.write("Denisa");
        robot.clickOn("#username");
        robot.write("denim");
        robot.clickOn("#password");
        robot.write("deni");
        robot.clickOn("#telefon");
        robot.write("0766532333");
        robot.clickOn("#email");
        robot.write("denim@yahoo.com");
        robot.clickOn("#role");
        robot.clickOn("Client");
        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(String.format("Exista deja un cont cu numele de utilizator %s !", "denim"));

        robot.clickOn("#backButton");
        robot.clickOn("#registrationButton");
        robot.clickOn("#nume");
        robot.write("Mircioaga");
        robot.clickOn("#prenume");
        robot.write("Iulia");
        robot.clickOn("#username");
        robot.write("iulim");
        robot.clickOn("#password");
        robot.write("iuli");
        robot.clickOn("#telefon");
        robot.write("0766532322");
        robot.clickOn("#email");
        robot.write("iulim@yahoo.com");
        robot.clickOn("#role");
        robot.clickOn("Manager");
        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Contul a fost creat cu succes!");

        robot.clickOn("#backButton");
        robot.clickOn("#registrationButton");
        robot.clickOn("#nume");
        robot.write("Mircioaga");
        robot.clickOn("#prenume");
        robot.write("Iulia");
        robot.clickOn("#username");
        robot.write("iulim");
        robot.clickOn("#password");
        robot.write("iuli");
        robot.clickOn("#telefon");
        robot.write("0766532322");
        robot.clickOn("#email");
        robot.write("iulim@yahoo.com");
        robot.clickOn("#role");
        robot.clickOn("Manager");
        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(String.format("Exista deja un cont cu numele de utilizator %s !", "iulim"));
    }
}