package happe.marco.petclinic.services.springdatajpa;

import happe.marco.petclinic.model.Vet;
import happe.marco.petclinic.repositories.VetRepository;
import happe.marco.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Service
@Profile(value = "springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(new Consumer<Vet>() {
            @Override
            public void accept(Vet vet) {
                vets.add(vet);
            }
        });
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        //erklärung befindet sich in OwnerSDJpaService
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
