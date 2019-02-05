class CreateList {
    Node head;

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        CreateList CL = new CreateList();
        CL.head = first;

        // Now Join the nodes to head.
        // CL.head.next = second; //OR
        first.next = second;
        second.next = third;

        // Print the list
        CL.printList();
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}