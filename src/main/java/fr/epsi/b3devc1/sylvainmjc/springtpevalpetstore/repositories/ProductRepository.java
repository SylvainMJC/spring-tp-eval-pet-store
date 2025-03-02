package fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.repositories;

import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
