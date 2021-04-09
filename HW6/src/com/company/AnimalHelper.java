package com.company;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by maxim on 09.04.2021.
 */
public class AnimalHelper {

    private SessionFactory sessionFactory;

    public AnimalHelper() {
        sessionFactory = HibernateUtil.getFactory();
    }

    public List<Animal> getAnimalList(){

        Session session = sessionFactory.openSession();

        Criteria cb = session.createCriteria(Animal.class);

        List<Animal> animalList = cb.list();

        session.close();

        return animalList;
    }

    public Animal getAnimalById(long id) {
        Session session = sessionFactory.openSession();
        Animal animal = (Animal) session.get(Animal.class, id);
        session.close();
        return animal;
    }

    public Animal addAnimal(Animal animal){

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(animal);

        session.getTransaction().commit();

        session.close();

        return animal;

    }
}
