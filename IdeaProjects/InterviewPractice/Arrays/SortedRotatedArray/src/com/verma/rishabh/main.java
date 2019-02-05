package com.verma.rishabh;
import java.util.*;
public class main {
    public static void main(String[] args){
        SortedRotated SR = new SortedRotated();
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 6;
        System.out.println("Input Array" + Arrays.toString(arr));
        System.out.println("Key Searched is : "+ key);
        int i = SR.search(arr,0,n-1,key);
        if (i != -1)
            System.out.println("Key : " +key +", Found at Index: " + i);
        else
            System.out.println("Searched Key "+key+" not found");
    }
}