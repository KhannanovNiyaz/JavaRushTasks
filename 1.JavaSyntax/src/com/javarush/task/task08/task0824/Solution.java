package com.javarush.task.task08.task0824;

/* 
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
Требования:
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки,
две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
       // Human grandMother = new Human("grandMother", true, "54", "Father", "mother");
        Human childBart = new Human("Bart", true, "12");
        Human childLiza = new Human("Liza", false, "10");
        Human childMaggy = new Human("Maggy", false, "5");
        ArrayList<Human> child = new ArrayList<Human>();
        child.add(childBart);
        child.add(childLiza);
        child.add(childMaggy);
        Human fatherGomer = new Human("Gomer", true, "30", child);
        Human motherMarth = new Human("Marth", false, "28", child);
        ArrayList<Human> childParrentGomer = new ArrayList<Human>();
        ArrayList<Human> childParrentMarth = new ArrayList<Human>();
        childParrentGomer.add(fatherGomer);
        childParrentMarth.add(motherMarth);
        Human grandMotherMarth1 = new Human("grandMotherMarth1", false, "58", childParrentMarth);
        Human grandFatherGomer1 = new Human("grandFatherGomer1", true, "68", childParrentGomer);
        Human grandMotherMarth2 = new Human("grandMotherMarth2", false, "56", childParrentMarth);
        Human grandFatherGomer2 = new Human("grandFatherGomer2", true, "66", childParrentGomer);
        ArrayList<Human> parent = new ArrayList<>();
        parent.add(childBart);
        parent.add(childLiza);
        parent.add(childMaggy);
        parent.add(fatherGomer);
        parent.add(motherMarth);
        parent.add(grandMotherMarth1);
        parent.add(grandFatherGomer1);
        parent.add(grandMotherMarth2);
        parent.add(grandFatherGomer2);
        for (Human human : parent) {
            System.out.println(human);
        }



        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        String age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, String age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, String age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
