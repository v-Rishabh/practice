import java.util.LinkedList;
import java.util.Queue;

public class LevelOfBst {
    static class Pair{
        Node n;
        int i;
        Pair(Node n, int i){
            this.n = n;
            this.i = i;
        }
    }

    public void getLevel(Node _root){
        Queue<Pair> myQueue = new LinkedList<>();
        if(_root == null){
            return;
        }
        myQueue.offer(new Pair(_root,1));

        Pair p;

        while(!myQueue.isEmpty()){
            p = myQueue.peek();
            myQueue.remove();
            System.out.println("Level Of "+p.n.key + " is "+ p.i);
            if(p.n.leftChild != null){
                myQueue.offer(new Pair(p.n.leftChild, p.i+1));
            }
            if(p.n.rightChild != null){
                myQueue.offer(new Pair(p.n.rightChild,p.i+1));
            }

        }
    }

    public void treelevelTest(Node _root){
        if(_root == null){
            return;
        }
        Queue<Node> Q = new LinkedList<>();
        Q.offer(_root);
        int level = 1;
        while(true){
            int nodeCount = Q.size();
            if(nodeCount == 0){
                break;
            }
            while(nodeCount > 0){
                Node temp = Q.poll();
                System.out.println("Level of "+temp.key+" is "+level);

                if(temp.leftChild != null){
                    Q.offer(temp.leftChild);
                }
                if(temp.rightChild != null){
                    Q.offer(temp.rightChild);
                }
                nodeCount--;
            }
            level++;
        }
    }
}
