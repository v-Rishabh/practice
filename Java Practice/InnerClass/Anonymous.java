abstract class Pizza {
    public abstract void eat();
}

public class Anonymous extends Pizza {
    public static void main(String[] args) {
        Pizza p = new Pizza() {
            @Override
            public void eat() {
                System.out.println("Anonymous Pizza");
            }
        };

        p.eat();
    }
}
