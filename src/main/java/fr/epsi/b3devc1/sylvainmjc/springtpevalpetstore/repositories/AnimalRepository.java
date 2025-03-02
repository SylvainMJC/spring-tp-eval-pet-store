package fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.repositories;

import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.entities.Animal;
import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.entities.PetStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    //find all animals of a specific pet store
    List<Animal> findByPetStore(PetStore petStore);
}
