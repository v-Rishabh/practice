import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

    // DFS
    public void inOrderTraverseTree(Node temp){
        if (temp != null) {
            inOrderTraverseTree(temp.leftChild);
            System.out.print(temp);
            inOrderTraverseTree(temp.rightChild);
        }
    }

    public void preOrderTraverseTree(Node temp){
        if (temp != null) {
            System.out.print(temp);
            preOrderTraverseTree(temp.leftChild);
            preOrderTraverseTree(temp.rightChild);
        }
    }
    public void postOrderTraverseTree(Node temp){
        if (temp != null) {
            postOrderTraverseTree(temp.leftChild);
            postOrderTraverseTree(temp.rightChild);
            System.out.print(temp);
        }
    }

    // BFS {Level Order Traversal}
    public void levelOrderTraversal(Node _root){
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.offer(_root);
        //myQueue.offer(null);
        while(!myQueue.isEmpty()){
            Node temp = myQueue.poll();
            if(temp == null){
                System.out.print("");
                continue;
            }
            System.out.print(temp.key + " ");
            if(temp.leftChild != null){
                myQueue.offer(temp.leftChild);
            }
            if(temp.rightChild != null){
                myQueue.offer(temp.rightChild);
            }
        }
    }

    // This method prints Level Order traversal of Binary tree with each new level at new line
    public void levelOrderTraversal_NewLine(Node _root){

        Queue<Node> myQueue = new LinkedList<>();

        //Base Case
        if(_root == null)
            return;

        // Add root to Queue
        myQueue.offer(_root);

        while(true){
            int nodeCount = myQueue.size();
            if(nodeCount == 0)
                break;

            while(nodeCount > 0){
                Node tempNode = myQueue.peek();
                System.out.print(tempNode.key);
                myQueue.remove();

                if(tempNode.leftChild != null){
                    myQueue.offer(tempNode.leftChild);
                }
                if(tempNode.rightChild != null){
                    myQueue.offer(tempNode.rightChild);
                }

                nodeCount--;
            }
            System.out.println();
        }
    }

    // Print Binary Tree in Spiral Fashion
    public void printSpiral(Node _root){
        Stack<Node> St1 = new Stack<>();
        Stack<Node> St2 = new Stack<>();

        if(_root == null){
            return;
        }
        St1.push(_root);

        while(!St1.isEmpty() || St2.isEmpty()){
            while(!St1.isEmpty()){
                Node temp = St1.peek();
                St1.pop();
                System.out.print(temp.key+ " ");

                if(temp.leftChild != null){
                    St2.push(temp.leftChild);
                }
                if(temp.rightChild != null){
                    St2.push(temp.rightChild);
                }
            }

            while (!St2.empty())
            {
                Node temp = St2.peek();
                St2.pop();
                System.out.print(temp.key + " ");

                // Note that is left is pushed before right
                if (temp.rightChild != null) {
                    St1.push(temp.rightChild);
                }
                if (temp.leftChild != null) {
                    St1.push(temp.leftChild);
                }
            }
        }

    }
}
