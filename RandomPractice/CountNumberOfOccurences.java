
public class CountNumberOfOccurences {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = { 1, 1, 2, 2, 2, 2, 3 };
        int low = 0;
        int high = arr.length - 1;
        int firstIndex = bs.firstOccurance(2, low, high, arr);
        int lastIndex = bs.lastOccurance(2, low, high, arr);

        int totalOccurance = (lastIndex - firstIndex) + 1;
        System.out.print("Total Occurance of 2 is: " + totalOccurance);
    }
}