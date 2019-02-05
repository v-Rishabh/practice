public class QuickSort1 {
    public static int partition(int[] arr, int l, int h) {
        int partitionIndex = -1;
        // Selecting middle element of array as pivot so that it sorts the array in
        // O(nlogn)
        // int mid = (l + h) / 2;
        int pivot = arr[h];
        int i = l - 1;

        for (int j = l; j < h; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Finally swap pivot with i+1.
        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;

        partitionIndex = i + 1;

        return partitionIndex;
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pi = partition(arr, l, h);

            quickSort(arr, l, pi - 1);
            // quickSort(arr, pi + 1, h);
            l = pi + 1;
        }
    }

    public static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 10, 5, 17, 22, 11 };
        int len = arr.length;
        // int high = len - 1;
        int low = 0;

        quickSort(arr, low, len - 1);

        printArray(arr);
    }
}