package com.verma.rishabh;

public class palindrome {
    Node head;

    public void isPalindrome(){
        // Get Middle
        Node mid = getMiddle();
        System.out.println("Middle Element of List");
        System.out.println(mid.data);
        // Reverse second half of list
        Node reversedHead = reverseList(mid);
        System.out.println("First Half of List");
        print(head);
        System.out.println("Second Half of List");
        print(reversedHead);
        // Compare both the half's of list
        boolean res = compareList(head,reversedHead);
        System.out.println("Is Palindrome? "+ res);

    }

    public Node getMiddle(){
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node reverseList(Node head){
        // Pointers
        Node current = head;
        Node previous = null;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;

        return head;
    }

    public boolean compareList(Node firstHead, Node secondHead){
        while(firstHead != null && secondHead != null){
            if(firstHead.data != secondHead.data)
                return false;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    public void print(Node head_){
        Node temp = head_;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("");
    }
}
