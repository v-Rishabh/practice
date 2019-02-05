package com.verma.rishabh;

public class Main {
    public static void main(String[] args){
        getFirstNonRepeatingCharacter("geeksforgeeks");
    }

    public static void getFirstNonRepeatingCharacter(String str){
        int NO_OF_CHARS = 256;
        int[] countArray = new int[NO_OF_CHARS];

        // Fill the Array with ASCII values of Characters.
        for(int i=0; i<str.length(); i++){
            countArray[str.charAt(i)]++;
        }

        // If value is 1 get its equivalent character value and break.
        for (int ch=0; ch<countArray.length; ch++) {
            if(countArray[ch] == 1){
                char nonRepeatingElement = (char)ch;
                System.out.println("First Non Repeating Character in '"+str +"' is : "+nonRepeatingElement);
                break;
            }
        }

    }

}
