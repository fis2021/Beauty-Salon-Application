package org.BSA.model;

public class ServiciiPreturi {
    int id;
    String preturi;
    String servicii;

    public ServiciiPreturi(int id, String preturi, String servicii)  {
        this.id = id;
        this.preturi=preturi;
        this.servicii=servicii;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreturi() {
        return preturi;
    }

    public void setPreturi(String preturi) {
        this.preturi = preturi;
    }

    public String getServicii() {
        return servicii;
    }

    public void setServicii(String servicii) {
        this.servicii = servicii;
    }
}