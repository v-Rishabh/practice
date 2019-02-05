import sun.reflect.generics.tree.Tree;

import java.awt.color.ICC_ColorSpace;

public class BinaryTree {

    // Create Root
    Node root;

    public void addNode(int key, String name){
        Node newNode = new Node(key,name);

        if(root == null){
            root = newNode;
        } else{
            Node temp = root; // This node we will use to traverse the tree.
            Node parent;

            // Traversing the tree.
            while(true){
                parent = temp;
                // if key of newNode is less than temp then go to its leftChild.
                if(key < temp.key){
                    temp = temp.leftChild;

                    // If temp is leaf node (Meaning its not having any left child then assign newNode as its leftChild)
                    if(temp == null){
                        parent.leftChild = newNode;
                        return;
                    }
                } else{
                    // If Key of newNode is greater than current Node(temp), Go to rightChild.
                    temp = temp.rightChild;

                    if(temp == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    public static int heightOfBinarytree(Node _root){
        if(_root == null){
            return 0;
        }
        else{
            int Leftheight = heightOfBinarytree(_root.leftChild);
            int RightHeight = heightOfBinarytree(_root.rightChild);

            if(Leftheight > RightHeight){
                return Leftheight + 1;
            }
            else{
                return RightHeight + 1;
            }
        }
    }

    public static void main(String[] args){
        BinaryTree theTree = new BinaryTree();
        Traversal traverse = new Traversal();
        search searchKey = new search();
        ValidateBST vBST = new ValidateBST();
        DeleteRecursive Del = new DeleteRecursive();
        LevelOfBst _LevelOfBST_ = new LevelOfBst();
        ParentSumCheck _ParentSumCheck_ = new ParentSumCheck();
        CheckSiblings _CheckSiblings_ = new CheckSiblings();
        TreeView _TreeView_ = new TreeView();
        ConstructBinaryTree _ConstructBinaryTree_= new ConstructBinaryTree();

        //theTree.addNode(50,"Boss");
        //theTree.addNode(25,"Vice Pres");
        //theTree.addNode(15,"Office Manager");
        //theTree.addNode(30,"Secretary");
        //theTree.addNode(75,"Sales Manager");
        //theTree.addNode(85,"Salesman");

        /*theTree.root = new Node(4);
        theTree.root.leftChild = new Node(2);
        theTree.root.rightChild = new Node(5);
        theTree.root.leftChild.leftChild = new Node(1);
        theTree.root.leftChild.rightChild = new Node(3);
        // Adding 10 to tree.
        theTree.addNode(10,"Added node");*/

        theTree.root = new Node(1);
        theTree.root.leftChild = new Node(2);
        theTree.root.rightChild = new Node(3);
        //theTree.root.leftChild.leftChild = new Node(3);
        theTree.root.leftChild.rightChild = new Node(4);
        theTree.root.rightChild.leftChild = new Node(5);
        theTree.root.rightChild.leftChild.leftChild = new Node(6);

        /*

        System.out.println("PreOrder traversal of binary tree is ");
        traverse.preOrderTraverseTree(theTree.root);

        System.out.println("\nInOrder traversal of binary tree is ");
        traverse.inOrderTraverseTree(theTree.root);

        System.out.println("\nPostOrder traversal of binary tree is ");
        traverse.postOrderTraverseTree(theTree.root);

        System.out.println("\nResult of searching 4 in binary tree is ");
        Node result = searchKey.searchNode(4,theTree.root);
        System.out.println("Found => "+result.key);

        System.out.println("If tree is BST? : "+vBST.isValidBST(theTree.root));

        // Delete 2 from tree.
        theTree.root = Del.deleteRecursive(theTree.root, 2);
        // Print tree after deletion
        System.out.println("\nInOrder traversal of binary tree is after deleting 2");
        traverse.inOrderTraverseTree(theTree.root);
        System.out.println("\nIf tree is BST? : "+vBST.isValidBST(theTree.root));

        */
        /*
        int height = heightOfBinarytree(theTree.root);
        System.out.println("Height of Binary tree is "+height);

        _LevelOfBST_.treelevelTest(theTree.root);
        //_LevelOfBST_.getLevel(theTree.root);

        //traverse.levelOrderTraversal(theTree.root);
        traverse.levelOrderTraversal_NewLine(theTree.root);

        //traverse.printSpiral(theTree.root); // Error: Infinite Loop

        System.out.println("\nIf tree is BST? : "+vBST.isValidBST(theTree.root));

        System.out.println("Is this Binary tree following child sum property? :"+_ParentSumCheck_.isEqualParentSum(theTree.root));
        */
        //_CheckSiblings_.printNodeWithNoSiblings(theTree.root);
        //System.out.println("Left View Of Tree");
        //_TreeView_.LeftTreeView(theTree.root, 1);
        System.out.println("Right View Of Tree");
        _TreeView_.RightTreeView(theTree.root,1);

        int InOrder[] = {2,5,8,10,15};
        int PreOrder[] = {10,5,2,8,15};
        System.out.println("\nBinary Tree Using Inorder and PreOrder Traversal");
        Node NewRoot = _ConstructBinaryTree_.buildTree(InOrder,PreOrder,0,InOrder.length - 1);
        _ConstructBinaryTree_.printInorder(NewRoot);
    }

}
