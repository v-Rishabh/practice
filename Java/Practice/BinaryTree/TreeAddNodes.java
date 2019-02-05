public class TreeAddNodes {
    BNode root;

    public void addNode(int InputKey) {
        BNode newNode = new BNode(InputKey);
        if (root == null) {
            root = newNode;
        } else {
            BNode temp = root;
            BNode parent;

            // Traverse the tree for inserting the node at correct position.
            while (true) {
                parent = temp;
                if (InputKey < temp.key) {
                    // Go left.
                    temp = temp.leftChild;
                    // Insert newNode to leaf Node.
                    if (temp == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    // Go right.
                    temp = temp.rightChild;
                    // Insert newNode to leaf Node.
                    if (temp == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeAddNodes theTree = new TreeAddNodes();

        theTree.root = new BNode(1);
        theTree.root.leftChild = new BNode(2);
        theTree.root.rightChild = new BNode(3);
        theTree.root.leftChild.rightChild = new BNode(4);
        theTree.root.rightChild.leftChild = new BNode(5);
        theTree.root.rightChild.leftChild.leftChild = new BNode(6);

        // Printing
        TreeTraversal TT = new TreeTraversal();
        System.out.println(" === Level Order Traversal ===");
        TT.levelOrderTraversal(theTree.root);
        System.out.println(" \n=== Pre Order Traversal ===");
        TT.preOrderTraversal(theTree.root);

        // Searching For a Node in Binary Tree
        Search search = new Search();
        BNode res = search.searchElement(theTree.root, 3);
        System.out.println("\nSearching for Node with Value 3 => " + res.key + " Found");
    }
}