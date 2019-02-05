package com.verma.rishabh;

public class Main {
    public static void main(String[] args){
        Anagram a = new Anagram();
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";

        boolean res = a.isAnagram(s1,s2);
        if(res)
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");
    }
}
