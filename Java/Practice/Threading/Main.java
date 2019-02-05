public class Main {
    public static void main(String[] args) {
        // === Extends Thread ===
        ThreadDemo TD = new ThreadDemo();
        TD.start();

        ThreadDemo TD1 = new ThreadDemo();
        TD1.start();

        // === Implements Runable ===
        Thread t1 = new Thread(new ThreadRunable());
        Thread t2 = new Thread(new ThreadRunable());

        t1.start();
        t2.start();

        // === Short method ===
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getId() + " Value " + i);
                }
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
    }
}
