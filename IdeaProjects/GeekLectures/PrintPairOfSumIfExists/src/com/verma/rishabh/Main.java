package com.verma.rishabh;
import java.util.*;
// Write a program that, given an array A[] of n numbers and another number x,
// determines whether or not there exist two elements in S whose sum is exactly x.
public class Main {
    public static void main(String[] args){
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printpairs(A,  n);
    }

    public static void printpairs(int[] arr, int sum){
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            int temp = sum - arr[i];

            if(temp>=0 && s.contains(temp)){
                System.out.println(" pair found => ("+arr[i]+","+temp+")");
            }
            s.add(arr[i]);
        }
    }
}
