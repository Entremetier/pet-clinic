package happe.marco.petclinic.services.map;

import happe.marco.petclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetMapServiceTest {

    VetMapService service;

    final Long vetId = 1L;

    @BeforeEach
    void setUp() {

        service = new VetMapService(new SpecialtyMapService());

        Vet vet = new Vet();
        vet.setId(vetId);
        service.save(vet);

    }

    @Test
    void findAll() {
        Set<Vet> vetSet = service.findAll();
        assertEquals(1, vetSet.size());
    }

    @Test
    void findById() {
        Vet vet = service.findById(vetId);
        assertEquals(vetId, vet.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(vetId);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void delete() {
        Vet vet = Vet.builder().build();
        service.delete(vet);
        assertEquals(1, service.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Vet vet = new Vet();
        vet.setId(id);
        service.save(vet);
        assertEquals(id, vet.getId());
    }

//    @Test
//    void saveNoId() {
//        Vet vet = service.save(Vet.builder().build());
//        assertNotNull(vet);
//        assertNotNull(vet.getId());
//    }
}