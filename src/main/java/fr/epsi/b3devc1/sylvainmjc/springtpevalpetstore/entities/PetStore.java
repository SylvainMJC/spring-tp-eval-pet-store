package fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet_store")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_name")
    private String managerName;

    @OneToMany(mappedBy = "petStore")
    private List<Animal> animals;

    @OneToOne
    private Address address;

    @ManyToMany
    @JoinTable(name = "product_petstore",
            joinColumns = @JoinColumn(name = "petstore_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;


    public PetStore() {
    }

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
