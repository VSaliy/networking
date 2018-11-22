package com.example.interview.convertFromDecimalSystemToBase7;

import java.util.Locale;
import java.util.Scanner;

public class ConvertFromBase7ToDecimalSystem {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int result = 0;

        char[] chars = console.nextLine().toCharArray();

        int[] reverse = new int[chars.length];

        for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {

            reverse[j] = Integer.parseInt(String.valueOf(chars[i]));
        }

        for (int i = 0; i < reverse.length; i++) {

            int sum = (int) (reverse[i] * Math.pow(7, i));

            result += sum;
        }
        System.out.println(result);
    }
}