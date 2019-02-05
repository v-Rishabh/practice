import java.util.LinkedList;
import java.util.Queue;

public class CheckSiblings {
    public void printNodeWithNoSiblings(Node _root){
        if(_root == null){
            return;
        }
        Queue<Node> Q = new LinkedList<>();
        Q.offer(_root);

        while(!Q.isEmpty()){
            Node temp = Q.poll();
            if(temp.leftChild != null){
                Q.offer(temp.leftChild);
            }
            if(temp.rightChild != null){
                Q.offer(temp.rightChild);
            }
            if(temp.leftChild == null || temp.rightChild == null){
                if(temp.leftChild != null){
                    System.out.print(temp.leftChild.key+" ");
                }
                if(temp.rightChild != null){
                    System.out.print(temp.rightChild.key+" ");
                }
            }
        }
    }
}
