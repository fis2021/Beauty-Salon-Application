package org.BSA.services;



import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {


    @BeforeAll
    static void beforeAll() {
       System.out.println("BeforeClass");

    }

    @AfterAll
    static void afterAll() {
       System.out.println("AfterClass");

    }
     @BeforeEach
     void setUp() throws Exception {
         FileSystemService.APPLICATION_FOLDER = ". test-registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());


     }
     @AfterEach
     void tearDown() {
       System.out.println("AfterEach");
     }

    @Test
    @DisplayName("Baza de date este initializata si nu exista utilizatori")
    void testDatabaseIsInitializedAndNoUserIsPersisted () {
        UserService.initDatabase();
        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();

    }
}