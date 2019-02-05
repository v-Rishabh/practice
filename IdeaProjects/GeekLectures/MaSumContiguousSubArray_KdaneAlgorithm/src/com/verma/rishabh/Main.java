package com.verma.rishabh;


// This question is solved using Kadane's Algorithm
public class Main {
    public static void main(String[] args){
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int maxSum = getMaxSum(a);
        System.out.println("Max Sum of contiguous sub-array is : "+maxSum);
    }

    public static int getMaxSum(int[] arr){
        int max_sum_ending_here = 0;
        int max_sum_so_far = 0;
        int len = arr.length;

        for(int i=0; i<len; i++){
            max_sum_ending_here = max_sum_ending_here + arr[i];
            if(max_sum_ending_here < 0)
                max_sum_ending_here = 0;

            if(max_sum_ending_here > max_sum_so_far) {
                max_sum_so_far = max_sum_ending_here;
            }
        }
        return max_sum_so_far;
    }
}
