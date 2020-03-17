package happe.marco.petclinic.services.map;

import happe.marco.petclinic.model.Owner;
import happe.marco.petclinic.model.Pet;
import happe.marco.petclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VisitMapServiceTest {

    VisitMapService service;
    OwnerMapService ownerMapService;
    PetMapService petMapService;

    Owner owner;
    Pet pet;
    Visit visit;

    final Long id = 1L;

    @BeforeEach
    void setUp() {
        service = new VisitMapService();
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        petMapService = new PetMapService();

        owner = new Owner();
        owner.setId(1L);
        ownerMapService.save(owner);

        pet = new Pet();
        pet.setId(2L);
        pet.setOwner(owner);
        petMapService.save(pet);

        visit = new Visit();
        visit.setId(id);
        visit.setPet(pet);
        service.save(visit);
    }

    @Test
    void findAll() {
        Set<Visit> visitSet = service.findAll();
        assertEquals(1, visitSet.size());
    }

    @Test
    void findById() {

       Visit savedVisit = service.findById(id);
       assertEquals(id, savedVisit.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(id);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void delete() {
        Visit visit = Visit.builder().build();
        service.delete(visit);
        assertEquals(1, service.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        visit.setId(id);
        service.save(visit);
        assertEquals(id, visit.getId());
    }
}