package com.verma.rishabh;

public class Stack {
    int MAX = 1000;
    int[] myStack = new int[MAX];
    int top;

    Stack(){
        top = -1;
    }

    public boolean isEmpty(){
        if(top == -1 || top < 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean push(int data){
        // Base Checking Condition
        if(top < MAX){
            myStack[top+1] = data;
            top++;
            return true;
        }
        else{
            System.out.println("Exception : Stack Overflow");
            return false;
        }
    }

    public int pop(){
        if(!isEmpty()){
            int toReturn = myStack[top];
            top--;
            return toReturn;
        }
        else{
            System.out.println("Stack Underflow");
            return -1;
        }
    }
}
