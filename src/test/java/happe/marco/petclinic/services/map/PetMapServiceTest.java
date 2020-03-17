package happe.marco.petclinic.services.map;

import happe.marco.petclinic.model.Pet;
import happe.marco.petclinic.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Period;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService petMapService;

    final Long id = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();

        Pet pet = new Pet();
        pet.setId(id);
        petMapService.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petMapService.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    void findById() {
        Pet pet = petMapService.findById(id);
        assertEquals(id, pet.getId());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(id);

        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void delete() {
        Pet pet = new Pet();

        petMapService.delete(pet);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Pet pet = new Pet();
        pet.setId(2L);
        Pet savedPet = petMapService.save(pet);
        assertEquals(pet.getId(), savedPet.getId());
    }

    @Test
    void saveNoId() {
        Pet savedPet = petMapService.save(Pet.builder().build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }
}