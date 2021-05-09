package org.BSA.model;

import org.dizitart.no2.objects.Id;

import java.util.ArrayList;

public class Angajat {
   // private String numeProfesor;
    @Id
    private String numeAngajat;
    //private String[] elevi=new String[100];

    //private int contor=0;
    //private ArrayList<String> elevi;

    public Angajat(String numeAngajat){
        this.numeAngajat=numeAngajat;



    }
    public Angajat(){}

    public void setNumeAngajat(String numeAngajat) {
        this.numeAngajat = numeAngajat;
    }
   // public void setNumeProfesor(String numeProfesor){
       // this.numeProfesor=numeProfesor;
   // }
   // public String getNumeProfesor(){
       // return numeProfesor;
   // }
    public String getNumeAngajat(){
        return numeAngajat;
    }
   // public String[] getelevi(){ return elevi;}


   // public void addElev(String numeElev){
       // if(contor==elevi.length){
         //  String[] aux=new String[2*contor];
         //   int i;
           // for(i=0;i<contor;i++){
            //    aux[i]=elevi[i];

           // }
           // elevi=aux;

       // }
      //  elevi[contor++]=numeElev;
   // }


}
