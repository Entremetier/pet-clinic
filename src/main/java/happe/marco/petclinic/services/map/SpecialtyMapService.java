package happe.marco.petclinic.services.map;

import com.sun.xml.bind.v2.model.core.ID;
import happe.marco.petclinic.model.Speciality;
import happe.marco.petclinic.services.SpecialtyService;

import java.util.Set;

public class SpecialtyMapService extends AbstractMapService<Speciality, Long> implements SpecialtyService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
