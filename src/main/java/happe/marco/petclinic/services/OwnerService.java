package happe.marco.petclinic.services;

import happe.marco.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
