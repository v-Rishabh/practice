/*
    Consider the leftmost and rightmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive.
    A single value has a span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)
    maxSpan([1, 2, 1, 1, 3]) → 4
    maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
    maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
 */


public class maxSpan {

    public static int Span(int[] nums) {
        int _maxSpan_ = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    //Get maxSpan
                    int tempMaxSpan = (j - i)+1;
                    //If maxSpan is greater than previous span then update maxSpan Value.
                    if (tempMaxSpan > _maxSpan_){
                        _maxSpan_ = tempMaxSpan;
                    }
                }
            }
        }
        //System.out.println(_maxSpan_);
        return _maxSpan_;
    }

    public static void main(String args[]){

        int[] A = {1,2,1,1,3};
        int r1 = Span(A);
        System.out.println("maxSpan for {1,2,1,1,3} is "+r1);

        int[] B = {1,4,2,1,4,1,4};
        int r2 = Span(B);
        System.out.println("maxSpan for {1,4,2,1,4,1,4} is "+r2);

        int[] C = {1,4,2,1,4,4,4};
        int r3 = Span(C);
        System.out.println("maxSpan for {1,4,2,1,4,4,4} is "+r3);
    }
}
