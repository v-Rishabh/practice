package com.verma.rishabh;

public class binarySearch {
    public int binarySearch(int[] arr, int start, int end, int key){
        if(end > start){
            int mid = (start + end) / 2;

            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] > key){
                return binarySearch(arr,start,mid-1,key);
            }
            else{
                return binarySearch(arr,mid+1, end,key);
            }
        }
        return -1;
    }
}
