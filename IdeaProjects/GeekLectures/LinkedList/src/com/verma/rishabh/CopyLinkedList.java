package com.verma.rishabh;
// Copy linked list with arbitrary pointers
public class CopyLinkedList {
    //Node_CLL start;

    public void cloneList(Node_CLL start){
        Node_CLL current = start;
        Node_CLL temp = current;

        while(current != null){
            temp = current.next_cll;

            //Insert Node after every node.
            current.next_cll = new Node_CLL(current.data);
            current.next_cll.next_cll = temp;
            current = temp;
        }

        current = start;

        // Adjust Random pointers
        while(current != null){
            current.next_cll.random = current.random.next_cll;
            //current = current.next_cll ? current.next_cll.next_cll:current.next_cll;
        }

    }
}
