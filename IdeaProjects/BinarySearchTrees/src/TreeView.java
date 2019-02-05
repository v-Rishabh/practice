public class TreeView {
    static int max_level = 0;
    public void LeftTreeView(Node _root, int level){
        if(_root == null){
            return;
        }
        if(max_level < level){
            System.out.print(_root.key+ " ");
            max_level = level;
        }
        LeftTreeView(_root.leftChild, level+1);
        LeftTreeView(_root.rightChild, level+1);
    }

    public void RightTreeView(Node _root, int level){
        if(_root == null){
            return;
        }
        if(max_level < level){
            System.out.print(_root.key+ " ");
            max_level = level;
        }
        LeftTreeView(_root.rightChild, level+1);
        LeftTreeView(_root.leftChild, level+1);
    }
}
