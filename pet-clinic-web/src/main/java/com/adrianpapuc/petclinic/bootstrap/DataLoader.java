package com.adrianpapuc.petclinic.bootstrap;

import com.adrianpapuc.petclinic.model.*;
import com.adrianpapuc.petclinic.services.OwnerService;
import com.adrianpapuc.petclinic.services.PetTypeService;
import com.adrianpapuc.petclinic.services.SpecialtyService;
import com.adrianpapuc.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count==0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Adrian");
        owner1.setLastName("Papuc");
        owner1.setAdress("123 Street");
        owner1.setCity("Miami");
        owner1.setTehephone("55512368754");

        Pet adriansPet = new Pet();
        adriansPet.setPetType(savedDogPetType);
        adriansPet.setOwner(owner1);
        adriansPet.setBirthDate(LocalDate.now());
        adriansPet.setName("Toto");
        owner1.getPets().add(adriansPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ion");
        owner2.setLastName("Popescu");
        owner2.setAdress("456 South Street");
        owner2.setCity("New York");
        owner2.setTehephone("55578347863");

        Pet IonsCat = new Pet();
        IonsCat.setPetType(savedCatPetType);
        IonsCat.setOwner(owner2);
        IonsCat.setBirthDate(LocalDate.now());
        IonsCat.setName("Just a cat");
        owner2.getPets().add(IonsCat);

        ownerService.save(owner2);

        System.out.println("Loaded owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Alexandru");
        vet1.setLastName("Moldovan");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vet2.getSpecialties().add(savedDentistry);
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
