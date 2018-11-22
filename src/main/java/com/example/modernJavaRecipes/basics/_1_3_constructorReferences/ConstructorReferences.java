package com.example.modernJavaRecipes.basics._1_3_constructorReferences;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ConstructorReferences {

    public static void main(String[] args) {

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
