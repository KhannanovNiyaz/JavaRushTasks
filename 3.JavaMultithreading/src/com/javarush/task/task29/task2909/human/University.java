package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {

//    public University(String name, int age) {
//        super(name, age, 0);
//    }

    //
//    public University(int age, String name) {
//        super(age, name, 0);
//    }
    protected int age;
    protected String name;

    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

//    public University(String name, int age, double averageGrade) {
//        super(name, age, averageGrade);
//    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
       return students.stream().max(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }

    public Student getStudentWithMinAverageGrade() {
        return students.stream().min(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }

//    public void getStudentWithMinAverageGradeAndExpel() {
//
//
//        //TODO:
//    }

    public void expel(Student student) {
         students.remove(student);
    }
}
/*
6.2. Добавление параметра. Добавить параметр с типом double в метод getStudentWithAverageGrade(), чтобы было понятно
с каким средним балом нужен студент.Реализуй метод getStudentWithAverageGrade().
6.3. Удаление параметра. Убери параметр из метода getStudentWithMaxAverageGrade().
Реализуй этот метод, он должен возвращать студента с максимальным средним балом.
6.4. Разделение запроса и модификатора. Раздели метод getStudentWithMinAverageGradeAndExpel на
Student getStudentWithMinAverageGrade() и void expel(Student student). Первый метод должен возвратить студента с минимальным
средним балом, а второй - отчислить переданного студента (удалять из списка students).

2. Необходимо добавить параметр с типом double в метод getStudentWithAverageGrade() класса University и реализовать метод.
3. Необходимо удалить параметр из метода getStudentWithMaxAverageGrade(double) класса University и реализовать метод.
4. Необходимо разделить метод getStudentWithMinAverageGradeAndExpel на Student getStudentWithMinAverageGrade() и
void expel(Student student) и реализовать эти два метода.*/