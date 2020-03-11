package happe.marco.petclinic.bootstrap;

import happe.marco.petclinic.model.*;
import happe.marco.petclinic.services.OwnerService;
import happe.marco.petclinic.services.PetTypeService;
import happe.marco.petclinic.services.SpecialtyService;
import happe.marco.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    //beim persistieren von Daten muss die Methode aufgerufen werden, da sonst die Daten immer wieder in die Datenbank
    //geschrieben werden, darum mit der if abfrage sicherstellen das die daten noch nicht in der db sind
    //wenn count 0 ist wird die methode aufgerufen, sonst nicht

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescribtion("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescribtion("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescribtion("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Bart");
        owner1.setLastName("Simpson");
        owner1.setAddress("742 Evergreen Terrace");
        owner1.setCity("Springfield");
        owner1.setTelephone("9395550113");

        Pet bartsPet = new Pet();
        bartsPet.setPetType(savedDogPetType);
        bartsPet.setOwner(owner1);
        bartsPet.setBirthDate(LocalDate.now());
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
        lisasPet.setBirthDate(LocalDate.now());
        lisasPet.setName("Snowball II");
        owner2.getPets().add(lisasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dr. Nick");
        vet1.setLastName("Rivera");
        vet1.getSpecialties().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr. Julius");
        vet2.setLastName("Hibbert");
        vet2.getSpecialties().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
