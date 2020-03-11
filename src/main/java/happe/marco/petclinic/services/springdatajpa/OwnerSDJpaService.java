package happe.marco.petclinic.services.springdatajpa;

import happe.marco.petclinic.model.Owner;
import happe.marco.petclinic.repositories.OwnerRepository;
import happe.marco.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Service
@Profile(value = "springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(new Consumer<Owner>() {
            @Override
            public void accept(Owner owner) {
                owners.add(owner);
            }
        });
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {

        //Möglichkeit Nummer 1:
            //die abfrage wird mit einer if-else abfrage gemacht

//       Optional<Owner> owner = ownerRepository.findById(aLong);
//        if (owner.isPresent()){
//            return owner.get();
//        } else {
//            return null;
//        }

        //Möglichkeit Nummer 2:
            //die if-else abfrage wird wird im return statement gemacht über die methode orElse(), welche bei Optional
            //zur verfügung steht

//        Optional<Owner> owner = ownerRepository.findById(aLong);
//        return owner.orElse(null);

        //Möglichkeit Nummer 3:
            //im return statement wird die gesuchte ID zurückgegeben oder der Wert null wird zurückgegeben

        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
