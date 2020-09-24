package com.adrianpapuc.petclinic.repositories;

import com.adrianpapuc.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
