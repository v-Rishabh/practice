// Construct a binary tree using InOrder and PreOrder Traversal
/*
    i/p:
        InOrder = {2,5,8,10,15}
        PreOrder = {10,5,2,8,15}

        O/P:    10
               /  \
              5    15
             / \
            2   8
 */

public class ConstructBinaryTree {
    int preIndex = 0;


    public Node buildTree(int in[], int pre[], int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        Node tNode = new Node(pre[preIndex++]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.key);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.leftChild = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.rightChild = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    /* UTILITY FUNCTIONS */

    /* Function to find index of value in arr[start...end]
     The function assumes that value is present in in[] */
    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++)
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    /* This funtcion is here just to test buildTree() */
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.leftChild);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.rightChild);
    }
}
