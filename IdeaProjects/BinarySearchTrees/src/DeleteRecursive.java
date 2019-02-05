public class DeleteRecursive {

    public Node deleteRecursive(Node root, int key){

        // Base Case: if tree is empty
        if(root == null){
            return root;
        }

        // If tree is not empty recurse down the tree till key is found.
        if(key < root.key){
            root.leftChild = deleteRecursive(root.leftChild, key);
        }
        else if(key > root.key){
            root.rightChild = deleteRecursive(root.rightChild,key);
        }

        // If key is same as root's key, then this is the node to be deleted.
        else{
            if(root.leftChild == null){
                return root.rightChild;
            }
            else if(root.rightChild == null){
                return root.leftChild;
            }

            // If node has 2 children, then get the smallest of In-Order Successor (Smallest in right sub-tree)
            root.key = minVal(root.rightChild);

            // Delete the InOrder Successor
            root.rightChild = deleteRecursive(root.rightChild, root.key);
        }
        return root;
    }

    // Get InOrder Successor of right sub-tree.
    int minVal(Node root){
        int minV = root.key;
        while (root.leftChild != null){
            minV = root.leftChild.key;
            root = root.leftChild;
        }
        return minV;
    }
}
