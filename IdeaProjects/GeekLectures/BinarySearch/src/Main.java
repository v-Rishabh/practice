public class Main {

    public static int binarySearch(int arr[], int low, int high, int search){

        if(high>=low){
          int mid = low + (high - low)/2;

          if(arr[mid] == search){
              return mid;
          }

          if(arr[mid] > search){
              return binarySearch(arr, low, mid-1, search);
          }
          return binarySearch(arr, mid+1, high, search);
        }
        return -1;
    }
    public static void main(String args[]){
        int[] arr = {2,3,4,10,40};
        int length = arr.length-1;
        int search = 40;
        int val = binarySearch(arr,0,length,search);
        if (val == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + val);
    }
}
