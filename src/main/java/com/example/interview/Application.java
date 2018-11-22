package com.example.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
//    public static void main(String[] args) {
//        new Boeing();
//    }

    static class Aircraft {
        private String model = "N/A";

        public Aircraft() {
            printModel();
        }

        public void printModel() {
            System.out.println(model);
        }
    }

    static class Boeing extends Aircraft {
        private String model = "Boeing777";

        public Boeing() {
            printModel();
        }

        public void printModel() {
            System.out.println(model);
        }
    }

    static List<Integer> oddNumbers(int l, int r) {
        return IntStream.rangeClosed(l, r).filter(num -> num % 2 == 1).boxed().collect(Collectors.toList());

    }

    public static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }

    public static String asFraction(int a, int b) {
        int gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }

    public static void main(String[] args) {
        System.out.println(asFraction(4, 6)); // "22/51"
        System.out.println(asFraction(20, 10)); // "22/51"
        System.out.println(asFraction(160, 28)); // "22/51"
    }

    public static int[] cutSticks(int[] lengths) {
        List<Integer> stickLengthList = Arrays.stream(lengths).boxed().collect(Collectors.toList());
        List<Integer> ret = new ArrayList<>(stickLengthList.size());


        // Sort the stick lengths into DESCENDING order.
        Collections.<Integer>sort(stickLengthList,
                (a, b) -> { return b - a; });

        while (!stickLengthList.isEmpty()) {
            int listSize = stickLengthList.size();
            int smallestStickLength = stickLengthList.get(listSize - 1);

            for (int i = 0; i < listSize; ++i) {
                int currentStickLength = stickLengthList.get(i);
                stickLengthList.set(i,
                        currentStickLength - smallestStickLength);
            }

            ret.add(listSize);
            prune(stickLengthList);
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
    private static void prune(List<Integer> stickLengthList) {
        for (int i = stickLengthList.size() - 1; i >= 0; --i) {
            if (stickLengthList.get(i) == 0) {
                stickLengthList.remove(i);
            } else {
                return;
            }
        }
    }
}

class Result {

    /*
     * Complete the 'ReduceFraction' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY fractions as parameter.
     */

    public static List<String> ReduceFraction(List<String> fractions) {
        List<String> result = new ArrayList<>();
        for(String fraction: fractions) {
            if(fraction.matches("-{0,1}[0-9]+\\/[0-9]+")) {
                String[] numbers = fraction.split("/");
                int numerator = Integer.parseInt(numbers[0]);
                int denominator = Integer.parseInt(numbers[1]);
                result.add(asFraction(numerator, denominator));
            }
        }
        return result;
    }

    public static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    public static String asFraction(int a, int b) {
        int gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }

    static int[] cutSticks(int[] lengths) {
        List<Integer> stickLengthList = Arrays.stream(lengths).boxed().collect(java.util.stream.Collectors.toList());
        List<Integer> ret = new ArrayList<>(stickLengthList.size());


        // Sort the stick lengths into DESCENDING order.
        Collections.<Integer>sort(stickLengthList,
                (a, b) -> { return b - a; });

        while (!stickLengthList.isEmpty()) {
            int listSize = stickLengthList.size();
            int smallestStickLength = stickLengthList.get(listSize - 1);

            for (int i = 0; i < listSize; ++i) {
                int currentStickLength = stickLengthList.get(i);
                stickLengthList.set(i,
                        currentStickLength - smallestStickLength);
            }

            ret.add(listSize);
            prune(stickLengthList);
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();

    }

    private static void prune(List<Integer> stickLengthList) {
        for (int i = stickLengthList.size() - 1; i >= 0; --i) {
            if (stickLengthList.get(i) == 0) {
                stickLengthList.remove(i);
            } else {
                return;
            }
        }
    }
}

class Solution {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s [] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int a[] = new int[m];
        int b[] = new int[m];
        int k[] = new int[m];
        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");
            a[i] = Integer.parseInt(s[0]);
            b[i] = Integer.parseInt(s[1]);
            k[i] = Integer.parseInt(s[2]);
        }
        java.math.BigInteger su = java.math.BigInteger.valueOf(0);
        for(int i=0;i<m;i++){
            int l = b[i]-a[i]+1;
            su = su.add(java.math.BigInteger.valueOf(k[i]).multiply(java.math.BigInteger.valueOf(l)));
        }
        su = su.divide(java.math.BigInteger.valueOf(n));
        System.out.println(su);
    }
}