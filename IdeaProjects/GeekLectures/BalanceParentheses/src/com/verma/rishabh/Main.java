package com.verma.rishabh;

import java.util.*;
public class Main {
    public static Stack<Character> st = new Stack<>();
    public static void main(String[] args){
        String testCase1 = "{(()[]})";
        boolean res = isBalanced(testCase1);
        System.out.println("For Test case 1 : '"+testCase1+"' Is Parentheses balanced? : "+res);
        st.clear();
        System.out.println("-------------------------------------------------------------------");
        String testCase2 = "{(()[])}";
        boolean res2 = isBalanced(testCase2);
        System.out.println("For Test case 2 : '"+testCase2+"' Is Parentheses balanced? : "+res2);
    }

    public static boolean isMatching(char ch){
        char match = st.peek();
        if(ch == ')' && match == '(')
            return true;
        else if(ch == '}' && match == '{')
            return true;
        else if(ch == ']' && match == '[')
            return true;
        else
            return false;
    }
    public static boolean isBalanced(String str){
        for(int i=0; i<str.length(); i++){
            char toCheck = str.charAt(i);
            if(toCheck == '(' || toCheck == '{' || toCheck == '[')
                st.push(str.charAt(i));
            if(toCheck == ')' || toCheck == '}' || toCheck == ']'){
                // check matching
                char matching = str.charAt(i);
                if (isMatching(matching))
                    st.pop();
                else
                    return false;
            }
        }
        if(st.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
