package com.adrianpapuc.petclinic.services;

import com.adrianpapuc.petclinic.model.Owner;

import java.util.Set;

public interface OwnserService {

    Owner findByLastName(String lastName);

    Owner findById(long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
