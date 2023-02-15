package org.example;

public class Main {
    public static void main(String[] args) {
        Lock lock = new Lock(7,1,1,9);
        int minRolls = lock.findMinRollsToEquality();
        System.out.println(minRolls);
    }
}