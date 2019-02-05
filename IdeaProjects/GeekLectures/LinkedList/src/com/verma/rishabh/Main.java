package com.verma.rishabh;

public class Main {
    public static void main(String args[]){
        SinglyLinkedList SLL = new SinglyLinkedList();

        SLL.insert(5);
        SLL.insert(8);
        SLL.insert(12);
        SLL.insert(20);
        SLL.insert(32);
        SLL.insert(45);
        SLL.insert(89);

        //SLL.printList();
        //SLL.deleteNode(3);

        SLL.printList();
        SLL.midElement();
        SLL.getNthElement(2);

        SLL.reverseList();
        System.out.println("\nList After Reverse");
        SLL.printList1(SLL.head);

        /* Create Loop for Testing */
        SLL.head.next.next.next.next.next.next.next = SLL.head.next;
        int res = SLL.detectLoopInList();
        if(res == 1){
            System.out.println("\nLoop Found, Now Removing Loop");
            SLL.detectAndRemoveLoop();
        }
        else{
            System.out.println("No Loop found");
        }

        Delete_N_Nodes _delete_N_Nodes_ = new Delete_N_Nodes();
        _delete_N_Nodes_.delete_N_Node(2,2,SLL.head);
        SLL.printList();
    }
}
