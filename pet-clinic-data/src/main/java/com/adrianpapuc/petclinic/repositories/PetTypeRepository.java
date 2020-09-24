package com.adrianpapuc.petclinic.repositories;

import com.adrianpapuc.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
