package com.verma.rishabh;

public class Main {
    public static void main(String[] args){
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        int index = equlibriumIndex(arr);
        if(index > -1){
            System.out.println("Equilibrium Index found at Index : "+ index);
        }
        else{
            System.out.println("No Equlibrium Index Found");
        }
    }

    public static int equlibriumIndex(int[] arr){
        int len = arr.length;
        int L_Sum = 0;
        int Sum = 0;

        for(int i =0; i<len; i++){
            Sum += arr[i];
        }

        for(int i=0; i<len; i++){
            // Update right sum
            Sum = Sum - arr[i];

            // Check with left sum
            if(L_Sum == Sum)
                return i;

            // update L_Sum
            L_Sum = L_Sum + arr[i];
        }
        return -1;
    }
}
