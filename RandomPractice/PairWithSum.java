import java.util.*;

//given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.
// int A[] = {1, 4, 45, 6, 10, 8};
public class PairWithSum {
    public static void printPair(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if (temp > 0 && set.contains(temp)) {
                System.out.println("Pair with sum " + sum + " { " + temp + ", " + arr[i] + " }");
            }
            set.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 16;
        printPair(A, sum);
    }
}