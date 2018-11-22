package com.example.lambda.stream;
import com.example.lambda.*;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearningStream {
    public static void main(String[] args) {
        List<Person> persons = getPeople();

        List<Person> youngFemales = persons.stream()
                .filter(person -> person.getAge() < 20)
                .filter(person -> person.isFemale())
                .collect(Collectors.toList());

        double averageAge = persons.stream()
                .filter(p -> p.getAge() < 20 && p.isFemale())
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();

        long totalSelling = persons
                .stream()
                .filter(Person::isVendor)
                .mapToLong(p -> p.getSellings()
                        .stream()
                        .mapToLong(Product::getQuantity)
                        .sum()
                ).sum();

        long totalSelling2 = persons
                .stream()
                .filter(Person::isVendor)
                .flatMapToLong(p -> p.getSellings()
                        .stream()
                        .mapToLong(Product::getQuantity)
                ).sum();
        Stream<Person> stream = persons.stream();

        if (true) {
            stream = stream.filter(Person::isFemale);
        }
        if (true) {
            stream = stream.filter(p -> p.getAge() < 20);
        }
        double average = stream
                .mapToInt(p -> p.getAge())
                .average()
                .getAsDouble();

        Supplier<Long> totalSelling3 = () ->
                persons.stream()
                .filter(Person::isVendor)
                .flatMapToLong(person -> person
                        .getSellings()
                        .stream()
                        .mapToLong(Product::getQuantity)
                ).sum();
        System.out.println("total: " + invokeMethod(totalSelling3));

        Supplier<Long> totalSelling4 = () ->
                persons.parallelStream()
                .filter(Person::isVendor)
                .flatMapToLong(person -> person
                        .getSellings()
                        .stream()
                        .mapToLong(Product::getQuantity)
                ).sum();
        System.out.println("total: " + invokeMethod(totalSelling4));
    }

    private static <T> T invokeMethod(Supplier<T> method) {
        long start = System.nanoTime();
        T result = method.get();
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Elapsed time: " + elapsedTime/1000000);
        return result;
    }
    private static List<Person> getPeople() {
        ArrayList<Selling> sellings = new ArrayList<>();
        Selling selling1 = new Selling();
        selling1.setArticleNo(0L);
        selling1.setQuantity(0);
        selling1.setAmount(0);
        sellings.add(selling1);

        List<Person> persons = new LinkedList<>();
        Person person1 = new Person();
        person1.setSurName("");
        person1.setGivenName("");
        person1.setAge(3);
        person1.setGender(Gender.FEMALE);
        person1.setVendor(false);
        person1.setBuyings(new ArrayList<Buying>());
        person1.setSellings(sellings);


        persons.add(person1);
        return persons;
    }
}
