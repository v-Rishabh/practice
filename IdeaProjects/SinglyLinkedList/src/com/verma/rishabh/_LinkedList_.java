package com.verma.rishabh;

public class _LinkedList_ {
    Node head;
    public void insert(int data){
        Node node = new Node();
        node.next = null;
        node.data = data;

        if(head==null){
            head = node;
        }
        else{
            Node n = head;
            // Traverse to the end of list and insert.
            while(n.next != null){
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAtStart(int data){
        Node node = new Node();
        node.next = null;
        node.data = data;

        node.next = head;
        head = node;

    }

    public void insertAtIndex(int index, int data){
        Node node = new Node();
        node.next = null;
        node.data = data;

        if(index == 0){
            insertAtStart(data);
        }
        else{
            Node temp = head;

            for(int i=0; i<index-1; i++){
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;
        }
    }

    public void deleteAt(int index){
        Node temp;
        temp = head;
        try {
            for(int i=0; i<index-1; i++){
                temp = temp.next;
            }
            if(temp.next.next == null){
                temp.next = null;
            }
            else{
                temp.next = temp.next.next;
            }
        }
        catch (NullPointerException e) {
            System.out.println("Index Out of bounds error.");
        }

    }

    public void middle(){
        Node slow = head;
        Node fast = head;

        // Traverse the List with both the pointers
        while(fast != null && fast.next != null){
            if(fast.next.next == null){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle is "+ slow.data);
    }

    public void nthEndElement(int n){
        Node fast = head;
        Node slow = head;

        // Set fast to nth position
        while(n!=0){
            fast = fast.next;
            n--;
        }
        // traverse both fast and slow with 1
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println("Nth element is "+slow.data);
    }


    public void show(){
        Node node = head;
        while(node.next != null){
            System.out.print(" -> "+node.data);
            node = node.next;
        }
        System.out.println(" -> "+node.data);
    }
}
