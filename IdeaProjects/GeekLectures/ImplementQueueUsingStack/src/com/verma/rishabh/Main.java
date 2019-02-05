package com.verma.rishabh;

public class Main {
    public static void main(String[] args){
        Queue Q = new Queue();
        System.out.println("Is Queue Empty? "+Q.isEmpty());
        Q.enqueue(10);
        Q.enqueue(20);
        Q.enqueue(30);
        Q.enqueue(40);
        Q.dequeue();
        Q.dequeue();
        Q.enqueue(50);
        Q.dequeue();
        System.out.println("Is Queue Empty? "+Q.isEmpty());
        Q.dequeue();
        Q.dequeue();
        System.out.println("Is Queue Empty? "+Q.isEmpty());
        Q.enqueue(60);
        Q.enqueue(70);
        System.out.println("Is Queue Empty? "+Q.isEmpty());

        Q.dequeue();
        Q.dequeue();
    }
}
