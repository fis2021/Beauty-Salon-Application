package org.BSA.model;

import org.dizitart.no2.objects.Id;

public class User {
    @Id
    private String username;
    private String password;
    private String role;
    private String telefon;
    private String nume;
    private String prenume;
    private String email;

    public User(String username, String password, String role, String telefon,String nume,String prenume,String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.telefon=telefon;
        this.nume=nume;
        this.prenume=prenume;
        this.email=email;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) { this.nume = nume; }

    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) { this.prenume = prenume; }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) { this.email = email; }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        String t;
        t=nume+" "+prenume+"\n"+telefon+"\n"+email;
        return t;
    }
}
