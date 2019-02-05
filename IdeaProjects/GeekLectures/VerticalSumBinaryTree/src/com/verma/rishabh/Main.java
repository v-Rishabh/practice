package com.verma.rishabh;

public class Main {
    public static void main(String args[]){
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeftChild().setLeft(new Node(4));
        root.getLeftChild().setRight(new Node(5));
        root.getRightChild().setLeft(new Node(6));
        root.getRightChild().setRight(new Node(7));

        TreeClass _treeClass_ = new TreeClass(root);
        _treeClass_.VerticalSumMain();
    }
}
