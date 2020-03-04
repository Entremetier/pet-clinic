package happe.marco.petclinic.bootstrap;

import happe.marco.petclinic.model.Owner;
import happe.marco.petclinic.model.PetType;
import happe.marco.petclinic.model.Vet;
import happe.marco.petclinic.services.OwnerService;
import happe.marco.petclinic.services.PetTypeService;
import happe.marco.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        PetType marcosDog = new PetType();
        marcosDog.setName("Senta");
        PetType savedMarcosDog = petTypeService.save(marcosDog);

        PetType lisasCat = new PetType();
        lisasCat.setName("Snowball");
        PetType savedLisasCat = petTypeService.save(lisasCat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Marco");
        owner1.setLastName("Happe");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lisa");
        owner2.setLastName("Simpson");

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
