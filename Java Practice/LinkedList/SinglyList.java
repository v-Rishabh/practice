
class SinglyList {
    Node head;

    // Insert a Node at front of Linked List
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        // Base condition : If list is empty
        if (head == null) {
            head = newNode;
        } else {
            // If list is not empty
            newNode.next = head;
            head = newNode;
        }
    }

    // Insert at end of list
    public void insertAtEnd(int data) {
        // Traverse the list till end
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Insert at any position
    public void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        // Traverse to position
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        // Set the pointers
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete element at any position
    public void deleteAnyPosition(int position) {
        // Traverse List to the position
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp.next.next == null) {
            temp.next = null;
        } else {
            temp.next = temp.next.next;
        }
    }

    // Print Middle of Linked List
    public void printMiddle() {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println("Middle node is : " + slow.data);
    }

    // Print nth element from end of list
    public void printNthElementFromEnd(int n) {
        Node fast = head;
        Node slow = head;
        int counter = n - 1;
        while (counter != 0) {
            if (fast.next == null) {
                System.out.println("ERROR: Supplied position is greater than length of list.");
                return;
            } else {
                fast = fast.next;
                counter--;
            }
        }
        // Now traverse both the pointers
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // print the data of slow pointer
        System.out.println(n + " element from end is : " + slow.data);
    }

    // Reverse a list.
    public void reverseList() {
        Node current = head;
        Node next = null;
        Node prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Find and remove a loop in list.
    public void detectAndRemoveLoop() {
        Node fast = head;
        Node slow = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If loop found
            if (slow == fast) {
                // Loop Found : Reset the slow pointer to head to remove the loop.
                System.out.println("Loop Found.");
                slow = head;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // Remove Loop
                fast.next = null;
            }
        }
    }

    // Print List
    public void printList(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(" ");
    }
}