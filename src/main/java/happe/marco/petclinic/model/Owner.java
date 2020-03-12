package happe.marco.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
//die tabelle in der Datenbank bekommt den Namen "owners"
public class Owner extends Person {

    @Builder
    //bis hier her sind alle annotationen von lombok getter und setter werden ersetzt ein leere Konstruktor wird erzeugt
    //ein Konstruktor mit allen eigenschaften wird erzeugt Builder ist für die funktionalität, objekterstellung ist einfacher.
    //@NoArgsConstructor und @AllArgsConstructor gibt die möglichkeit für den builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "adress")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    //One Owner kann many pets haben, darum die @OneToMany annotation
    //CascadeType.ALL bedeutet das wenn ich einen Owner lösche, werden auch gleichzeitig die dazugehörigen Tiere gelöscht. Die Cascade reicht also weiter
    //nach unten und löscht alle dazugehörigen Entities.
    private Set<Pet> pets = new HashSet<>();
}

