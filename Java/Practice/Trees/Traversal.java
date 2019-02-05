import java.util.*;

import sun.java2d.Disposer.PollDisposable;

public class Traversal {
    public void inOrderTraversal(Node temp) {
        if (temp != null) {
            inOrderTraversal(temp.LC);
            System.out.print(temp.key + " ");
            inOrderTraversal(temp.RC);
        }
    }

    public void preOrder(Node temp) {
        if (temp != null) {
            System.out.print(temp.key + " ");
            preOrder(temp.LC);
            preOrder(temp.RC);
        }
    }

    public void postOrder(Node temp) {
        if (temp != null) {
            postOrder(temp.LC);
            postOrder(temp.RC);
            System.out.print(temp.key + " ");
        }
    }

    public void levelOrder(Node temp) {
        Queue<Node> Q = new LinkedList<>();
        if (temp == null)
            return;
        Q.offer(temp);

        while (true) {
            int size = Q.size();
            if (size == 0) {
                break;
            }
            while (size > 0) {
                Node polled = Q.poll();
                System.out.print(polled.key + " ");

                if (polled.LC != null) {
                    Q.offer(polled.LC);
                }
                if (polled.RC != null) {
                    Q.offer(polled.RC);
                }
                size--;
            }
        }
    }

    public void printSpiral(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        if (root == null) {
            return;
        }
        st1.push(root);

        while (!st1.isEmpty() || !st2.isEmpty()) {
            while (!st1.isEmpty()) {
                Node popped = st1.peek();
                st1.pop();
                System.out.print(popped.key + " ");

                if (popped.LC != null) {
                    st2.push(popped.LC);
                }
                if (popped.RC != null) {
                    st2.push(popped.RC);
                }
            }
            while (!st2.isEmpty()) {
                Node popped = st2.peek();
                st2.pop();
                System.out.print(popped.key + " ");

                if (popped.RC != null) {
                    st1.push(popped.RC);
                }
                if (popped.LC != null) {
                    st1.push(popped.LC);
                }
            }
        }
    }

}