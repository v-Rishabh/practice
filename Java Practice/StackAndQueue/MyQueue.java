public class MyQueue {
    private int MAX = 10;
    private int start = -1;
    private int end = -1;
    private int size = 0;
    private int[] arrayQ = new int[MAX];

    public boolean isEmpty() {
        if (start == -1 && end == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int data) {
        int capacity = arrayQ.length;
        // If first element
        if (isEmpty()) {
            start = (start + 1) % capacity;
            end = (end + 1) % capacity;
            arrayQ[end] = data;
            size++;
        } else if (size > MAX - 1) {
            System.out.println("ERROR : Cannot add more elements. OverFlow");
        } else {
            end = (end + 1) % capacity;
            arrayQ[end] = data;
            size++;
        }
    }

    public int dequeue() {
        int capacity = arrayQ.length;
        if (isEmpty()) {
            System.out.println("ERROR: Queue is Empty.");
            return -1;
        } else if (start == end) {
            int toReturn = arrayQ[start];
            start = -1;
            end = -1;
            return toReturn;
        } else {
            int toReturn = arrayQ[start];
            start = (start + 1) % capacity;
            size--;
            return toReturn;
        }
    }

    public int size() {
        return size;
    }

    public int front() {
        if (!isEmpty()) {
            return arrayQ[start];
        } else {
            return -1;
        }
    }

    public int rear() {
        if (!isEmpty()) {
            return arrayQ[end];
        } else {
            return -1;
        }
    }
}