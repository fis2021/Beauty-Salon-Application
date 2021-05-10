package org.BSA.services;
import org.BSA.exceptions.UsernameAlreadyExistsException;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.BSA.exceptions.UsernameDoesNotExists;
import org.BSA.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.BSA.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("BSA.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static User login(String username, String password) throws UsernameDoesNotExists {
        User crt;

        crt = attemptLogin(username, password);

        if (crt == null) {
            throw new UsernameDoesNotExists(username);
        }

        return crt;
    }

    public static User attemptLogin(String username, String password) {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(encodePassword(username, password), user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    public static void addUser(String username, String password, String role, String telefon, String nume, String prenume, String email) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role, telefon, nume, prenume, email));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }


    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


    public static ObjectRepository<User> getUserRepository() {
        return userRepository;
    }

    public static void adaugareOptiune(String username, String optiune) {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                user.setOptiune(optiune);
                userRepository.update(user);
            }

        }
    }

    public static String getOptiune(String username) {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                return user.getOptiune();
            }

        }
        return null;
    }

    public static String getAngajat(String username){
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                return user.getAngajat();
            }
        }
        return null;

    }

    public static String setAngajat(String username, String numeAngajat){
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                user.setAngajat(numeAngajat);
                userRepository.update(user);
            }
        }
        return null;

    }


    public static String getOra(String username){
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                return user.getOra();
            }
        }
        return null;

    }

    public static String setOra(String username, String ora){
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                user.setOra(ora);
                userRepository.update(user);
            }
        }
        return null;

    }

}
