package com.verma.rishabh;

import java.util.*;

public class StockSpan {
    public void span(int arr[]){
        List<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[st.peek()]){
                st.push(i);
                res.add(1);
            }
            else{
                while(arr[i] < arr[st.peek()]){
                    st.pop();
                }
                st.push(i);
                if(st.empty()){
                    res.add(i+1);
                }
                else{
                    int temp = i - st.peek();
                    res.add(temp);
                }
            }
        }
    }
}
