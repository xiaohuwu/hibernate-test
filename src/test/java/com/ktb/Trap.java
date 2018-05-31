package com.ktb;


public class Trap {
    public  static boolean  isOdd(int a){
        return Math.abs(a)%2==1;
    }

    public static void main(String[] args) {
        final int MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final int MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY*MILLIS_PER_DAY);
    }
}
