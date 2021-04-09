package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnimalHelper ah = new AnimalHelper();

        Animal lion = new Animal();

        lion.setId(2);
        lion.setAge(20);
        lion.setKindOfAnimal("lion");
        lion.setTail(true);


        ah.addAnimal(lion);

        List<Animal> animalList = ah.getAnimalList();

        for (int i = 0; i < animalList.size(); i++) {
            System.out.println(animalList.get(i).getId() + " " + animalList.get(i).getKindOfAnimal() + " " + animalList.get(i).getAge()+ " " +
                            animalList.get(i).isTail());
        }

        Animal tiger = ah.getAnimalById(1);

        System.out.println(tiger.getId() + " " + tiger.getKindOfAnimal() + " " + tiger.getAge() + " " + tiger.isTail());

    }
}
