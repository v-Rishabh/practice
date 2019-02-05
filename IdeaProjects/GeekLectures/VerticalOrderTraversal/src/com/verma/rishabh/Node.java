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

    @Override
    public String toString() {
        return key+ " ";
    }
}
