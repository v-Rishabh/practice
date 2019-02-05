package com.verma.rishabh;
import java.util.*;

public class Main {
    public static boolean balanced(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '{' || str.charAt(i) == '('){
                st.push(str.charAt(i));
            }
            else{
                char x = st.peek();
                if(str.charAt(i) == '}' && x == '{'){
                     st.pop();
                }
                else if(str.charAt(i) == ')' && x == '('){
                    st.pop();
                }
            }
        }
        if(st.empty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String args[]){
        String str = "{()}";
        boolean rs = balanced(str);
        String BalanceCheck = (rs == true) ? "Parenthesis is Balanced" : "Parenthesis Not Balanced";
        System.out.print(BalanceCheck+"\n");

        TwoStacks ts = new TwoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from" + " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from" + " stack2 is " + ts.pop2());
    }
}