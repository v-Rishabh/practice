public class DoublyList {
    private Node head;
    private Node tail;
    private int length;

    DoublyList() {
        this.head = null;
        this.tail = null;
        length = 0;
    }

    public boolean isEmpty() {
        if (length > 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getListLength() {
        return length;
    }

    public void displayForward() {
        System.out.println("\nPrinting from Head");
        if (head == null) {
            return;
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
        }
        System.out.print("null");
    }

    public void displayEnd() {
        System.out.println("\nPrinting from Tail");
        if (tail == null) {
            return;
        } else {
            Node temp = tail;
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.prev;
            }
        }
        System.out.print("null");
    }

    // Insert at begin
    public void insertAtBeg(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        length++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public Node removeFirstNode() {
        if (isEmpty()) {
            System.out.println("List is Empty");
        }
        Node temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        length--;

        return temp;
    }

    public static void main(String[] args) {
        DoublyList dl = new DoublyList();
        dl.insertAtBeg(1);
        dl.insertAtEnd(2);
        dl.insertAtEnd(3);
        dl.insertAtEnd(4);
        dl.insertAtEnd(5);
        dl.displayForward();
        dl.displayEnd();
        dl.removeFirstNode();
        dl.displayForward();
        dl.displayEnd();
    }
}