package com.verma.rishabh;

public class main {
    public static void main(String[] args){
        System.out.println("We are up and running!");
        _LinkedList_ list = new _LinkedList_();

        list.insert(5);
        list.insert(10);
        list.insert(35);
        list.insert(22);
        list.insert(30);
        list.insert(87);
        //list.insert(90);
        //list.insertAtStart(101);
        //list.insertAtIndex(2,300);

        list.show();
        list.middle();
        list.nthEndElement(2);
        //list.deleteAt(2);

        //list.show();
        //list.deleteAt(4);
        //list.show();


    }
}
