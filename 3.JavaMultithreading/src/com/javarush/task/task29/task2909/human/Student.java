package com.javarush.task.task29.task2909.human;
/*

.*/

import java.util.Date;

public class Student extends UniversityPerson {
    private int course;
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;

//    public Student(String name, int age, double averageGrade) {
//        super(false);
//        this.name = name;
//        this.age = age;
//        this.averageGrade = averageGrade;
//    }


//    public Student(String name, int age, double averageGrade) {
//        super(name, age);
//        this.averageGrade = averageGrade;
//    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.setAverageGrade(averageGrade);
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade() + delta);
    }
//    public void incAverageGradeBy01() {
//        setAverageGrade(getAverageGrade() + 0.1);
//    }
//
//    public void incAverageGradeBy02() {
//        setAverageGrade(getAverageGrade() + 0.2);
//    }

    //    public void setValue(String name, double value) {
//        if (name.equals("averageGrade")) {
//            averageGrade = value;
//            return;
//        }
//        if (name.equals("course")) {
//            course = (int) value;
//            return;
//        }
//    }
//
//    public void setBeginningOfSession(int day, int month, int year) {
//        beginningOfSession = new Date(year, month, day);
//    }
//
//    public void setEndOfSession(int day, int month, int year) {
//        endOfSession = new Date(year, month, day);
//    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

//    public void fight() {
//    }
}

