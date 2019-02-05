public class PreviousGreaterNaive {

    public static void printPreviousGreater(int[] arr) {
        System.out.println(arr[0] + " --> " + -1);
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int current = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                int prev = arr[j];
                if (current < prev) {
                    System.out.println(current + " --> " + prev);
                    break;
                }
            }
            if (j == -1) {
                System.out.println(current + " --> " + -1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 4, 2, 20, 40, 12, 30 };
        printPreviousGreater(arr);
    }
}