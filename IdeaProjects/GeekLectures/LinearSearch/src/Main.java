public class Main {


    public static void linearSearch(int array[],int search){
        boolean result = false;
        int index = -1;
        for(int i=0; i<array.length; i++){
            if(array[i] == search){
                result = true;
                index = i;
                break;
            }
        }
        String res = result == true? "Found "+search+" at index "+ index : "Could not find "+search+" in given array";
        System.out.print(res);
    }
    public static void main(String args[]){
        int[] arr = {10, 20, 80, 30, 60, 50,110, 100, 130, 170};
        int search = 110;
        linearSearch(arr,search);
    }
}
