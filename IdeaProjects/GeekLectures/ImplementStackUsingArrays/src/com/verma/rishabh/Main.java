package com.verma.rishabh;

public class Main {
    public static void main(String[] args){
        Stack myStack = new Stack();

        boolean push1 = myStack.push(10);
        if(push1)
            System.out.println("10 Pushed to stack");
        else{
            System.out.println("Unable to push 10 to stack");
        }
        boolean push2 = myStack.push(20);
        if(push2)
            System.out.println("20 Pushed to stack");
        else{
            System.out.println("Unable to push 20 to stack");
        }
        System.out.println("Is stack empty? "+myStack.isEmpty());
        System.out.println("Popped Out Element :"+myStack.pop());
        System.out.println("Popped Out Element :"+myStack.pop());
        System.out.println("Is stack empty? "+myStack.isEmpty());
    }
}
