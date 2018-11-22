package com.example.interview;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyClass {
	public static void main(String args[]) {
        String priority = "ZMHJE";

        List<Order> orders = null;

        Order order = new Order();
        order.id = 1;
        order.name = "Aa";
        order.priority = "Z";
        orders.add(order);

        Order order2 = new Order();
        order2.id = 2;
        order2.name = "Bb";
        order2.priority = "H";
        orders.add(order2);

        Order order3 = new Order();
        order2.id = 3;
        order2.name = "Cc";
        order2.priority = "M";
        orders.add(order3);

        Order order4 = new Order();
        order2.id = 4;
        order2.name = "Dd";
        order2.priority = "E";
        orders.add(order4);

        Order order5 = new Order();
        order2.id = 5;
        order2.name = "Ee";
        order2.priority = "J";
        orders.add(order5);

        sort(priority, orders);
    }

    private static void sort(String priority, List<Order> orders) {
    	Comparator<Order> ordereComparator = new Comparator<Order>() {
    		public int compare(Order left, Order right) {
    	        return Integer.compare(priority.indexOf(left.priority), priority.indexOf(right.priority));
    	    }
    	};

    	Comparator<Order> ordereComparator2 = Comparator.comparing(items -> priority.indexOf(items.priority));

    	Collections.sort(orders, ordereComparator);

	}

	static class Order {
        private int id;
        private String name;
        private String priority;
    }
}
