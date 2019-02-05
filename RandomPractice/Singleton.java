public class Singleton {
    // Step 1: Create a Static Object of this class.
    static Singleton single = new Singleton();
    private int instanceID = 0;

    // Step 2: Make the constructor private
    private Singleton() {
        instanceID++;
    }

    // Step 3: Create a static method to get the instance of this class.
    public static Singleton getInstance() {
        return single;
    }

    public int getInstanceCount() {
        return instanceID;
    }
}