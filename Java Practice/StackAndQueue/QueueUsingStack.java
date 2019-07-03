
// Queue using 2 Stacks
import java.util.*;

public class QueueUsingStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /*
     * Methods: 1) Enqueue() 2) Dequeue() 3) isEmpty()
     */

    public boolean isEmpty() {
        if (stack1.isEmpty() && stack2.isEmpty())
            return true;
        else
            return false;
    }

    public void enqueue(int data) {
        stack1.push(data);
    }

    public void dequeue() {
        int dequeued;
        // Condition 1: If stack 2 is not empty.
        if (!stack2.isEmpty()) {
            dequeued = stack2.pop();
            System.out.println(dequeued);
        }
        // Condition 2: If Stack 2 is empty.
        else if (stack2.isEmpty()) {
            // Pop() all elements from stack1 and push it to stack2.
            while (!stack1.isEmpty()) {
                int popped = stack1.pop();
                stack2.push(popped);
            }
            // Pop() from stack2 and print.
            int finalPop = stack2.pop();
            System.out.println(finalPop);
        } else if (stack2.isEmpty() && stack1.isEmpty()) {
            System.out.println("WARNING: Queue is Empty.");
        }
    }
}
