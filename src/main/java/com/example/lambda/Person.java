package com.example.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String surName;
    private String GivenName;
    private int age;
    private Gender gender;
    private boolean isVendor;
    private List<Buying> buyings;
    private List<Selling> sellings;

    public boolean isFemale() {
        return gender == Gender.FEMALE;
    }

    public static void main(String[] args) {
        Person p = new Person();
        List<Person> persons = new ArrayList<>();
        p.getPersonByCondition(persons, new YoungerThanCondition(20));
        p.getPersonByCondition(persons, new Condition<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() < 20;
            }
        });
        p.getPersonByCondition(persons, person -> person.getAge() < 20);
        p.getPersonByCondition(persons, person -> person.getGender() == Gender.FEMALE);

//        int personCount = invokeMethod(() -> getVendorCount(persons));
    }

    private List<Person> getPersonsLessThan20Years(List<Person> persons) {
        List<Person> result = new ArrayList<>();
        for (Person person: persons) {
            if (person.getAge() < 20) {
                result.add(person);
            }
        }
        return result;
    }

    private List<Person> getPersonsByAgeRange(List<Person> persons, int from, int to) {
        List<Person> result = new ArrayList<>();
        for (Person person: persons) {
            if (person.getAge() >= from && person.getAge() <= to) {
                result.add(person);
            }
        }
        return result;
    }

    private List<Person> getPersonByDiverseCriteria(List<Person> persons,
                                                    int ageFrom,
                                                    int ageTo,
                                                    Gender gender,
                                                    boolean isCustomer,
                                                    boolean isVendor) {
        return null;
    }

    private List<Person> getPersonByCondition(List<Person> persons, Condition<Person> condition) {
        List<Person> result = new ArrayList<>();
        for (Person person: persons) {
            if (condition.test(person)) {
                result.add(person);
            }
        }
        return  result;
    }

    private static <T> T invokeMethod(Supplier<T> method) {
        long start = System.nanoTime();
        T result = method.get();
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Elapsed time: " + elapsedTime/1000000);
        return result;
    }
}

class YoungerThanCondition implements Condition<Person> {
    private final int _age;
    YoungerThanCondition(int age) {
        _age = age;
    }

    @Override
    public boolean test(Person person) {
        return person.getAge() < _age;
    }
}