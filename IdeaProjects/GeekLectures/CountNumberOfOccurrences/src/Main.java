public class Main {
    // Count number of occurrences (or frequency) in a sorted array

    public static int count(int[] arr, int key, int len){
        int i;
        int j;

        i = firstOccurence(arr,0,len-1,key);

        if(i == -1)
            return i;

        j = lastOccurence(arr, i, len-1, key);

        return (j-i)+1;
    }

    public static int firstOccurence(int[] arr, int start, int end, int key){
        if(end >= start){
            int mid = ( start + end) / 2;

            if((mid == 0 || key > arr[mid-1]) && arr[mid] == key){
                return mid;
            }
            if(key > arr[mid]){
                return firstOccurence(arr,mid+1,end,key);
            }
            else
                return firstOccurence(arr,start,mid-1,key);
        }
        return -1;
    }

    public static int lastOccurence(int[] arr, int start, int end, int key){
        if(end >= start){
            int mid = (start + end) / 2;

            if( (mid == end || key < arr[mid + 1]) && arr[mid] == key){
                return mid;
            }
            if(key < arr[mid]){
                return lastOccurence(arr,start, mid-1,key);
            }
            else{
                return lastOccurence(arr,mid+1,end,key);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int arr[] = {1, 2, 2, 3, 3, 3, 3};

        // Element to be counted in arr[]
        int x =  3;
        int n = arr.length;
        int c = count(arr, x, n);
        System.out.println(x+" occurs "+c+" times");
    }
}
