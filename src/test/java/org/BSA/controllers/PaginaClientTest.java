package org.BSA.controllers;
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
class PaginaClientTest {

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

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("paginaClient.fxml"));
        primaryStage.setTitle("BEAUTY SALON");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    @Test
    void testPaginaClient(FxRobot robot) {
    robot.clickOn("#AlegereAngajat");
    robot.clickOn("#inapoi");
    robot.clickOn("#VizualizareServiciiSiPreturi");
    robot.clickOn("#inapoi1");
    robot.clickOn("#AlegereOptiuneDorita");
    robot.clickOn("#inapoi2");
    robot.clickOn("#deconectare");
    }
}