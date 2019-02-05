public class Main {
    public static void findMissingNumber(int arr[],int range){
        // Algorithm 1
        /* Using Sum method.
         * 1. Get the sum of numbers total = n*(n+1)/2
         * 2. Subtract all the numbers from sum and you will get the missing number.
         */
        // Algorithm 2
        /*
        * Using XOR method.
        * X1 = XOR all the elements from array from arr[1] till arr[range] with arr[0].
        * X2 = XOR all elements from 2 till range+1
        * Return (X1 ^ X2)
        */

        int X1 = arr[0];
        int X2 = 1;
        for(int i=1; i<arr.length; i++){
            X1 = X1 ^ arr[i];
        }
        for(int i=2; i<=range+1; i++){
            X2 = X2 ^ i;
        }
        int result = X1 ^ X2;
        System.out.print("The Missing Number is => "+result);
    }
    public static void main(String args[]){
        int a[] = {1,2,4,5,6};
        findMissingNumber(a,5);
    }
}
