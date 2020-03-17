package happe.marco.petclinic.services.map;

import happe.marco.petclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyMapServiceTest {

    SpecialtyMapService service;
    final Long specialtyId = 1L;

    @BeforeEach
    void setUp() {
        service = new SpecialtyMapService();
        Speciality speciality = new Speciality();
        speciality.setId(specialtyId);
        service.save(speciality);
    }

    @Test
    void findAll() {
        Set<Speciality> specialitySet = service.findAll();
        assertEquals(1, specialitySet.size());
    }

    @Test
    void findById() {
        Speciality speciality = service.findById(specialtyId);
        assertEquals(specialtyId, speciality.getId());
    }

    @Test
    void deleteById() {
        service.deleteById(specialtyId);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void delete() {
        Speciality speciality = new Speciality();
        service.delete(speciality);
        assertEquals(1, service.findAll().size());
    }

    @Test
    void saveExistingId() {
        Speciality speciality = new Speciality();
        speciality.setId(2L);
        Speciality savedSpeciality = service.save(speciality);
        assertEquals(speciality.getId(), savedSpeciality.getId());
    }

    @Test
    void saveNoId() {
        Speciality speciality = service.save(Speciality.builder().build());
        assertNotNull(speciality);
        assertNotNull(speciality.getId());
    }
}