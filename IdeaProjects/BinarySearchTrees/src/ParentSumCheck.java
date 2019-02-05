import java.util.LinkedList;
import java.util.Queue;

public class ParentSumCheck {

    public boolean isEqualParentSum(Node _root){
        if(_root == null){
            return true;
        }
        Queue<Node> Q = new LinkedList<>();
        Q.offer(_root);

        while(!Q.isEmpty()){
            int LC_Value = 0;
            int RC_Value = 0;
            Node temp = Q.poll();
            int SumCheck = temp.key;

            if(temp.leftChild != null){
                Q.offer(temp.leftChild);
                LC_Value = temp.leftChild.key;
            }
            else{
                LC_Value = 0;
            }
            if(temp.rightChild != null){
                Q.offer(temp.rightChild);
                RC_Value = temp.rightChild.key;
            }
            else{
                RC_Value = 0;
            }
            // Edge Condition => Leaf Nodes
            if(temp.leftChild == null && temp.rightChild == null){
                LC_Value = 0;
                RC_Value = temp.key;
            }
            if(SumCheck == LC_Value + RC_Value){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    // Recursive Solution
    public boolean childSumCheck(Node _root){
        if(_root == null){
            return true;
        }
        else if (_root.leftChild == null && _root.rightChild == null){
            return true;
        }
        else if(_root.leftChild == null){
            return _root.key == _root.rightChild.key;
        }
        else if(_root.rightChild == null){
            return _root.key == _root.leftChild.key;
        }
        else if(_root.key == _root.leftChild.key + _root.rightChild.key && childSumCheck(_root.leftChild) && childSumCheck(_root.rightChild)){
            return true;
        }
        else{
            return false;
        }
    }
}
