class ChildClass extends AbstractClass {
    public double insterestRate() {
        double d = 10.5D;
        return d;
    }

    @Override
    public void accountNumber() {
        super.accountNumber();
        System.out.println("SBI's 16 digit account number");
    }

    public static void main(String[] args) {
        ChildClass cc = new ChildClass();
        double d = cc.insterestRate();
        System.out.println("Interest Rate = " + d);
        cc.accountNumber();
    }
}