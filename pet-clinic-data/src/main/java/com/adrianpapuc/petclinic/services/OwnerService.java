package com.adrianpapuc.petclinic.services;

import com.adrianpapuc.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
