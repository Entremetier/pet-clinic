package happe.marco.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    //(fetch = FetchType.EAGER) bei default ist bei Many Beziehungen der fetchType auf LAZY gesetzt. Das bedeutet es werden nur dann alle Daten
    //geladen wenn explizit danach gefragt wurde. Bei EAGER werden alle Daten direkt geladen. In diesem Fall würden die specialties nicht geladen
    //werden und mit null angegeben werden.
    //@JoinTable ist eine spezielle  Tabelle. Die Entities haben ihre Beziehung untereinander, aber die Datenbank hat eine Tabelle die ID's von
    //beiden Seiten der Beziehung definiert. Es wird eine gemeinsame Tabelle erzeugt, ein Name angegeben (name = "vet_specialties")
    //Durch joinColumns wird festgelegt welchen Namen die Spalte von dieser Seite der Beziehung erhält.
    //Durch inverseJoinColumns wird festgelegt welchen Namen die Spalte der gegenseite der Beziehung bekommt. Beides wird in einer Tabelle
    //zusammengeführt (@JoinTable).
    private Set<Speciality> specialties = new HashSet<>();
}
