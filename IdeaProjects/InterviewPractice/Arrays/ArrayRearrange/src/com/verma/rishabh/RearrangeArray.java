package com.verma.rishabh;

import java.util.*;

public class RearrangeArray {
    public void rearrange(int arr[]){
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        // Add all the values from array to hash map
        for(int i=0; i<arr.length; i++){
            hashMap.put(arr[i],i);
        }

        // Now check if element is present in hashMap
        for(int i=0; i<arr.length;i++){
            if(hashMap.containsKey(i)){
                arr[i] = i;
            }
            else{
                arr[i] = -1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
