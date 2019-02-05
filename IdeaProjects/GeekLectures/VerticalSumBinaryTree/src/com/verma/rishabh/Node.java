package com.verma.rishabh;

public class Node {
    // Data Members
    int key;
    Node leftChild;
    Node rightChild;

    // Constructor
    Node(int key){
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Access Methods
    public int getkey(){
        return key;
    }
    public Node getLeftChild(){
        return leftChild;
    }

    public Node getRightChild(){
        return rightChild;
    }

    // Methods to set left and right child
    public void setLeft(Node left){
        this.leftChild = left;
    }
    public void setRight(Node right){
        this.rightChild = right;
    }
}
