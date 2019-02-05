public class MethodLocal {
    private int x = 1;

    // Method:
    public void doThings() {
        String name = "Local Variable";
        class myInnerClass {
            public void seeOuter() {
                System.out.println("Outer Value of x is :" + x);
                System.out.println("Value of name is : " + name);// Only final local variable can be accesed
            }
        }
        myInnerClass inner = new myInnerClass();
        inner.seeOuter();
    }// doThings END

    public static void main(String[] args) {
        MethodLocal ml = new MethodLocal();
        ml.doThings();
    }
}