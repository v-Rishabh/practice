public class StaticNested {
    static class Inner {
        public void myInnerMethod() {
            System.out.println("This is Inner Method");
        }
    }

    public static void main(String[] args) {
        StaticNested.Inner nested = new StaticNested.Inner();
        nested.myInnerMethod();
    }
}