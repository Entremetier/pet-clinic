package happe.marco.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
//die tabelle in der Datenbank bekommt den Namen "owners"
public class Owner extends Person {

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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
