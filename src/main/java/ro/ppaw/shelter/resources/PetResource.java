package ro.ppaw.shelter.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ppaw.shelter.model.pet.Pet;
import ro.ppaw.shelter.services.PetService;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetResource {
    private final PetService petService;

    public PetResource(PetService petService){
        this.petService = petService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> pets = petService.findAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") Long id){
        Pet pet = petService.findPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet){
        Pet newPet = petService.addPet(pet);
        return new ResponseEntity<>(newPet, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Pet> editPet(@RequestBody Pet pet){
        Pet editPet = petService.updatePet(pet);
        return new ResponseEntity<>(editPet, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Pet> editPetById(@PathVariable("id") Long id, @RequestBody Pet newPet){
        Pet oldPet = petService.findPetById(id);
        //Pet editPet = petService.updatePet(pet);

        /*Pet editPet = petService.findPetById(id).map(pet -> {

                })*/
        return new ResponseEntity<>(oldPet, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id){
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
