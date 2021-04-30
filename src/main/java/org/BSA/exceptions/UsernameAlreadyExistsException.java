package org.BSA.exceptions;

public class UsernameAlreadyExistsException extends Exception {

    private String username;

    public UsernameAlreadyExistsException(String username) {
        super(String.format("Exista deja un cont cu numele de utilizator %s !", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
