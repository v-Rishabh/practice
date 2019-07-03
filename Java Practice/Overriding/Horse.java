public class Horse extends Animal {
    private String name = "Murcialago";

    @Override
    public void eat() {
        System.out.println("A Horse eating hay");
    }

    public String getName() {
        return name;
    }

    public void printSuperEatMethod() {
        super.eat();
    }
}