
public class DeadLock {
    public static void main(String[] args) {
        final String resource1 = "Printer";
        final String resource2 = "Scanner";

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " : locked " + resource1);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource2) {
                        System.out.println(Thread.currentThread().getName() + " : locked " + resource2);
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " : locked " + resource2);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                }
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " : locked " + resource1);
                }
                // } //Removing Deadlock
                /**
                 * Deadlock: Laptop locked scanner and Desktop locked printer. Now both are
                 * waiting.. Desktop for Scanner to get free and get a lock on it. Laptop for
                 * printer to get free and get a lock on it.
                 */
            }
        });

        t1.setName("Desktop");
        t2.setName("Laptop");

        t1.start();
        t2.start();
    }
}