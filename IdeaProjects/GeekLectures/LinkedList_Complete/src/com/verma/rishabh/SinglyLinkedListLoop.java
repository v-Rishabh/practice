package com.verma.rishabh;

public class SinglyLinkedListLoop {
    Node head;
    public void detectAndRemoveLoop(){
        Node fast = head;
        Node slow = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // If Loop found
            if(slow == fast){
                System.out.println("Loop found");
                // Reset the slow pointer
                slow = head;
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                // Remove loop
                fast.next = null;
            }
        }
    }
    public void print(Node node){
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println("");
    }
}
