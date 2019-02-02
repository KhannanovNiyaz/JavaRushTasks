package com.javarush.task.task08.task0820;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> dogResult = new HashSet<>();
        dogResult.add(new Dog());
        dogResult.add(new Dog());
        dogResult.add(new Dog());

        //напишите тут ваш код
        return dogResult;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet<Object> animals = new HashSet<>();
        animals.addAll(cats);
        animals.addAll(dogs);
        //напишите тут ваш код
        return animals;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        pets.removeAll(cats);
        //напишите тут ваш код
    }

    public static void printPets(Set<Object> pets) {
        for (Object dog : pets) {
            System.out.println(dog);
        }

        //напишите тут ваш код
    }

    public static class Cat{
        public Cat() {
        }
    }

    public static class Dog {
        public Dog() {
        }
    }
        //напишите тут ваш код
}
