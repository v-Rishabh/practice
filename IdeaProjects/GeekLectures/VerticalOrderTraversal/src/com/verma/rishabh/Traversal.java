package com.verma.rishabh;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class Traversal {

    public void verticalOrder(Node _root, int hd, TreeMap<Integer,Vector<Integer>> m){
        // Base case
        if(_root == null){
            return;
        }
        // get all the Values previously stored for current Key in Vector[get].
        Vector<Integer> get = m.get(hd);

        // If get is null, Meaning Key does not exist.
        if (get == null){
            // Create new vector.
            get = new Vector<>();
            // Add key to Vector.
            get.add(_root.key);
        }
        else{
            // Add new value.
            get.add(_root.key);
        }
        // Update TreeMap.
        m.put(hd,get);

        // Recursively Call for Left and Right Child.
        verticalOrder(_root.leftChild, hd-1, m);

        verticalOrder(_root.rightChild, hd+1, m);
    }

    public void verticalOrder2(Node _root, int hd, TreeMap<Integer,Vector<Integer>> m){
        // Base case
        if(_root == null){
            return;
        }
        // get all the Values previously stored for current Key in Vector[get].
        Vector<Integer> get = new Vector<>();

        // If get is null, Meaning Key does not exist.
        if (!m.containsKey(hd)){
            // Add key to Vector.
            get.add(_root.key);
        }
        else{
            get.addAll(m.get(hd));
            // Add new value.
            get.add(_root.key);
        }
        // Update TreeMap.
        m.put(hd,get);

        // Recursively Call for Left and Right Child.
        verticalOrder2(_root.leftChild, hd-1, m);

        verticalOrder2(_root.rightChild, hd+1, m);
    }

    public void printVerticalOrder(Node _root){
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        verticalOrder(_root,hd,m);

        for(Map.Entry<Integer,Vector<Integer>> entry : m.entrySet() ){
            System.out.println(entry.getValue());
            // For Bottom view entry.getValue.lastElement();
            // For Top View entry.getValue.firstElement();
        }
    }
}
