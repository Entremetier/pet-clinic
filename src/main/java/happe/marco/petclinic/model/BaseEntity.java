package happe.marco.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private Long id;
    // Long wird als boxtype verwendet und nicht als primitiver datentyp long (dieses vorgehen wird von hibernate empfohlen da ein
    // boxtype  null sein kann und ein primitver Datentyp kann es nicht)

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}
