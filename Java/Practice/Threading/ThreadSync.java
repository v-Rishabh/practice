public class ThreadSync {
    private static int count = 0;

    public static synchronized void incrementCount() {
        count++;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    incrementCount();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    incrementCount();
                }
            }
        });

        // Start the thread
        t1.start();
        t2.start();

        // Join the thread so that each thread waits for the other one to complete.

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Count is : " + count);
    }
}