class Main {
    public static void main(String[] args) {
        Animal[] a = { new Animal(), new Dog() };
        System.out.println(" ====== DownCasting ======");
        for (Animal animal : a) {
            animal.makeNoise();
            if (animal instanceof Dog) {
                // animal.eatPedigree();
                // Do a Down Casting to a more specific Dog method
                Dog d = (Dog) animal;
                d.dogFood();
            }
        }

        // Upcasting Test
        System.out.println(" ====== UpCasting ======");
        Dog d = new Dog();
        Animal a1 = d;
        a1.makeNoise();
        Animal a2 = (Animal) d;
        a2.makeNoise();
    }
}