package happe.marco.petclinic.services.map;

import com.sun.xml.bind.v2.model.core.ID;
import happe.marco.petclinic.model.Visit;
import happe.marco.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
        //Visit hat eine Pet eigenschaft und hier wird sichergestellt das sowohl das Pet als auch der Owner angelegt sind
        //sollte eine der abfragen negativ sein wird eine Exception geworfen
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
