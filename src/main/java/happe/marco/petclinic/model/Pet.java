package happe.marco.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    //many Pets können einem Typ angehören (nicht gleichzeitig Hund und Katze sein)
    //in Pets wird es eine Spalte geben in der die "type_id" angegeben wird.
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    //Many Pet können zu One Owner gehören, es ist der gegenpart zum pets Set in Owner. Darum @ManyToOne annotation.
    //diese Owner Eigenschaft führt zurück auf das pets Set in Owner, welches durch "owner" gemapped wird
    //@JoinColumn(name = "owner_id"), damit JPA weiß wie das mapping stattfinden soll wird es eine "owner_id" im Pet Bericht geben.
    //Über "owner_id" sind diese beiden entities miteinander verbunden.
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
