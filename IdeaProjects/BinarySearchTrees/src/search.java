public class search {

    public Node searchNode (int key, Node root){
        if(root == null || root.key == key){
            return root;
        }
        else{
            if(root.key < key){
                return searchNode(key, root.leftChild);
            }
            else{
                return searchNode(key,root.rightChild);
            }
        }

    }
}
