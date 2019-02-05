package com.verma.rishabh;

public class Main {

    public static void main(String[] args){
        singlyMethodsTest();
        SLL_Loop();
        reverseTest();
        checkPalindrome();
    }

    public static void singlyMethodsTest(){
        SinglyLinkedList SLL = new SinglyLinkedList();
        SLL.insertAtEnd(10);
        SLL.insertAtEnd(20);
        SLL.insertAtEnd(30);
        SLL.insertAtHead(5);
        SLL.print(SLL.head);
        SLL.insertAtPos(25,2);
        SLL.print(SLL.head);
        SLL.deleteElementAtPos(3);
        SLL.print(SLL.head);
        SLL.insertAtHead(15);
        SLL.print(SLL.head);
        SLL.printMiddleNode();
        SLL.printNthElementFromEnd(3);
    }

    public static void SLL_Loop(){
        SinglyLinkedListLoop list = new SinglyLinkedListLoop();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next = list.head.next.next;
        list.detectAndRemoveLoop();
        System.out.println("Linked List after removing loop : ");
        list.print(list.head);
    }

    public static void reverseTest(){
        ReverseList RL = new ReverseList();
        RL.head = new Node(1);
        RL.head.next = new Node(2);
        RL.head.next.next = new Node(3);
        RL.head.next.next.next = new Node(4);
        System.out.println("List Before Reverse :");
        RL.print(RL.head);
        RL.reverseList(RL.head);
        System.out.println("List After Reverse :");
        RL.print(RL.head);

        // Reverse again to get the original list back
        RL.reverseList(RL.head);

        // Adding more nodes to list.
        RL.head.next.next.next.next = new Node(5);
        RL.head.next.next.next.next.next  = new Node(6);
        RL.head.next.next.next.next.next.next = new Node(7);
        RL.head.next.next.next.next.next.next.next = new Node(8);
        RL.head.next.next.next.next.next.next.next.next = new Node(9);
        // Print New List before K group reverse
        System.out.println("List Before K group Reverse :");
        RL.print(RL.head);
        // Reverse list in K groups
        RL.head = RL.reverseK_GroupOfNodes(RL.head, 3);
        System.out.println("List After K group Reverse :");
        RL.print(RL.head);

    }

    public static void checkPalindrome(){
        palindrome RL = new palindrome();
        RL.head = new Node(1);
        RL.head.next = new Node(2);
        RL.head.next.next = new Node(3);
        RL.head.next.next.next = new Node(2);
        RL.head.next.next.next.next = new Node(1);

        System.out.println("Palindrome List print");
        RL.print(RL.head);

        RL.isPalindrome();

    }
}
