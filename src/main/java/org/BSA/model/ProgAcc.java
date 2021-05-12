package org.BSA.model;

public class ProgAcc {
    int ID;
    String prgacc;
    public ProgAcc (String prgacc, int ID){
        this.prgacc=prgacc;
        this.ID=ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPrgacc() {
        return prgacc;
    }

    public void setPrgacc(String prgacc) {
        this.prgacc = prgacc;
    }
}
