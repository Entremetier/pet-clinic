package happe.marco.petclinic.services.map;

import happe.marco.petclinic.model.Speciality;
import happe.marco.petclinic.model.Vet;
import happe.marco.petclinic.services.SpecialtyService;
import happe.marco.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Consumer;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialties().size() > 0){
            object.getSpecialties().forEach(new Consumer<Speciality>() {
                @Override
                public void accept(Speciality speciality) {
                    if (speciality.getId() == null) {
                        Speciality savedSpecialty = specialtyService.save(speciality);
                        speciality.setId(savedSpecialty.getId());
                    }
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}