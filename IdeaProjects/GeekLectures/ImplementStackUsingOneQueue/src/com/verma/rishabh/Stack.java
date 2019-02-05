package com.verma.rishabh;

import java.util.*;

public class Stack {
    private Queue<Integer> Q = new LinkedList<>();

    public void isEmpty(){
        if(Q.size() == 0)
            System.out.println("Stack is Empty.");
        else
            System.out.println("Stack is not empty");
    }

    public void push(int data){
        if(Q.size() == 0) {
            Q.offer(data);
        }
        else{
            // First add to Queue
            Q.offer(data);
            // Now adjust its position, so it behaves as a stack.[LIFO]
            int qSize = Q.size();
            int counter = qSize;
            while (counter != 1){
                int tempPop = Q.poll();
                Q.offer(tempPop);
                counter--;
            }
        }
        System.out.println("Pushed "+data+" to stack");
    }

    public void pop(){
        if(Q.size() != 0){
            int popped = Q.poll();
            System.out.println(popped);
        }
        else{
            System.out.println("EXCEPTION: Stack Underflow");
        }
    }
}
