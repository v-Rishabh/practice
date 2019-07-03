public class Animal {

    // Static Variable : Maintains same copy with all class instances.
    static int instanceCount;

    // Static Intantiation Block : Runs once only when the class gets loaded first
    // to the JVM.
    static {
        instanceCount = 100;
    }

    // Intantiation Block : Runs when class get instantiated.
    {
        instanceCount++;
    }

    public void eat() {
        System.out.println("Generic Animal Eat Method.");
    }

    public int getIntanceCount() {
        return instanceCount;
    }
}