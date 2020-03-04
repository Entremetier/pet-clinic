package happe.marco.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> getSpecialties = new HashSet<>();

    public Set<Speciality> getGetSpecialties() {
        return getSpecialties;
    }

    public void setGetSpecialties(Set<Speciality> getSpecialties) {
        this.getSpecialties = getSpecialties;
    }
}
