package com.verma.rishabh;

import java.util.*;

public class Main {
    public static void main(String[] args){
        int arr[] = {4, 2, -3, 1, 6};
        boolean res = ZeroSumExist(arr);
        if (res)
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");
    }

    public static boolean ZeroSumExist(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int currentSum = 0;

        for(int i =0 ; i<arr.length; i++){
            currentSum += arr[i];

            if(currentSum == 0 || arr[i] == 0 || map.get(arr[i]) != null){
                return true;
            }

            map.put(currentSum,i);
        }
        return false;
    }
}
