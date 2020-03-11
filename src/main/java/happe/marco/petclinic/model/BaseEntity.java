package happe.marco.petclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
//@MappedSuperclass zeigt in JPA an das es sich um eine Baseclass handelt und das andere Klassen von dieser Klasse erben werden.
//Gleichzeitig sagen wir JPA das diese Klasse nicht zur Datenbank hinzugefügt werden muss.
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
