package com.example.modernJavaRecipes.basics._1_2_methodReferences;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MethodReferences {
    public static void main(String[] args) {

        Stream.of(3,1,4,1,5,9)
                .forEach(integer -> System.out.println(integer));   //Using a lambda expression

        Stream.of(3,1,4,1,5,9)
                .forEach(System.out::println);                      //Using a method reference

        Consumer<Integer> printerInteger = System.out::println;
        Consumer<Double> printerDouble = System.out::println;
        Stream.of(3,1,4,1,5,9)
                .forEach(printerInteger);  //Assigning the method reference to a functional interface

        Stream.generate(Math::random)   //Static method
                .limit(10)
                .forEach(printerDouble);  //Instance method

        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "dtrings");
        List<String> sorted = strings.stream()
                .sorted((o1, o2) -> o1.compareTo(o2))   ////Using a lambda expression
                .collect(Collectors.toList());
        sorted = strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());  //Method reference

        Stream.of("This", "is", "a", "stream", "of", "strings")
                .map(String::length)    //Instance method via class name
                .forEach(System.out::println);  //Instance method via object reference

        Stream.of("This", "is", "a", "stream", "of", "strings")
                .map(s -> s.length())
                .forEach(x -> System.out.println(x));

        List<Person> people = new ArrayList<>();
        Person p = new Person();
        p.setName("Bob");
        List<String> names = people.stream()
                .map(person -> person.getName())    //Lambda expression
                .collect(Collectors.toList());
        names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());      //Method reference

        names =
                Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace",
                        "Karen Spärck Jones");
        people = names.stream()
                .map(name -> new Person(name))  //Using a lambda expression to invoke the constructor
                .collect(Collectors.toList());

        people = names.stream()
                .map(Person::new)   //Using a constructor reference instantiating Person
                .collect(Collectors.toList());

        Person before = new Person("Grace Hopper");
        people = Stream.of(before)
                .collect(Collectors.toList());
        Person after = people.get(0);
        assertTrue(before == after);    //Same object
        before.setName("Grace Murray Hopper");     //Change name using before reference
        assertEquals("Grace Murray Hopper", after.getName());   //Name has changed in the after reference

        people = Stream.of(before)
                .map(Person::new)   //Use copy constructor
                .collect(Collectors.toList());
        after = people.get(0);
        assertFalse(before == after);   //Different objects
        assertEquals(before.getName(), after.getName());    //But equivalent

        before.setName("Rear Admiral Dr. Grace Murray Hopper");
        assertFalse(before.equals(after));

        people = names.stream() //Create a stream of strings
                .map(name -> name.split(" "))   //Map to a stream of string arrays
                .map(Person::new)   //Map to a stream of Person
                .collect(Collectors.toList());  //Collect to a list of Person

        System.out.println("Varargs ctor, names=" + Arrays.asList(people));

        Person[] persons = names.stream()
                .map(Person::new)   //Constructor reference for Person
                .toArray(Person[]::new);    //Constructor reference for an array of Person
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Person {
    private String name;

    public Person(Person p) {
        this.name = p.name;
    }

    public Person(String... names) {
        this.name = Arrays.stream(names)
                .collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
