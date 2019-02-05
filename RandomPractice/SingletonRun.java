public class SingletonRun {
    public static void main(String[] args) {
        // Create instance of singleton class.
        Singleton obj1 = Singleton.getInstance();
        System.out.println("Instance Count : " + obj1.getInstanceCount());
        Singleton obj2 = Singleton.getInstance();
        System.out.println("Instance Count : " + obj2.getInstanceCount());
    }

}