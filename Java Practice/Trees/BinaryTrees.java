class BinaryTrees {
    Node root;

    public void addNode(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            Node parent;
            while (true) {
                parent = temp;
                if (key < temp.key) {
                    temp = temp.LC;
                    if (temp == null) {
                        parent.LC = newNode;
                        return;
                    }
                } else {
                    temp = temp.RC;
                    if (temp == null) {
                        parent.RC = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findNode(int Key) {
        Node temp = root;
        while (temp.key != Key) {
            if (Key < temp.key) {
                temp = temp.LC;
            } else {
                temp = temp.RC;
            }

            if (temp == null) {
                return null;
            }
        }
        return temp;
    }

    public boolean bstUtil(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key < min || root.key > max) {
            return false;
        }
        return (bstUtil(root.LC, min, root.key - 1) && bstUtil(root.RC, root.key + 1, max));
    }

    public boolean isBST(Node root) {
        return bstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        BinaryTrees bt = new BinaryTrees();
        bt.addNode(50);
        bt.addNode(25);
        bt.addNode(15);
        bt.addNode(30);
        bt.addNode(75);
        bt.addNode(85);

        Traversal traverse = new Traversal();
        System.out.println("===InOrder===");
        traverse.inOrderTraversal(bt.root);
        System.out.println(" ");
        System.out.println("===Pre order===");
        traverse.preOrder(bt.root);
        System.out.println(" ");
        System.out.println("===Post Order===");
        traverse.postOrder(bt.root);
        System.out.println(" ");
        System.out.println("===Level Order===");
        traverse.levelOrder(bt.root);
        System.out.println(" ");

        System.out.println("===Search 30 in Tree===");
        Node result = bt.findNode(30);
        if (result != null) {
            System.out.println(result.key + " Found");
        } else {
            System.out.println("Not Found key 30 in Tree");
        }

        System.out.println(" ");
        System.out.println("===Spiral Print===");
        traverse.printSpiral(bt.root);
        System.out.println(" ");

        TreeView tv = new TreeView();
        System.out.println("===Left View===");
        tv.leftView(bt.root, 1);
        System.out.println(" ");
        /**
         * System.out.println("===Right View==="); tv.rightView(bt.root, 1);
         * System.out.println(" ");
         */

        System.out.println("===Delete 25===");
        DeleteNode dn = new DeleteNode();
        dn.remove(bt.root, 25);
        System.out.println("===Level Order===");
        traverse.levelOrder(bt.root);
        System.out.println(" ");
        boolean res = bt.isBST(bt.root);
        System.out.println("IsBST ? : " + res);

    }

}