package fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cat")
public class Cat extends Animal{

    @Column(name = "chip_id")
    private String chipId;


    public Cat() {
        super();
    }

    public Cat(Date birth, String color, String chipId) {
        super(birth, color);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", birth=" + birth +
                ", color='" + color + '\'' +
                ", petStore=" + petStore +
                ", chipId=" + chipId +
                '}';
    }
}
