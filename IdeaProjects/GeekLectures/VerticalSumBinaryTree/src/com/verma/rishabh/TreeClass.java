package com.verma.rishabh;


import java.util.HashMap;

public class TreeClass {
    Node root;

    TreeClass(){
        root = null;
    }
    TreeClass(Node n){
        root = n;
    }

    // Method to be called by the consumer classes
    // like Main class
    public void VerticalSumMain() { VerticalSum(root); }

    // A wrapper over VerticalSumUtil()
    private void VerticalSum(Node root) {

        // base case
        if (root == null) { return; }

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM =
                new HashMap<Integer, Integer>();

        // Calls the VerticalSumUtil() to store the
        // vertical sum values in hM
        VerticalSumUtil(root, 0, hM);

        // Prints the values stored by VerticalSumUtil()
        if (hM != null) {
            System.out.println(hM.entrySet());
        }
    }

    // Traverses the tree in Inoorder form and builds
    // a hashMap hM that contains the vertical sum
    private void VerticalSumUtil(Node root, int hD,
                                 HashMap<Integer, Integer> hM) {

        // base case
        if (root == null) {  return; }

        // Store the values in hM for left subtree
        VerticalSumUtil(root.getLeftChild(), hD - 1, hM);

        // Update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.getkey());

        // Store the values in hM for right subtree
        VerticalSumUtil(root.getRightChild(), hD + 1, hM);
    }
}
