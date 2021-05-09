package org.BSA.model;

import org.dizitart.no2.objects.Id;

import java.util.ArrayList;

public class Angajat {

    @Id
    private String numeAngajat;

    public Angajat(String numeAngajat){
        this.numeAngajat=numeAngajat;



    }
    public Angajat(){}

    public void setNumeAngajat(String numeAngajat) {
        this.numeAngajat = numeAngajat;
    }

    public String getNumeAngajat(){
        return numeAngajat;
    }



}