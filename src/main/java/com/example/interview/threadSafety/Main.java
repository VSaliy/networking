package com.example.interview.threadSafety;

public class Main {

    public static void main(String[] args) {
        Books books = new Books();
        String title = "Elegant Objects";
        int id = books.add(title);
        assert books.title(id).equals(title);
    }
}
