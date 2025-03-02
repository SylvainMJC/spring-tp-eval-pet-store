package fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore;

import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.entities.*;
import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.enums.FishLivEnv;
import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.enums.ProdType;
import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.repositories.AddressRepository;
import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.repositories.AnimalRepository;
import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.repositories.PetStoreRepository;
import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringTpEvalPetStoreApplication implements CommandLineRunner{

    private AnimalRepository animalRepository;

    private AddressRepository addressRepository;

    private PetStoreRepository petStoreRepository;

    private ProductRepository productRepository;

    @Autowired
    public SpringTpEvalPetStoreApplication(AnimalRepository animalRepository, AddressRepository addressRepository, PetStoreRepository petStoreRepository, ProductRepository productRepository) {
        this.animalRepository = animalRepository;
        this.addressRepository = addressRepository;
        this.petStoreRepository = petStoreRepository;
        this.productRepository = productRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringTpEvalPetStoreApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Animal dog = new Animal(new Date(),"Brown");
        Animal cat = new Cat(new Date(),"White", "123456789");
        Animal bird = new Animal(new Date(),"Black");
        Animal snake = new Animal(new Date(),"Green");
        Animal fish = new Fish(new Date(),"Blue", FishLivEnv.SEA_WATER);

        PetStore petStore1 = new PetStore("PetStore1", "John Doe");
        PetStore petStore2 = new PetStore("PetStore2", "Steve Jobs");
        PetStore petStore3 = new PetStore("PetStore3", "Donald Trump");

        dog.setPetStore(petStore1);
        cat.setPetStore(petStore2);
        bird.setPetStore(petStore2);
        snake.setPetStore(petStore3);
        fish.setPetStore(petStore3);

        Address address1 = new Address("1", "rue de la paix", "Paris", "75000");
        Address address2 = new Address("2", "rue de la victoire", "Lyon", "69000");
        Address address3 = new Address("3", "rue de la liberté", "Marseille", "13000");

        petStore1.setAddress(address1);
        petStore2.setAddress(address2);
        petStore3.setAddress(address3);

        Product dogFoodProduct = new Product("DF56", "Dog Food", ProdType.FOOD,20.99);
        Product catFoodProduct = new Product("CF56", "Cat Food", ProdType.FOOD,15.99);
        Product birdSeedProduct = new Product("BS56", "Bird Seed", ProdType.FOOD,10.99);

        Product dogToyProduct = new Product("DT56", "Dog Toy", ProdType.ACCESSORY, 5.99);
        Product catToyProduct = new Product("CT56", "Cat Toy", ProdType.ACCESSORY, 3.99);
        Product birdToyProduct = new Product("BT56", "Bird Toy", ProdType.ACCESSORY, 2.99);

        Product furBrushProduct = new Product("FB56", "Fur Brush", ProdType.CLEANING, 7.99);
        Product fishTankCleanerProduct = new Product("FTC56", "Fish Tank Cleaner", ProdType.CLEANING, 4.99);

        petStore1.setProducts(List.of(dogFoodProduct, dogToyProduct, furBrushProduct));
        petStore2.setProducts(List.of(catFoodProduct, catToyProduct, fishTankCleanerProduct));
        petStore3.setProducts(List.of(birdSeedProduct, birdToyProduct));

        petStoreRepository.saveAll(List.of(petStore1, petStore2, petStore3));
        animalRepository.saveAll(List.of(dog, cat, bird, snake, fish));
        addressRepository.saveAll(List.of(address1, address2, address3));
        productRepository.saveAll(List.of(dogFoodProduct, catFoodProduct, birdSeedProduct, dogToyProduct, catToyProduct, birdToyProduct, furBrushProduct, fishTankCleanerProduct));

        PetStore petstore = petStoreRepository.findOneById(1L);
        if(petstore != null) {
            System.out.println(" --- All animals of petStore with id = 1 : ---");
            List<Animal> animals = animalRepository.findByPetStore(petstore);
            animals.forEach(System.out::println);
        }

        petstore = petStoreRepository.findOneById(2L);
        if(petstore != null) {
            System.out.println(" --- All animals of petStore with id = 2 : ---");
            List<Animal> animals = animalRepository.findByPetStore(petstore);
            animals.forEach(System.out::println);
        }

        petstore = petStoreRepository.findOneById(3L);
        if(petstore != null) {
            System.out.println(" --- All animals of petStore with id = 3 : ---");
            List<Animal> animals = animalRepository.findByPetStore(petstore);
            animals.forEach(System.out::println);
        }
    }

}
