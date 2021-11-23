package ro.ppaw.shelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ppaw.shelter.model.pet.Pet;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    //@Query("SELECT p.id, p.name, p.species, p.dateBirth, p.sex FROM pet p WHERE p.id = :id")
    //Optional<Pet> getById(@Param("id") Long id);


    void deletePetById(Long id);

    Optional<Pet> findPetById(Long id);
}
