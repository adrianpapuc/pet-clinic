package com.adrianpapuc.petclinic.bootstrap;

import com.adrianpapuc.petclinic.model.Owner;
import com.adrianpapuc.petclinic.model.Pet;
import com.adrianpapuc.petclinic.model.PetType;
import com.adrianpapuc.petclinic.model.Vet;
import com.adrianpapuc.petclinic.services.OwnerService;
import com.adrianpapuc.petclinic.services.PetTypeService;
import com.adrianpapuc.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


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
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vetService.save(vet2);

        System.out.println("Loaded vets....");


    }
}
