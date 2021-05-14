package org.BSA.services;



import org.BSA.exceptions.UsernameAlreadyExistsException;
import org.BSA.exceptions.UsernameDoesNotExists;
import org.BSA.model.User;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @AfterEach
    void tearDown() {

        UserService.database.close();
    }
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
         FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
         FileSystemService.initDirectory();
         FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
         UserService.initDatabase();

     }
    /* void setUp() throws Exception {

         FileSystemService.APPLICATION_FOLDER = ". test-registration-example";
         //FileSystemService.initDirectory();
         FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
         UserService.initDatabase();
} */


    @Test
    @DisplayName("Baza de date este initializata si nu exista utilizatori")
    void testDatabaseIsInitializedAndNoUserIsPersisted () {
        //UserService.initDatabase();
        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }
    @Test
    @DisplayName("Utilizatorul este adaugat in baza de date")
    void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException {
        //UserService.initDatabase();
        UserService.addUser("denim" , "deni" , "Client", "0766532333" , "Manta", "Denisa", "denim@yahoo.com");
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("denim");
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword("denim","deni"));
        assertThat(user.getRole()).isEqualTo("Client");
        assertThat(user.getTelefon()).isEqualTo("0766532333");
        assertThat(user.getNume()).isEqualTo("Manta");
        assertThat(user.getPrenume()).isEqualTo("Denisa");
        assertThat(user.getEmail()).isEqualTo("denim@yahoo.com");

        UserService.addUser("iuliam" , "iuli" , "Manager", "0766111166" , "Mircioaga", "Iulia", "iuliam@yahoo.com");
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(2);
        User user1 = UserService.getAllUsers().get(1);
        assertThat(user1).isNotNull();
        assertThat(user1.getUsername()).isEqualTo("iuliam");
        assertThat(user1.getPassword()).isEqualTo(UserService.encodePassword("iuliam","iuli"));
        assertThat(user1.getRole()).isEqualTo("Manager");
        assertThat(user1.getTelefon()).isEqualTo("0766111166");
        assertThat(user1.getNume()).isEqualTo("Mircioaga");
        assertThat(user1.getPrenume()).isEqualTo("Iulia");
        assertThat(user1.getEmail()).isEqualTo("iuliam@yahoo.com");

    }

    @Test
    @DisplayName("Utilizatorul nu poate fi adaugat de 2 ori")
    void testUserCanNotBeAddedTwice() {
        assertThrows(UsernameAlreadyExistsException.class, () -> {
            UserService.addUser("denim", "deni" , "Client" , "0766532333", "Manta", "Denisa", "denim@yahoo.com");
            UserService.addUser("denim", "deni" , "Client" , "0766532333", "Manta", "Denisa", "denim@yahoo.com");
        });
    }

    @Test
    @DisplayName("Verifica daca se adauga o optiune")
    void testAdaugareOptiune() throws Exception{
        UserService.addUser("denim", "deni" , "Client" , "0766532333", "Manta", "Denisa", "denim@yahoo.com");
        UserService.adaugareOptiune("denim","Makeup");
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user=UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getOptiune()).isEqualTo("Makeup");
    }

    @Test
    @DisplayName("Verifica daca utilizatorul exista")
    void testcheckUsernameAlreadyExists() throws UsernameAlreadyExistsException{
       UserService.addUser("denim", "deni" , "Client" , "0766532333", "Manta", "Denisa", "denim@yahoo.com");
       assertThrows(UsernameAlreadyExistsException.class, () -> {
           UserService.checkUserDoesNotAlreadyExist("denim");
       });

    }

}