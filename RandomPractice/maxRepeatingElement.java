public class maxRepeatingElement {
    int[] arr = { 10, 5, 8, 13, 5, 13, 22, 79 };
    int max = 0;
    int k = arr.length;

    public void getMaxReating() {
        int len = arr.length;
        // Re-design the array.
        for (int i = 0; i < len; i++) {
            arr[(arr[i] % k)] += k;
        }

        for (int e : arr) {
            System.out.print(e + " ");
            if (e > max) {
                max = e;
            }
        }
        System.out.println("\nMax: " + max);

    }

    public static void main(String[] args) {
        maxRepeatingElement mre = new maxRepeatingElement();
        mre.getMaxReating();
    }
}