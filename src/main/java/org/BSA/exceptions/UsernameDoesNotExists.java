package org.BSA.exceptions;


public class UsernameDoesNotExists extends  Exception{
    private String username;
    public UsernameDoesNotExists(String username) {
        super(String.format("Numele de utilizator si/ sau parola sunt incorecte", username));
        this.username = username;
    }


    public String getUsername()
    {
        return username;
    }
}