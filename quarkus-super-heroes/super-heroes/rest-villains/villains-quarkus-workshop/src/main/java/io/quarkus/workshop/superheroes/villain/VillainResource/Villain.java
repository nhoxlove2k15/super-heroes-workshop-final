package io.quarkus.workshop.superheroes.villain.VillainResource;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Random;

@Entity
public class Villain extends PanacheEntity {
    @NotNull
    @Size(min = 3, max = 50)
    public String name;

    public String otherName;

    @NotNull
    @Min(1)
    public int level;
    public String picture;

    @Column(columnDefinition = "TEXT")
    public String powers;

    @Override
    public String toString() {
        return "Villain{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", otherName='" + otherName + '\'' +
            ", level=" + level +
            ", picture='" + picture + '\'' +
            ", powers='" + powers + '\'' +
            '}';
    }

    public static Villain findRandom() {
        long countVillains = Villain.count();
        Random random = new Random();
        int randomVillain = random.nextInt((int) countVillains);
        return findAll().page(randomVillain,1).firstResult();

    }




}
