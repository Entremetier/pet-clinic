package happe.marco.petclinic.bootstrap;

import happe.marco.petclinic.model.Owner;
import happe.marco.petclinic.model.Vet;
import happe.marco.petclinic.services.OwnerService;
import happe.marco.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Marco");
        owner1.setLastName("Happe");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Lisa");
        owner2.setLastName("Simpson");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Dr. Nick");
        vet1.setLastName("Rivera");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Dr. Julius");
        vet1.setLastName("Hibbert");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
