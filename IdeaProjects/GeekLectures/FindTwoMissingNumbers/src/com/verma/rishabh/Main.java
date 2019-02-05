package com.verma.rishabh;

/*  Find Two Missing Numbers.
    Input  : arr[] = {1, 3, 5, 6}, n = 6
    Output : 2 4
    Given an array of n unique integers where each element in the array is in range [1, n].
    The array has all distinct elements and size of array is (n-2).
    Hence Two numbers from the range are missing from this array. Find the two missing numbers.
*/

public class Main {
    public static void main(String[] args){
        int arr[] = {1, 3, 5, 6};

        // Range of numbers is 2 plus size of array
        int n = 2 +arr.length;

        findTwoMissingNumbers(arr, n);
    }

    public static void findTwoMissingNumbers(int[] arr, int n){
        // XOR all elements with their index.
        int XOR = arr[0];
        for(int i=1; i<n-2; i++)
            XOR ^= arr[i];
        for(int i=1; i<=n; i++)
            XOR ^= i;

        int getSetBits = XOR & ~(XOR-1);

        // missing elements
        int x = 0, y = 0;

        for(int i=0 ; i<n-2; i++){
            if((getSetBits & i) > 0){
                x ^= arr[i];
            }
            else{
                y ^= arr[i];
            }
        }
        for(int i=0 ; i<=n; i++){
            if((getSetBits & i) > 0){
                x ^= i;
            }
            else{
                y ^= i;
            }
        }
        System.out.println("Two Missing Numbers are ");
        System.out.println( x + " " + y);
    }
}
