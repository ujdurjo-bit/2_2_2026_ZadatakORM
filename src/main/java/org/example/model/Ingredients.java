/*Klasa „Ingredient” mora sadržavati identifikator „Long id” i naziv „String name” i
objekt klase „Meal” kojem pripada taj sastojak označen s anotacijama „@ManyToOne” i „@JoinColumn”*/

package org.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn (name = "meal_id")
    private Meal meal;

    public Ingredients() {
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

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}

