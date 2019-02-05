package com.verma.rishabh;

import java.util.ArrayList;
import java.util.Collections;

public class NextGreaterElementWithSameSet {
    public ArrayList<Integer> returnNextGreatest(int[] num){
        ArrayList<Integer> part1 = new ArrayList<>();
        ArrayList<Integer> part2 = new ArrayList<>();
        int arrayLen = num.length;
        // Step 1 : Pick Last element
        int lastElement = num[arrayLen-1];
        int markerIndex = -1;

        // Step 2 : Traverse the list in reverse order till a num greater is found.
        for(int i=arrayLen-1; i>0; i--){
            if(lastElement > num[i]){
                markerIndex = i;
                break;
            }
        }

        // Check for array in increasing order
        if(markerIndex == -1){
            return new ArrayList<>();
        }

        // Step 3 : Swap the marker index element with last element. [Swapping using XOR]
        num[arrayLen-1] = num[arrayLen-1] ^ num[markerIndex];
        num[markerIndex] = num[arrayLen-1] ^ num[markerIndex];
        num[arrayLen-1] = num[arrayLen-1] ^ num[markerIndex];

        // Step 4 : Divide the array in two parts.
        for(int i=0; i<=markerIndex; i++){
            part1.add(num[i]);
        }

        for(int i=markerIndex+1; i<arrayLen; i++){
            part2.add(num[i]);
        }

        // Step 5 : Sort the array
        Collections.sort(part2);

        // Step 6 : Merge both the arrays.
        part1.addAll(part2);

        return part1;
    }
}
