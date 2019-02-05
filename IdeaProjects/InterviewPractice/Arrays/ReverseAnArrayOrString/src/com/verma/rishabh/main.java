package com.verma.rishabh;

public class main {
    public static void main(String[] args){
        System.out.println("==== Array Reverse ===");
        int[] arrayToReverse = {1,2,3,4,5,6};
        Reverse Rev = new Reverse();
        Rev.reverseArray(arrayToReverse);
        System.out.println("=== Number Reverse ===");
        int num = 1234;
        Rev.reverseNumber(num);
    }
}
