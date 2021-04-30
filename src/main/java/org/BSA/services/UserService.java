package org.BSA.services;

import org.BSA.exceptions.UsernameAlreadyExistsException;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.BSA.exceptions.UsernameDoesNotExists;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import org.BSA.model.User;
import org.BSA.services.FileSystemService;

import static org.BSA.services.FileSystemService.getPathToFile;


public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("BSA.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role, String telefon,String nume,String prenume,String email) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role,telefon,nume,prenume,email));
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
}
