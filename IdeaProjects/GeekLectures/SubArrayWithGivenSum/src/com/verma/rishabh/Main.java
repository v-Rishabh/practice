package com.verma.rishabh;
import java.util.*;

public class Main {
    public static void main(String[] args){
        int arr[] = {97, -7, 36, 10, 2, -2, -20, 10};
        sumExist(arr,-10);
    }

    public static void sumExist(int[] arr, int reqSum){
        Map<Integer,Integer> map = new HashMap<>();
        int len = arr.length;
        int currentSum = 0;

        for(int i=0; i<len; i++){
            currentSum += arr[i];

            if(currentSum == reqSum) {
                System.out.println("[From Start] Required Sum Found from Index " + 0 + " to " + i);
                break;
            }

            if(map.containsKey(currentSum - reqSum)){
                int index = map.get(currentSum - reqSum)+1;
                System.out.println("[HashMap] Required Sum Found from Index "+index+" to "+ i);
                break;
            }

            map.put(currentSum, i);
        }
    }
}
