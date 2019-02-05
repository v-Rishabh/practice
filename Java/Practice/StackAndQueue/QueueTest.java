public class QueueTest {
    public static void main(String[] args) {
        MyQueue Q = new MyQueue();
        Q.enqueue(10);
        Q.enqueue(20);
        Q.enqueue(30);
        Q.enqueue(40);
        Q.enqueue(50);
        Q.enqueue(60);
        Q.enqueue(70);
        Q.enqueue(80);
        Q.enqueue(90);
        Q.enqueue(100);
        int size1 = Q.size();
        System.out.println("Size of queue is : " + size1);
        Q.dequeue();
        Q.dequeue();
        int size2 = Q.size();
        System.out.println("After removing 2 elements from Queue, Size of queue is : " + size2);
        Q.enqueue(110);
        Q.enqueue(120);
        Q.dequeue();
        Q.enqueue(130);

        int front = Q.front();
        int rear = Q.rear();

        System.out.println("Front of Queue is : " + front);
        System.out.println("Rear of Queue is : " + rear);

        System.out.println("Try to add when Queue is full");
        Q.enqueue(140);
        System.out.println("Removing all elements and printing");
        while (!Q.isEmpty()) {
            int element = Q.dequeue();
            System.out.print(element + " ");
        }

        System.out.println(" ");
        System.out.println("Queue is Empty? " + Q.isEmpty());

    }
}