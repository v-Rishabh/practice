package com.verma.rishabh;

public class OddEven {
    Node head;
    public void getEvenOdd(){
        Node head_odd = null;
        Node tail_odd = null;
        Node head_even = null;
        Node tail_even = null;
        Node current = head;

        while(current != null && current.next != null){
            // Check Value for Even odd
            if(current.data % 2 == 0){
                head_even = current;
            }
        }
    }
}
