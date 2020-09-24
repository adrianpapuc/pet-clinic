package com.adrianpapuc.petclinic.repositories;

import com.adrianpapuc.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
