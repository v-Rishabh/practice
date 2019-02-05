package com.verma.rishabh;

import java.util.Stack;

public class NSE {
    public void NSElement(int[] arr){
        Stack<Integer> st = new Stack<>();
        // Push first element of array to stack
        st.push(arr[0]);
        int len = arr.length;
        // Run a loop over remaining elements of array
        for(int i=1; i<len; i++){


            while(st.isEmpty() == false && st.peek() > arr[i]){
                System.out.println(st.peek()+" ---> "+arr[i]);
                st.pop();
            }

            st.push(arr[i]);
        }

        // Print all remaining elements of stack.
        while (st.isEmpty() == false){
            System.out.println(st.peek()+" ---> -1");
            st.pop();
        }
    }
}
