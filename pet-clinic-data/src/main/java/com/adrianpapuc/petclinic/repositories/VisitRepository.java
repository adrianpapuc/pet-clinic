package com.adrianpapuc.petclinic.repositories;

import com.adrianpapuc.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
