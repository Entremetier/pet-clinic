package happe.marco.petclinic.services.map;

import happe.marco.petclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeMapServiceTest {

    PetTypeMapService petTypeMapService;

    final Long petTypeId = 1L;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();

        PetType petType = new PetType();
        petType.setId(petTypeId);
        petTypeMapService.save(petType);
    }

    @Test
    void findAll() {
        Set<PetType> petTypeSet = petTypeMapService.findAll();
        assertEquals(1, petTypeSet.size());
    }

    @Test
    void findById() {
        PetType petType = petTypeMapService.findById(petTypeId);
        assertEquals(petTypeId, petType.getId());
    }

    @Test
    void deleteById() {
        petTypeMapService.deleteById(petTypeId);
        assertEquals(0, petTypeMapService.findAll().size());
    }

    @Test
    void delete() {
        petTypeMapService.delete(PetType.builder().build());
        assertEquals(1, petTypeMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        PetType petType = new PetType();
        petType.setId(2L);
        PetType savedPetType = petTypeMapService.save(petType);

        assertEquals(petType.getId(), savedPetType.getId());
    }

    @Test
    void saveNoId() {
        PetType petType = petTypeMapService.save(PetType.builder().build());
        assertNotNull(petType);
        assertNotNull(petType.getId());
    }
}