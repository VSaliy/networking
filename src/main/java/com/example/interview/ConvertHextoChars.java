package com.example.interview;

import java.util.*;

public class ConvertHextoChars {

    public static void printValidMassage(){
        String msg="204a6176617e";
        String msg1=convertHextoChars(msg);
        boolean isValid=(msg1.startsWith(" ") && msg1.endsWith("~")) ? true : false;
        System.out.println(isValid);
    }

    private static String convertHextoChars(String hex) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < hex.length() - 2; i++) {
            sb.append((char)Integer.parseInt(hex.substring(i,i+2),16));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        printValidMassage();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,1);
        map.put(2,2);
        Collection<Integer> values = map.values();
        for(int value: map.values())
            System.out.println(value);

        List<? extends Number> list = new LinkedList<>();
    }
}
