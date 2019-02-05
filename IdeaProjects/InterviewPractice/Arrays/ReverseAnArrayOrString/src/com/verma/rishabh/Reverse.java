package com.verma.rishabh;

import java.util.*;

public class Reverse {
    public void reverseArray(int arr[]){
        System.out.println("Input Array "+Arrays.toString(arr));
        int length = arr.length-1;
        int start = 0;
        int end = length;
        int temp;
        // Reverse Process
        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Index Reset
            start++;
            end--;
        }
        System.out.println("Reversed Array "+Arrays.toString(arr));
        // Printing Of Array
        /*for(int i=0; i<=length; i++){
            System.out.print(arr[i]+" ");
        }*/
    }

    public void reverseNumber(int num){
        int len = Integer.toString(num).length();
        System.out.println("Number Given to Reverse "+num);
        String result = "";
        while(num != 0){
            int resultFromMod = num % 10;
            result += Integer.toString(resultFromMod);
            num = num/10;
        }
        System.out.println("Reversed Number = "+result);
    }
}
