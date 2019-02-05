package com.verma.rishabh;

import java.util.*;

public class Main {
    // TreeMap for java multimap MultimapTest.
    static TreeMap<String,Vector<Integer>> TM = new TreeMap<>();

    public static void MultimapTest(String input, int val){
        Vector<Integer> v = new Vector<>();
        // If Key is not present then create new entry.
        if(!TM.containsKey(input)){
            v.add(val);
        }
        // If key is present then extend the value.
        else{
            // Copy all the values from Vector in TreeMap to new Vector.
            v.addAll(TM.get(input));
            // Add newer value to Vector.
            v.add(val);
        }
        // Update TreeMap. Add New record to TreeMap.
        TM.put(input,v);
    }

    public static void main(String args[]){
        Traversal t = new Traversal();

        Node root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(4);
        root.leftChild.rightChild = new Node(5);
        root.rightChild.leftChild = new Node(6);
        root.rightChild.rightChild = new Node(7);
        root.rightChild.leftChild.rightChild = new Node(8);
        root.rightChild.rightChild.rightChild = new Node(9);

        System.out.println("Vertical Order traversal is");
        t.printVerticalOrder(root);


        System.out.println("================================");
        System.out.println("Java Multimap test");
        MultimapTest("one",1);
        MultimapTest("two",2);
        MultimapTest("one",3);
        // Print all the elements in TreeMap.
        for(Map.Entry e : TM.entrySet()){
            System.out.println("Key : "+e.getKey()+ " | Value : "+e.getValue());
        }
    }
}
