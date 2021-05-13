package org.BSA.model;
import javafx.collections.ObservableList;
import org.BSA.controllers.PaginaManagerEditareServiciiPreturi;
import java.awt.*;
import javafx.scene.control.Button;
import org.BSA.controllers.PaginaManagerEditareServiciiPreturi;

public class EditareServiciiPreturi {
    String id;
    String preturi;
    String servicii;
    Button update;

    public EditareServiciiPreturi(String id, String preturi, String servicii, Button update)  {
        this.id = id;
        this.preturi=preturi;
        this.servicii=servicii;
        this.update=update;
        update.setOnAction(e-> {
           /* for(EditareServiciiPreturi user: PaginaManagerEditareServiciiPreturi.editareserviciipreturi){
                if(user.getUpdate()==update){
                    System.out.println("id:"+ user.getId());
                    System.out.println("preturi:"+ user.getPreturi());
                    System.out.println("servicii:"+ user.getServicii());


                }
            }
*/
          ObservableList<EditareServiciiPreturi> users=  PaginaManagerEditareServiciiPreturi.table_2.getSelectionModel().getSelectedItems();
            for(EditareServiciiPreturi user: users){
                if(user.getUpdate()==update){
                    System.out.println("id:"+ user.getId());
                   // users.addAll(new EditareServiciiPreturi(user.getId(), user.getPreturi(), user.getServicii(), new Button("update")));
                    System.out.println("preturi:"+ user.getPreturi());
                    System.out.println("servicii:"+ user.getServicii());


                }
            }
        });
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Button getUpdate() {  return update; }

    public void setUpdate(Button update) { this.update = update; }
}