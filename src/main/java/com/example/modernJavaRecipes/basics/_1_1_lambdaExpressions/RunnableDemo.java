package com.example.modernJavaRecipes.basics._1_1_lambdaExpressions;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class RunnableDemo {
    public static void main(String[] args) {
        {
            new Thread(new Runnable() { //Anonymous inner class
                @Override
                public void run() {
                    System.out.println("inside runnable using an anonymous inner class");
                }
            }).start();
        }
        new Thread(() -> System.out.println("inside Thread constructor using lambda")).start();

        Runnable r = () -> System.out.println("lambda expression implementing the run method");
        new Thread(r).start();

        File directory = new File("./src/main/java");
        String[] names = directory.list(new FilenameFilter() {  //Anonymous inner class
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        System.out.println(Arrays.asList(names));

        names = directory.list((dir, name) -> name.endsWith(".java"));  //Lambda expression
        System.out.println(Arrays.asList(names));

        names = directory.list((File dir, String name) -> name.endsWith(".java"));  //Explicit data types
        System.out.println(Arrays.asList(names));

        names = directory.list((dir, name) -> { //Block syntax
            return name.endsWith(".java");
        });
        System.out.println(Arrays.asList(names));
    }
}
