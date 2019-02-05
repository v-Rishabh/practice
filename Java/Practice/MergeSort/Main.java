class Main {

    public static void merge(int[] arr, int low, int mid, int high) {
        // get the length for temp arrays
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Create temp arrays
        int[] t1 = new int[n1];
        int[] t2 = new int[n2];

        // Fill the arrays
        for (int i = 0; i < n1; i++) {
            t1[i] = arr[low + i];
        }
        for (int j = 0; j < n2; j++) {
            t2[j] = arr[j + mid + 1];
        }

        // Merge both the arrays while comparing
        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (t1[i] < t2[j]) {
                arr[k] = t1[i];
                i++;
            } else {
                arr[k] = t2[j];
                j++;
            }
            k++;
        }

        // Copy all the elements left after comparing.
        while (i < n1) {
            arr[k] = t1[i];
            i++;
        }
        while (j < n2) {
            arr[k] = t2[j];
            j++;
        }
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            // Call sort on both the parts
            sort(arr, low, mid);
            sort(arr, mid + 1, high);

            // Merge the sorted arrays
            merge(arr, low, mid, high);
        }
    }

    public static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 45, 16, 19, 21, 2 };
        int low = 0;
        int high = arr.length - 1;
        // System.out.print(high);
        sort(arr, low, high);
        printArray(arr);
    }
}