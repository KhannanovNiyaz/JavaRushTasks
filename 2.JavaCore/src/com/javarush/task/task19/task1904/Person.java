package com.javarush.task.task19.task1904;

import java.util.Date;

public class Person {
    private String firstName; //имя
    private String middleName;  //второе имя
    private String lastName;  //Фамилия
    private Date birthDate;

    //Иванов Иван Иванович 31 12 1950

    public Person(String firstName, String middleName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", lastName, firstName, middleName, birthDate.toString());
    }
}
