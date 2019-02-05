public class DeleteNode {
    public Node remove(Node root, int key) {
        if (root == null) {
            return root;
        }
        // Get to the node which needs to be deleted.
        if (key < root.key) {
            root.LC = remove(root.LC, key);
        } else if (key > root.key) {
            root.RC = remove(root.RC, key);
        }
        // If key is same as root's key
        else {
            // Root with only one child or no child
            if (root.LC == null) {
                return root.RC;
            }
            if (root.RC == null) {
                return root.LC;
            }
            // If Node has 2 child nodes.
            // get the Min of right sub tree (InOrder Successor) and delete the InOrder
            // Successor
            root.key = getMin(root.RC);
            root.RC = remove(root.RC, root.key);
        }
        return root;
    }

    public int getMin(Node root) {
        int minVal = root.key;
        // trverse to leaf node
        while (root.LC != null) {
            minVal = root.LC.key;
            root = root.LC;
        }
        return minVal;
    }
}