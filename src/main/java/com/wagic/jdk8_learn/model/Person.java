package com.wagic.jdk8_learn.model;

public class Person {

    private String firstName;

    private String secondName;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Person() {
    }
}
