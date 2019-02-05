class Main {
    public static void main(String[] args) {
        System.out.println("====== LinkedList Practice ======");
        SinglyList SLL = new SinglyList();

        System.out.println("====== Insert at Begining ======");
        SLL.insertAtFront(10);
        SLL.insertAtFront(5);
        SLL.printList(SLL.head);

        System.out.println("====== Insert at End ======");
        SLL.insertAtEnd(30);
        SLL.insertAtEnd(40);
        SLL.printList(SLL.head);

        System.out.println("====== Insert at any position ======");
        SLL.insertAtPosition(25, 2);
        SLL.printList(SLL.head);

        System.out.println("====== Delete at any position ======");
        SLL.deleteAnyPosition(2);
        SLL.printList(SLL.head);

        System.out.println("====== Middle Node of List ======");
        System.out.println("=== Even Length List ===");
        SLL.printMiddle();
        SLL.printList(SLL.head);

        System.out.println("=== Odd Length List ===");
        SLL.insertAtEnd(50);
        SLL.printMiddle();
        SLL.printList(SLL.head);

        System.out.println("=== Nth element from end ===");
        SLL.printNthElementFromEnd(2);

        System.out.println("=== Reversed List ===");
        SLL.reverseList();
        SLL.printList(SLL.head);

        System.out.println("====== Print Final LinkedList ======");
        SLL.printList(SLL.head);

        System.out.println("=== Create Loop in list ===");
        SinglyList listLoop = new SinglyList();
        listLoop.head = new Node(50);
        listLoop.head.next = new Node(20);
        listLoop.head.next.next = new Node(15);
        listLoop.head.next.next.next = new Node(4);
        listLoop.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        listLoop.head.next.next.next.next = listLoop.head.next.next;

        listLoop.detectAndRemoveLoop();
        System.out.println("=== Printing After removing loop from list ===");
        listLoop.printList(listLoop.head);
    }
}