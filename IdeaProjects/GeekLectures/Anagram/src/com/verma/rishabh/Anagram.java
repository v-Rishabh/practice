package com.verma.rishabh;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

public class Anagram {
    private int MAX_SIZE = 256;

    public boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

        int[] arr1 = new int[MAX_SIZE];
        int[] arr2 = new int[MAX_SIZE];
        Arrays.fill(arr1,0);
        Arrays.fill(arr2,0);

        // Fill the array
        for(int i=0; i<str1.length(); i++){
            arr1[(int)str1.charAt(i)]++;
            arr2[(int)str2.charAt(i)]++;
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        for(int i=0; i<MAX_SIZE; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
