package fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.entities;

import fr.epsi.b3devc1.sylvainmjc.springtpevalpetstore.enums.FishLivEnv;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "fish")
public class Fish extends Animal {

    @Column(name="living_env")
    private FishLivEnv livingEnv;

    public Fish() {
        super();
    }

    public Fish(Date birth, String color, FishLivEnv livingEnv) {
        super(birth, color);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }


    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", birth=" + birth +
                ", color='" + color + '\'' +
                ", petStore=" + petStore +
                ", livingEnv=" + livingEnv +
                '}';
    }
}