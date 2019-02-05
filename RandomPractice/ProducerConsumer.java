import java.lang.*;

class Q {
    private int num;
    boolean valueSet = false;

    public synchronized void setNum(int num) {
        while (valueSet) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("Set :" + num + " by " + Thread.currentThread().getName());
        this.num = num;
        valueSet = true;
        notify();
    }

    public synchronized void getNum() {
        while (!valueSet) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("Get :" + num + " by " + Thread.currentThread().getName());
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable {
    Q q = new Q();

    public Producer(Q q) {
        this.q = q;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.setNum(i++);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

class Consumer implements Runnable {
    Q q = new Q();

    public Consumer(Q q) {
        this.q = q;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        while (true) {
            q.getNum();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }

}

public class ProducerConsumer {
    public static void main(String[] args) {
        Q q = new Q();
        //Producer p = new Producer(q);
        //Consumer c = new Consumer(q);
        // Annonymous Instansiation
        new Producer(q);
        new Consumer(q);
    }
}