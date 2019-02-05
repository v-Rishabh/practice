package com.verma.rishabh;
import java.util.*;

public class Main {
    public static void main(String[] args){
        NextGreaterElementWithSameSet NGE = new NextGreaterElementWithSameSet();
        int digits[] = { 5,3,4,9,7,6 };
        ArrayList<Integer> result  = NGE.returnNextGreatest(digits);
        System.out.println(result);
        System.out.println("=============== Some Testing [TDD] ====================");
        testCase1();
        testCase2();
        testCase3();
    }

    // Test case 1
    public static void testCase1(){
        int digits[] = { 2,1,8,7,6,5 };
        NextGreaterElementWithSameSet NGE = new NextGreaterElementWithSameSet();
        ArrayList<Integer> result  = NGE.returnNextGreatest(digits);
        ArrayList<Integer> toCheck = new ArrayList<>();
        toCheck.add(2);
        toCheck.add(5);
        toCheck.add(1);
        toCheck.add(6);
        toCheck.add(7);
        toCheck.add(8);

        if(toCheck.equals(result)){
            System.out.println("Output as expected. 251678 for 218765");
        }
        else{
            System.out.println("I can smell some BUG!!");
        }
    }
    // Sorted in decreasing order test.
    public static void testCase2() {
        int digits[] = {10, 9, 8, 6, 5, 4};
        NextGreaterElementWithSameSet NGE = new NextGreaterElementWithSameSet();
        ArrayList<Integer> result = NGE.returnNextGreatest(digits);
        ArrayList<Integer> toCheck = new ArrayList<>();

        if (toCheck.equals(result)) {
            System.out.println("Output as expected. The result is Not Possible");
        } else {
            System.out.println("I can smell some BUG!!");
        }
    }
    // Sorted in increasing order test.
    public static void testCase3(){
        int digits[] = { 1,2,3,4,5,6 };
        NextGreaterElementWithSameSet NGE = new NextGreaterElementWithSameSet();
        ArrayList<Integer> result  = NGE.returnNextGreatest(digits);
        ArrayList<Integer> toCheck = new ArrayList<>();
        toCheck.add(1);
        toCheck.add(2);
        toCheck.add(3);
        toCheck.add(4);
        toCheck.add(6);
        toCheck.add(5);
        if(toCheck.equals(result)){
            System.out.println("Output as expected. 123465 for 123546");
        }
        else{
            System.out.println("I can smell some BUG!!");
        }
    }
}
