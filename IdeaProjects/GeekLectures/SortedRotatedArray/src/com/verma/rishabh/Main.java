package com.verma.rishabh;

import java.util.*;

public class Main {
    public static void main(String[] args){

        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr.length;
        int key = 9;
        System.out.println("Searching for key "+ key + " in array "+ Arrays.toString(arr));

        // Searching for pivot index
        findPivot _findPivot_ = new findPivot();
        int pivot = _findPivot_.findPivot(arr,0,n);
        System.out.println("Pivot index is : "+ pivot + " , Value at that index is: "+ arr[pivot]);

        // Searching for Key
        binarySearch _binarySearch_ = new binarySearch();
        if(pivot == key){
            System.out.println("Key found at "+ pivot);
        }
        else{
            if(arr[pivot] > key){
                int res = _binarySearch_.binarySearch(arr,pivot+1, n,key);
                System.out.println("Key found at "+ res);
            }
            else{
                int res = _binarySearch_.binarySearch(arr,0, pivot-1,key);
                System.out.println("Key found at "+ res);
            }
        }

    }
}
