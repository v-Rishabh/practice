class Main {
    public static void main(String[] args) {
        // Human Obj refrence and Human Object.
        Human human = new Human();
        Human.walk();
        // Boy Obj ref. and Boy Obj
        Boy boy = new Boy();
        Boy.walk();

        human.walk();
        human.eats();
        boy.walk();
        boy.eats();

        // Human obj ref and Boy obj.
        Human human1 = new Boy();
        // [Static Binding at Compiletime]
        human1.walk();
        // [Dynamic Binding at Runtime]
        human1.eats();
    }
}