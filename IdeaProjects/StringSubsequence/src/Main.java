/******************************************************************************

 Find if one string is Subsequence of other string.

 *******************************************************************************/


public class Main {

    public static boolean recurseIsSubsequence(String str1, String str2,int n1, int n2){
        // Base Condition
        if(n1 == 0){ return true;}
        if(n2 == 0) { return false;}

        if(str1.charAt(n1-1) == str2.charAt(n2-1))
            return recurseIsSubsequence(str1,str2,n1-1,n2-1);
        else
            return recurseIsSubsequence(str1,str2,n1,n2-1);
    }

    public static boolean isSubSequence(String str1, String str2){
        boolean result = false;
        int i =0;
        int j = 0;
        int size = str2.length();
        while(i<size){
            if(str2.charAt(i) == str1.charAt(j)){
                j++;
            }
            i++;
        }
        if(j == str1.length()){
            result = true;
        }


        return result;
    }

    public static void main(String args[]){
        String str1 = "AXY";
        String str2 = "ADXCPY";

        System.out.println(isSubSequence(str1,str2));

        System.out.println(recurseIsSubsequence(str1,str2,str1.length(),str2.length()));
    }
}
