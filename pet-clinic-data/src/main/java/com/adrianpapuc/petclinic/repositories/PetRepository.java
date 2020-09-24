package com.adrianpapuc.petclinic.repositories;

import com.adrianpapuc.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
