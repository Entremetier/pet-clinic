package happe.marco.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//auch diese Klasse wird nicht in der Datenbank als Entity erstellt sondern andere Klassen erben von ihr.
public class Person extends BaseEntity {

    @Column(name = "first_name")
    //@Column zeigt JPA das wir hieraus eine Spalte in der Datenbank erstellen werden
    //(name = "first_name") zeigt JPA das der Name dieser Spalte "first_name" sein wird. Die snake-case mit dem Unterstrich ist per default
    //eingestellt, trotzdem ist es vorteilhaft es noch mal zu erwähnen.
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
