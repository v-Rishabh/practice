package com.verma.rishabh;

public class Main {
    public static void main(String[] args){
        Stack myStack = new Stack();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println("Is Stack Empty : "+myStack.isEmpty());
        System.out.println("Printing Stack elements");
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println("Is Stack Empty : "+myStack.isEmpty());

    }
}
