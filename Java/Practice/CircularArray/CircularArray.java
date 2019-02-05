import java.util.Arrays;

public class CircularArray {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int len = arr.length;
        int i = 0;
        while (i != 100) {
            int next = (i + 1) % len;
            arr[next] = i;
            i++;
        }
        System.out.print(Arrays.toString(arr));

    }
}