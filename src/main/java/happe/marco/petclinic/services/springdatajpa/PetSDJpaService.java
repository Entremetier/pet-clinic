package happe.marco.petclinic.services.springdatajpa;

import happe.marco.petclinic.model.Owner;
import happe.marco.petclinic.model.Pet;
import happe.marco.petclinic.repositories.OwnerRepository;
import happe.marco.petclinic.repositories.PetRepository;
import happe.marco.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetSDJpaService(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        //Methodenreferenz, inner anonym wird im VetSDJpaService gezeigt
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        //erklärung befindet sich in OwnerSDJpaService
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        Owner owner = new Owner();
        Long id = owner.getId();
        if (id.equals(null)){
            return petRepository.save(null);
        } else {

            return petRepository.save(object);
        }
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
