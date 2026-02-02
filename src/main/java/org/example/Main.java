/*Kreirati novi Java projekt koji će koristiti radne okvire Hibernate i JPA
i implementirati primjer veze „1:N” s entitetima „Jelo” (engl. Meal) i sastojci (engl. Ingredients)

  Klasa „Meal” mora sadržavati identifikator „Long id” i naziv „String name” te listu objekata klase „Ingredient” te anotaciju „@OneToMany”

Klasa „Ingredient” mora sadržavati identifikator „Long id” i naziv „String name” i
objekt klase „Meal” kojem pripada taj sastojak označen s anotacijama „@ManyToOne” i „@JoinColumn”

Kreirati i glavnu klasu koja sprema objekt klase „Meal” zajedno s nekoliko sastojaka.
Napisati upit koji će dohvaćati podatke o svim jelima.*/


package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.Ingredients;
import org.example.model.Meal;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Meal meal1 = new Meal();
            meal1.setName("Pašticada");
            em.persist(meal1);

            Ingredients ingredient1 = new Ingredients();
            ingredient1.setName("Govedina");
            ingredient1.setMeal(meal1);
            meal1.getIngredients().add(ingredient1);
            em.persist(ingredient1);

            Ingredients ingredient2 = new Ingredients();
            ingredient2.setName("Šljiva");
            ingredient2.setMeal(meal1);
            meal1.getIngredients().add(ingredient2);
            em.persist(ingredient2);

            Ingredients ingredient3 = new Ingredients();
            ingredient3.setName("Vino");
            ingredient3.setMeal(meal1);
            meal1.getIngredients().add(ingredient3);
            em.persist(ingredient3);

            Ingredients ingredient4 = new Ingredients();
            ingredient4.setName("Panceta");
            ingredient4.setMeal(meal1);
            meal1.getIngredients().add(ingredient4);
            em.persist(ingredient4);

            Meal meal2 = new Meal();
            meal2.setName("Pizza");
            em.persist(meal2);

            Ingredients ingredient5 = new Ingredients();
            ingredient5.setName("Brašno");
            ingredient5.setMeal(meal2);
            meal2.getIngredients().add(ingredient5);
            em.persist(ingredient5);

            Ingredients ingredient6 = new Ingredients();
            ingredient6.setName("Passata");
            ingredient6.setMeal(meal2);
            meal2.getIngredients().add(ingredient6);
            em.persist(ingredient6);

            Ingredients ingredient7 = new Ingredients();
            ingredient7.setName("Sir");
            ingredient7.setMeal(meal2);
            meal2.getIngredients().add(ingredient7);
            em.persist(ingredient7);

            Ingredients ingredient8 = new Ingredients();
            ingredient8.setName("Šunka");
            ingredient8.setMeal(meal2);
            meal2.getIngredients().add(ingredient8);
            em.persist(ingredient8);

            tx.commit();


            //Dohvatiti knjige iz baze
            List<Meal> sMeal = em.createQuery("select m from Meal m", Meal.class).getResultList();
            for (Meal m : sMeal) {
                System.out.println("\nJelo: " + m.getName());
                System.out.println("Sastojci: ");
                for (Ingredients ingredient : m.getIngredients()) {
                    System.out.println(" -" + ingredient.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        em.close();
        emf.close();

    }
}

