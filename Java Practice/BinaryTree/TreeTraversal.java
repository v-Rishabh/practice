import java.util.*;

public class TreeTraversal {
    // DFS
    public void inOrderTraversal(BNode temp) {
        if (temp != null) {
            inOrderTraversal(temp.leftChild);
            System.out.print(temp);
            inOrderTraversal(temp.rightChild);
        }
    }

    public void preOrderTraversal(BNode temp) {
        if (temp != null) {
            System.out.print(temp);
            preOrderTraversal(temp.leftChild);
            preOrderTraversal(temp.rightChild);
        }
    }

    public void postOrderTraversal(BNode temp) {
        if (temp != null) {
            postOrderTraversal(temp.leftChild);
            postOrderTraversal(temp.rightChild);
            System.out.print(temp);
        }
    }

    // BFS
    public void levelOrderTraversal(BNode root) {
        Queue<BNode> Q = new LinkedList<>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            BNode temp = Q.poll();
            if (temp == null) {
                continue;
            }
            System.out.print(temp.key + " ");
            if (temp.leftChild != null) {
                Q.offer(temp.leftChild);
            }
            if (temp.rightChild != null) {
                Q.offer(temp.rightChild);
            }
        }
    }
}