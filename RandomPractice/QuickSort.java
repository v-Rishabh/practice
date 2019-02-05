public class QuickSort {

    public static int partitionIndex(int high, int low, int[] arr) {
        int partitionIndex = -1;
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap element at index i with j.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Finally swap pivot with i+1.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        partitionIndex = i + 1;

        return partitionIndex;
    }

    public static void sort(int high, int low, int[] arr) {
        if (low < high) {
            int pi = partitionIndex(high, low, arr);

            // Recurse
            sort(pi - 1, low, arr);
            sort(high, pi + 1, arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 10, 5, 17, 22, 11 };
        int low = 0;
        int high = arr.length - 1;
        sort(high, low, arr);

        printArray(arr);
    }
}