class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        int c1 = a1.getIntanceCount();
        System.out.println("Instance Count : " + c1);

        Animal a2 = new Animal();
        int c2 = a2.getIntanceCount();
        System.out.println("Instance Count : " + c2);
    }
}