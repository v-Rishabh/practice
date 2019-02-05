package com.verma.rishabh;

public class SortedRotated {
    public int search(int arr[],int l,int h,int key){
        if(l > h)
            return -1;

        int mid = (l+h)/2;
        if (arr[mid] == key)
            return mid;

        // If arr[l...mid] is sorted
        if(arr[l] <= arr[mid]){
            // If this is true then, This part of array is sorted.
            if(key >= arr[l] && key <= arr[mid]){
                return search(arr,l,mid-1,key);
            }
            else{
                return search(arr,mid+1,h,key);
            }
        }

        // If arr[l...mid] is not sorted then, arr[mid...h] must be sorted.
        if(key >= arr[mid] && key<= arr[h]){
            return search(arr,mid+1,h,key);
        }
        else{
            return search(arr,l,mid-1,key);
        }
    }
}