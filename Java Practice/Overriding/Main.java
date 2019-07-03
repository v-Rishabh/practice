class Main {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Horse(); // Animal reference, but Horse object.
        // This derives that the OBJECT type determines which method will run and not
        // the REFERENCE type.
        a.eat(); // Runs Animal's class eat method.
        b.eat(); // Runs Horse Class eat method.

        // b.getName(); This will not work with a Animal Reference Type.
        // Note : the compiler will allow only methods in class Animal to be invoked
        // when using a reference to an Animal.

        // Calling Super method from subclass
        Horse h = new Horse();
        System.out.println("Calling super.eat() from Horse Class => ");
        h.printSuperEatMethod();

        String name = h.getName();
        System.out.print(name);
    }
}
