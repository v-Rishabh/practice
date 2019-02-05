public class BinarySearch {
    public int binarySearchAlgo(int l, int h, int[] arr, int search) {

        if (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == search)
                return mid;

            if (search > arr[mid]) {
                return binarySearchAlgo(mid + 1, h, arr, search);
            }

            else {
                return binarySearchAlgo(l, mid - 1, arr, search);
            }
        }
        return -1;
    }

    public int firstOccurance(int key, int l, int h, int[] arr) {
        int ans = -1;
        while (l <= h) {
            int mid = (l + h) / 2;

            if (arr[mid] > key) {
                h = mid - 1;
            } else if (arr[mid] < key) {
                l = mid + 1;
            } else if (arr[mid] == key) {
                ans = mid;
                // Go left
                h = mid - 1;
            }
        }

        return ans;
    }

    public int lastOccurance(int key, int l, int h, int[] arr) {
        int ans = -1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] < key) {
                l = mid + 1;
            } else if (arr[mid] > key) {
                h = mid - 1;
            } else if (arr[mid] == key) {
                ans = mid;
                // Go right;
                l = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 5, 5, 5, 6, 6 };
        int l = 0;
        int h = arr.length - 1;
        int search = 2;
        BinarySearch bs = new BinarySearch();
        int res = bs.binarySearchAlgo(l, h, arr, search);

        System.out.println(res == -1 ? "Not Found" : "Found " + search + " at Index: " + res);

        int first = bs.firstOccurance(3, l, h, arr);
        int last = bs.lastOccurance(5, l, h, arr);

        System.out.println("First Occurance of 3 at index: " + first + "\nLast Occurance of 5 at Index: " + last);
    }
}