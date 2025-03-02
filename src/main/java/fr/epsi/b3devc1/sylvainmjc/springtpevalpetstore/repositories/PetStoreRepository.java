package fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.repositories;

import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.entities.PetStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetStoreRepository extends JpaRepository<PetStore, Integer> {
    // find a pet store by its id
    PetStore findOneById(Long id);
}
