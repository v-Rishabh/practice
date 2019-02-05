package com.verma.rishabh;

public class SinglyLinkedList {
    Node head;
    public void insertAtHead(int data){
        // Make new node.
        Node newNode = new Node(data);

        // If head points to null, then insert directly.
        if(head == null)
            head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtPos(int data, int pos){
        Node newNode = new Node(data);
        Node temp = head;
        for(int i=0; i<pos-1; i++){
            temp = temp.next;
        }
        // If this is last element
        if(temp.next == null){
            insertAtEnd(data);
        }
        else{
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void deleteElementAtPos(int pos){
        Node temp = head;
        if(pos == 0){
            head = temp.next;
        }
        else{
            for(int i=0; i<pos-1; i++){
                temp = temp.next;
            }
            if(temp.next.next == null){
                temp.next = null;
            }
            else{
                temp.next = temp.next.next;
            }
        }
    }

    public void printMiddleNode(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("Middle element is :: "+slow.data);
    }

    public void printNthElementFromEnd(int n){
        int counter = n;
        Node fast = head;
        Node slow = head;
        // Step 1: Move fast pointer to N positions ahead in list.
        while(counter != 0){
            if(fast.next == null) {
                System.out.println("ERROR: NullPointerException, Size of list is less than input provided.");
                return;
            }
            else{
                fast = fast.next;
                counter--;
            }
        }
        // Step 2: Move both the pointers till fast pointer reaches NULL.
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(n+"th node from end of list is : "+slow.data);
    }

    public void print(Node node){
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println("");
    }
}