package fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.repositories;

import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
