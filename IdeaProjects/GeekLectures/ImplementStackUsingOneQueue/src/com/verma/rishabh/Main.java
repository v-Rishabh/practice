package com.verma.rishabh;

public class Main {
    public static void main(String[] args){
        Stack myStack = new Stack();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.isEmpty();
        System.out.println("Printing Stack elements");
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.isEmpty();
        myStack.push(100);
        myStack.push(300);
        myStack.pop();
        myStack.pop();
    }
}
