package com.example.interview;

public class Practice2 {
    /// to convert to base 7 from given base 10
    public static String convert(long _in) {
        char [] base7={'0','S','y','d','n','e','y'};
        StringBuffer target=new StringBuffer();

        for (long i=_in; i>0; i /=7){
            target.append(base7[(int)i%7]);
        }

        target= target.reverse();
        return target.toString();
    }

    public static void main (String[] args) throws Exception {
        long _in=7;
        _in=16807+2401*2+343*3+49*4+7*5+1*6;
        System.out.println(convert(_in));

        convertFromBaseToBase("16", 10, 16);
    }

    public static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }
}



