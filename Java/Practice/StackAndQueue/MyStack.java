public class MyStack {
    int MAX = 100;
    int top = -1;
    int[] arr = new int[MAX];

    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }

    public void push(int data) {
        if (top < MAX) {
            arr[top + 1] = data;
            top++;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int returnElement = arr[top];
            top--;
            return returnElement;
        }
    }

} // ## End of Class MyStack