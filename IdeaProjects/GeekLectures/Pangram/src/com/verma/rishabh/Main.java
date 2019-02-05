package com.verma.rishabh;

public class Main {
    public static boolean[] MARK_ALPFA = new boolean[26];

    public static void main(String[] args){
        fillMarkAlpha("The quick brown fox jumps over the dog");
        boolean res = isPangram();
        System.out.println("Is Pangram : "+res);
        printMissingCharacters();
    }

    public static void fillMarkAlpha(String str){
        for(int i=0; i<str.length(); i++){
            if('a' <= str.charAt(i) && str.charAt(i) <= 'z'){
                MARK_ALPFA[str.charAt(i) - 'a'] = true;
            }
            else if('A' <= str.charAt(i) && str.charAt(i) <= 'Z'){
                MARK_ALPFA[str.charAt(i) - 'A'] = true;
            }
        }
    }

    public static boolean isPangram(){

        for(int i=0; i<MARK_ALPFA.length; i++){
            if(MARK_ALPFA[i] == false){
                return false;
            }
        }
        return true;
    }

    public static void printMissingCharacters(){
        System.out.print("Missing Characters from string are : ");
        for(int i=0; i<MARK_ALPFA.length; i++){
            if(MARK_ALPFA[i] == false){
                int ch = i + 'a';
                System.out.print((char)ch);
            }
        }
    }
}
