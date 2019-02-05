final public class immutable {
    // This class is avaibale to all for communication so marked a public.
    // But this class cannot be extended so marked as final.

    // Declare all properties and variables are marked private.
    // Do not provide setters for the class.

    // Innitialize all the values to variables through constructors.

    private final int a;

    public immutable(int a) {
        this.a = a;
    }

    public int getVal() {
        return a;
    }
}