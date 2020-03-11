package happe.marco.petclinic.services.springdatajpa;

import happe.marco.petclinic.model.PetType;
import happe.marco.petclinic.repositories.PetTypeRepository;
import happe.marco.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Service
@Profile(value = "springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(new Consumer<PetType>() {
            @Override
            public void accept(PetType petType) {
                petTypes.add(petType);
            }
        });
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        //erklärung befindet sich in OwnerSDJpaService
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
