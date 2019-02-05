package com.verma.rishabh;

/* Delete N nodes after every M nodes in given Linked List.
        m = 2, n = 2
        I/P: 1->2->3->4->5->6
        O/P: 1->2->5->6
        */
public class Delete_N_Nodes {
    public void delete_N_Node(int m, int n, Node head) {
        Node curr = head;
        Node del;
        int count;
        while (curr.next != null){
            // Skip nodes
            for (count = 0; count < m-1 && curr != null; count++) {
                curr = curr.next;
                //System.out.print(curr.data+" ");
            }
            del = curr;
            for (int count_n = 0; count_n < n && del != null; count_n++) {
                del = del.next;
            }
            if(del.next != null) {
                curr.next = del.next;
            }
            else{
                curr.next = null;
            }
            curr = del;
        }
    }
}