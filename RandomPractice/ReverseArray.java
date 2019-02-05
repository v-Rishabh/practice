class ReverseArray {
    public static void reverse(int[] arr) {
        int len = arr.length - 1;
        int start = 0;
        int end = len;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        reverse(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}