package happe.marco.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Builder
    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        this.visits = visits;
    }

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    //One Pet kann Many visits haben, mapped wird es durch die Pet pet eigenschaft in Visit
    //wird das Pet aus der Datenbank gelöscht werden auch die visits des Pet's gelöscht (cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();

}
