
import java.util.*;

class MyList {
    private static ArrayList<Integer> al = new ArrayList<>();
    private static int MAX_SIZE = 5;
    boolean notifyAdded = false;

    public synchronized void addElement(int i) {
        if (notifyAdded) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        // Add data to list.
        al.add(i);
        System.out.println("Added : " + i + " by " + Thread.currentThread().getName());
        notifyAdded = true;
        notify();
    }

    public synchronized void getElement() {
        if (!notifyAdded) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        // Remove from list.
        int rem = al.remove(0);
        System.out.println("Removed : " + rem + " by " + Thread.currentThread().getName());
        notifyAdded = false;
        notify();
    }

    public synchronized void addElementAll(int i) {
        while (al.size() >= MAX_SIZE) {

            try {
                System.out.println("List Full, Waiting for consumer to remove oldest element.");
                wait();
            } catch (Exception e) {
            }
        }
        al.add(i);
        System.out.println("Added : " + i + " by " + Thread.currentThread().getName());
        notify();
    }

    public synchronized void getOldestElement() {
        while (al.size() != MAX_SIZE) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        int rem = al.remove(0);
        System.out.println("Removed : " + rem + " by " + Thread.currentThread().getName());
        notify();
    }

    public synchronized void getAllElement() {
        while (al.size() != MAX_SIZE) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        while (al.size() != 0) {
            int rem = al.remove(0);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println("Removed : " + rem + " by " + Thread.currentThread().getName());
        }
        notify();
    }
}

class Producer implements Runnable {
    MyList ML = new MyList();

    public Producer(MyList ML) {
        this.ML = ML;
        Thread t1 = new Thread(this, "Producer");
        t1.start();
    }

    public void run() {
        int i = 1;
        while (true) {
            // ML.addElement(i++);
            ML.addElementAll(i++);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

class Consumer implements Runnable {
    MyList ML = new MyList();

    public Consumer(MyList ML) {
        this.ML = ML;
        Thread t2 = new Thread(this, "Consumer");
        t2.start();
    }

    public void run() {
        while (true) {
            // ML.getElement();
            // ML.getOldestElement();
            ML.getAllElement();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        MyList ML = new MyList();
        Producer p = new Producer(ML);
        Consumer C = new Consumer(ML);
        // new Producer(ML);
        // new Consumer(ML);
    }
}