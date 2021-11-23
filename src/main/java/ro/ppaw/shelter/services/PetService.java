package ro.ppaw.shelter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ppaw.shelter.exceptions.UserNotFoundException;
import ro.ppaw.shelter.model.pet.Pet;
import ro.ppaw.shelter.repositories.PetRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PetService {

    private final PetRepository petRepo;

    @Autowired
    public PetService(PetRepository petRepo){
        this.petRepo = petRepo;
    }

    public Pet addPet(Pet pet){
        //pet.setId(UUID.randomUUID().toString());
        return petRepo.save(pet);
    }

    public List<Pet> findAllPets(){
        return petRepo.findAll();
    }

    public Pet updatePet(Pet pet){
        return petRepo.save(pet);
    }

    public void deletePet(Long id){
        petRepo.deletePetById(id);
    }

    public Pet findPetById(Long id){
        return petRepo.findPetById(id).orElseThrow(() -> new UserNotFoundException("Pet with id " + id + " not found"));
    }

}
