package happe.marco.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
//auch diese Klasse wird nicht in der Datenbank als Entity erstellt sondern andere Klassen erben von ihr.
public class Person extends BaseEntity {

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    //@Column zeigt JPA das wir hieraus eine Spalte in der Datenbank erstellen werden
    //(name = "first_name") zeigt JPA das der Name dieser Spalte "first_name" sein wird. Die snake-case mit dem Unterstrich ist per default
    //eingestellt, trotzdem ist es vorteilhaft es noch mal zu erwähnen.
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
