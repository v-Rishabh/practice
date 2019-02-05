package com.verma.rishabh;

public class ReverseList {
    Node head;
    public void reverseList(Node node){
        // Initializing 3 pointers
        Node current = head;
        Node next = null;
        Node prev = null;

        while(current != null){
            // Step 1 : set next to next of current. So that we don't lose the pointer to actual list.
            next = current.next;

            // Step 2 : Set Next of current to previous.
            current.next = prev;

            // Step 3 : Increment the pointer Current and previous.
            prev = current;
            current = next;
        }

        // Spet 4 : Make the Head pointer points to prev.
        head = prev;
    }

    public Node reverseK_GroupOfNodes(Node head, int k){
        // Initializing pointers
        Node current = head;
        Node prev = null;
        Node next = null;

        // Keeping count
        int count = 0;
        while(count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            // Increment the count
            count++;
        }

        //Reversing rest of the K groups
        if(next != null){
            head.next = reverseK_GroupOfNodes(next, k);
        }

        return prev;
    }

    public void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("");
    }
}
