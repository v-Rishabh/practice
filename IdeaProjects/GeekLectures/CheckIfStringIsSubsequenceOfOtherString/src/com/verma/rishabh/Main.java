package com.verma.rishabh;

public class Main {
    public static void main(String[] args){
        String s1 = "AXY";
        String s2 = "ADXCPY";
        boolean res = isSubstring(s1,s2);
        System.out.println("Is string s1 is sub-sequence of string s2 : "+res);
    }

    public static boolean isSubstring(String s1, String s2){
        int lenShort = s1.length();
        int lenLong = s2.length();
        int matchCount = 0;
        for(int i=0; i<lenLong; i++){
            if(s2.charAt(i) == s1.charAt(matchCount))
                matchCount++;
        }
        if(matchCount == lenShort)
            return true;
        else
            return false;
    }
}
