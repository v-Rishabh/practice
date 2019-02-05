package com.verma.rishabh;

public class findPivot {
    public int findPivot(int[] arr, int start, int end){
        int mid = (start + end) /2;
        // Exit Condition
        if(arr[mid] > arr[mid+1]){
            return mid+1;
        }

        else{
            if(arr[start] > arr[mid]){
                return findPivot(arr,start,mid-1);
            }
            else{
                return findPivot(arr,mid+1,end);
            }
        }
    }
}
