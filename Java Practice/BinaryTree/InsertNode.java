class InsertNode {
    BNode root;

    public void insertNode(int key) {
        // Get the new Node for insertion
        BNode newNode = new BNode(key);
        BNode temp = root;
        BNode parent = null;
        // Condition 1
        if (root == null) {
            root = newNode;
        } else {
            // Condiiton 2 : Reach to the parent desired parent node where we will insert
            // the child.
            // While Temp is not null => Meaning get to the leaf parent node.
            // Return of this while loop will be Parent Node where we will insert the new
            // node as child.
            while (temp != null) {
                parent = temp;
                if (temp.key > key) {
                    // Go Left
                    temp = temp.leftChild;
                } else {
                    // Go Right
                    temp = temp.rightChild;
                }
            }
            // Inser the New Node either as left or right child.
            if (key < parent.key) {
                parent.leftChild = newNode;
            } else {
                parent.rightChild = newNode;
            }
        }
    }

    public static void main(String[] args) {
        // Check InsertNode Function
        InsertNode IN = new InsertNode();
        IN.insertNode(50);
        IN.insertNode(30);
        IN.insertNode(20);
        IN.insertNode(40);
        IN.insertNode(70);
        IN.insertNode(60);
        IN.insertNode(80);

        TreeTraversal TT = new TreeTraversal();
        TT.inOrderTraversal(IN.root);
        System.out.println("\n======");
        TT.levelOrderTraversal(IN.root);

    }
}