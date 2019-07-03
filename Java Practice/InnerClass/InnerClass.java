public class InnerClass {
    private int myVar = 10;

    class MyInnerDemo {
        public void seeOuter() {
            System.out.println("Value of Outer class Private instance variable is " + myVar);
        }
    }

    public void innerInstance() {
        MyInnerDemo myInnerDemo = new MyInnerDemo();
        myInnerDemo.seeOuter();
    }

    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        ic.innerInstance();
    }
}