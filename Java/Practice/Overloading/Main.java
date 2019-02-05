class Main {
    public static void main(String[] args) {
        UseAnimal ua = new UseAnimal();
        Animal a = new Animal();
        Horse h = new Horse();
        System.out.println("Passing Animal reference object");
        ua.doStuff(a);
        System.out.println("Passing Horse reference object");
        ua.doStuff(h);

        // What if you use an Animal reference to a Horse object?
        /**
         * Aplicable for OVERLOADING only and not for OVERRIDING.
         * 
         * The choice of which overloaded method to call (in other words, the signature
         * of the method) is NOT dynamically decided at runtime. Just remember, the
         * reference type (not the object type) determines which overloaded method is
         * invoked!
         */
        System.out.println("Passing Animal reference to horse Object");
        Animal aniObj = new Horse();
        ua.doStuff(aniObj);

        // Try Overriding with Animal reference pointing to Horse Object.
        /**
         * In OVERRIDING the object decides which method would be called and not the,
         * reference variable.
         */
        System.out.println("Invoking EAT() using Animal reference pointing to Horse Object");
        aniObj.eat();

    }
}