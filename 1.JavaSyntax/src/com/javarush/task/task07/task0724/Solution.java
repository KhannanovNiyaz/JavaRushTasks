package com.javarush.task.task07.task0724;

/* 
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
6. Выведи созданные объекты на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Human father1 = new Human("QWer1", true, 23);
        Human father2 = new Human("QWer2", true, 24);
        Human mother1 = new Human("QWer3", false, 25);
        Human mother2 = new Human("QWer4", false, 26);

        Human child1 = new Human("Qwerty1", true, 76, father1, mother1);
        Human child2 = new Human("Qwerty2", false, 76, father1, mother2);
        Human child3 = new Human("Qwerty3", true, 76, father2, mother1);
        Human child4 = new Human("Qwerty4", false, 76, father2, mother2);
        Human child5 = new Human("Qwerty5", true, 76, father1, mother1);

        System.out.println(father1.toString());
        System.out.println(father2.toString());
        System.out.println(mother1.toString());
        System.out.println(mother2.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
        System.out.println(child4.toString());
        System.out.println(child5.toString());
        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















