import java.util.*;
import java.io.*;

public class QueueUsingStack {
    Stack<Integer> myStack1 = new Stack<>();
    Stack<Integer> myStack2 = new Stack<>();

    public boolean isEmpty() {
        if (myStack1.isEmpty() && myStack2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int data) {
        myStack1.push(data);
    }

    public void dequeqe() {
        // Making this operation costly
        if (!myStack2.isEmpty()) {
            System.out.print(myStack2.pop() + " ");
        } else if (myStack2.isEmpty()) {
            while (!myStack1.isEmpty()) {
                int pop = myStack1.pop();
                myStack2.push(pop);
            }
            System.out.print(myStack2.pop() + " ");
        } else if (myStack1.isEmpty() && myStack2.isEmpty()) {
            System.out.println("Empty Queue");
        }
    }
}