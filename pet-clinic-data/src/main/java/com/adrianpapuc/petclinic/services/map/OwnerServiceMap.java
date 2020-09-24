package com.adrianpapuc.petclinic.services.map;

import com.adrianpapuc.petclinic.model.Owner;
import com.adrianpapuc.petclinic.model.Pet;
import com.adrianpapuc.petclinic.services.OwnerService;
import com.adrianpapuc.petclinic.services.PetService;
import com.adrianpapuc.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner,Long>  implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object == null)
            return null;

        if (object.getPets() != null){
            object.getPets().forEach(pet ->{
                // Check if pet has pet type
                if (pet.getPetType() != null){
                    //Check if pet's type is a new type
                    if (pet.getPetType().getId() == null){
                        //save the new pet type
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                }else{
                    throw new RuntimeException("Pet Type is required");
                }
                if (pet.getId() == null){
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
