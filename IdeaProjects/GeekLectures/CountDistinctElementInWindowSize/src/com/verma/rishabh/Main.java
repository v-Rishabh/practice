package com.verma.rishabh;

import java.util.*;

/*
* Count distinct elements in every window of size k.
* Input:  arr[] = {1, 2, 1, 3, 4, 2, 3};
            k = 4
* Output:
* 3
* 4
* 4
* 3

* Explanation:
* First window is {1, 2, 1, 3}, count of distinct numbers is 3
* Second window is {2, 1, 3, 4} count of distinct numbers is 4
* Third window is {1, 3, 4, 2} count of distinct numbers is 4
* Fourth window is {3, 4, 2, 3} count of distinct numbers is 3
*/

public class Main {
    public static void main(String[] args){
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int window = 4;
        countDistinct(arr,window);
    }

    public static void countDistinct(int[] arr, int windowSize){
        Map<Integer,Integer> map = new HashMap<>();
        int DistinctElement = 0;
        int len = arr.length;
        // For first window
        for(int i=0; i<windowSize; i++){
            if(map.containsKey(arr[i])){
                int value = map.get(arr[i]);
                map.put(arr[i],value+1);
            }
            else{
                map.put(arr[i],1);
                DistinctElement++;
            }
        }
        System.out.println("Distinct elements : "+DistinctElement);

        // For rest of the array
        for(int i = windowSize; i<len; i++){
            // Remove the first element from map.
            int startElementIndex = i - windowSize;

            // Remove First Element
            if(map.get(arr[startElementIndex]) == 1){
                // reduce distinctCount and remove value of corresponding key.
                map.remove(arr[startElementIndex]);
                DistinctElement--;
            }
            else{
                int value = map.get(arr[startElementIndex]);
                map.put(arr[startElementIndex],value-1);
            }

            // Add New element in the map.
            if(map.get(arr[i]) == null){
                map.put(arr[i],1);
                DistinctElement++;
            }
            else{
                // Else increase count
                int value = map.get(arr[i]);
                map.put(arr[i],value+1);
            }

            System.out.println("Distinct elements : "+DistinctElement);
        }

    }
}
