import java.util.*;

class StackUsingQueue {
    private Queue<Integer> Q1 = new LinkedList<>();
    private Queue<Integer> Q2 = new LinkedList<>();

    public boolean isEmpty() {
        if (Q1.size() == 0 && Q2.size() == 0)
            return true;
        else
            return false;
    }

    public void push(int data) {
        Q1.offer(data);
        System.out.println(data + " Added to stack.");
    }

    public void pop() {
        // Keep popping until last element
        while (Q1.size() != 1) {
            // Dequeue from Q1 and enqueue to Q2
            int dequeuedItem = Q1.poll();
            Q2.offer(dequeuedItem);
        }
        int lastElementOut = Q1.poll();
        System.out.println(lastElementOut);

        // Swap the name of Q1 and Q2
        Queue<Integer> tempQueue;

        tempQueue = Q2;
        Q2 = Q1;
        Q1 = tempQueue;
    }
}
