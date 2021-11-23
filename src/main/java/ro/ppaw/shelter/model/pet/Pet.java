package ro.ppaw.shelter.model.pet;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String species;
    private String dateBirth;
    private Character sex;
    private String imageUrl;

    public Pet() {}

    public Pet(Long id, String name, String species, String dateBirth, String imageUrl, Character sex) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.dateBirth = dateBirth;
        this.imageUrl = imageUrl;
        this.sex = sex;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", sex=" + sex +
                '}';
    }
}
