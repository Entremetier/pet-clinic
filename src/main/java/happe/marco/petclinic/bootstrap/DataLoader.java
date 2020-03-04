package happe.marco.petclinic.bootstrap;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import happe.marco.petclinic.model.Owner;
import happe.marco.petclinic.model.Pet;
import happe.marco.petclinic.model.PetType;
import happe.marco.petclinic.model.Vet;
import happe.marco.petclinic.services.OwnerService;
import happe.marco.petclinic.services.PetTypeService;
import happe.marco.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Bart");
        owner1.setLastName("Simpson");
        owner1.setAddress("742 Evergreen Terrace");
        owner1.setCity("Springfield");
        owner1.setTelephone("9395550113");

        Pet bartsPet = new Pet();
        bartsPet.setPetType(savedDogPetType);
        bartsPet.setOwner(owner1);
        bartsPet.setBirthdate(LocalDate.now());
        bartsPet.setName("Santas Little Helper");
        owner1.getPets().add(bartsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lisa");
        owner2.setLastName("Simpson");
        owner2.setAddress("742 Evergreen Terrace");
        owner2.setCity("Springfield");
        owner2.setTelephone("9395550113");

        Pet lisasPet = new Pet();
        lisasPet.setPetType(savedCatPetType);
        lisasPet.setOwner(owner2);
        lisasPet.setBirthdate(LocalDate.now());
        lisasPet.setName("Snowball II");
        owner2.getPets().add(lisasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dr. Nick");
        vet1.setLastName("Rivera");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr. Julius");
        vet2.setLastName("Hibbert");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
