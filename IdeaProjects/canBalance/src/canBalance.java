/*
    Given a non-empty array, return true if there is a place to split the array.
    so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.

    canBalance([1, 1, 1, 2, 1]) → true
    canBalance([2, 1, 1, 2, 1]) → false
    canBalance([10, 10]) → true
 */

public class canBalance {

    public static boolean _canBalance(int[] nums) {
        boolean result = false;
        int totalSum = 0;
        int checkValue = 0;
        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
        }
        if ( totalSum % 2 == 0 ){
            int midValue = totalSum/2;
            //System.out.println(midValue);
            for (int j=0; j<nums.length; j++){
                checkValue += nums[j];
                //System.out.println(checkValue);

                if(checkValue == midValue){
                    result = true;
                    break;
                }
                else{
                    result = false;
                }
            }
        }
        else{
            result = false;
        }

        return result;
    }
    public static void main(String args[]){
        int[] a = {1, 1, 1, 2, 1};
        int[] b = {2, 1, 1, 2, 1};
        int[] c = {10,10};
        boolean r1 = _canBalance(a);
        System.out.println(r1);
        boolean r2 = _canBalance(b);
        System.out.println(r2);
        boolean r3 = _canBalance(c);
        System.out.println(r3);
    }
}
