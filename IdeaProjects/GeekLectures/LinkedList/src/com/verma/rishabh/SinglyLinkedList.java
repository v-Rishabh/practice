package com.verma.rishabh;

public class SinglyLinkedList {
    Node head;

    public void insertAtHead(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        node.next = head;
        head = node;
    }

    public void insert(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        // If List is empty
        if(head == null){
            head = node;
        }
        else{
            // With this pointer we will traverse the list
            Node n = head;
            while (n.next != null){
                n = n.next;
            }
            // Insert
            n.next = node;
        }
    }

    public void deleteNode(int index){
        Node temp;
        temp = head;

        try {
            for(int i =0; i<index-1; i++){
                temp = temp.next;
            }
            // If its last element
            if(temp.next.next == null){
                temp.next = null;
            }
            else{
                temp.next = temp.next.next;
            }
            System.out.println("\n");
        }
        catch (NullPointerException e){
            System.out.println("Index out of bounds error");
        }

    }

    public void midElement(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            if(fast.next.next == null){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("\nMid Element of above list is -> "+slow.data);

    }

    public void getNthElement(int index){
        Node fast = head;
        Node slow = head;
        int count = 0;
        while (index != 0){
            fast = fast.next;
            count++;
            index--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println("\n"+count+"th element from end is -> "+slow.data);
    }

    public void reverseList(){
        Node prev = null;
        Node next = null;
        Node current = head;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public int detectLoopInList(){
        Node slow_p = head, fast_p = head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                // Found loop
                return 1;
            }
        }
        // no loop found
        return -1;
    }

    public void detectAndRemoveLoop(){
        Node slow_p = head;
        Node fast_p = head;

        // Now traverse to find loop in Linked list
        while(slow_p != null && fast_p != null && fast_p.next != null){
            // traverse
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

            if(slow_p == fast_p){
                // loop Found. Now find the starting of loop in linked list
                slow_p = head;
                while(slow_p.next != fast_p.next){
                    slow_p = slow_p.next;
                    fast_p = fast_p.next;
                }

                // Remove Loop
                fast_p.next = null;
            }
        }
        System.out.println("Linked List after removing loop : ");
        printList1(head);
    }

    void printList1(Node node) {
        System.out.print("head");
        while (node != null) {
            System.out.print("->"+ node.data);
            node = node.next;
        }
        System.out.print("\n");
    }

    public void printList(){
        Node node = head;
        System.out.print("head");
        while(node != null){
            System.out.print("->"+ node.data);
            node = node.next;
        }
        System.out.print("\n");
    }
}
