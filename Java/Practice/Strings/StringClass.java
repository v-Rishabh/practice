public class StringClass {
    public static void main(String[] args) {
        StringBuffer sf = new StringBuffer("Rishabh");
        sf.append(" Verma");
        System.out.println(sf.toString());
        sf.replace(0, 7, "Oscar");
        System.out.println(sf.toString());
        String sub = (sf.substring(0, 5));
        System.out.println(sub);
        for (int i = 0; i < sf.length(); i++) {
            System.out.print(sf.charAt(i) + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < sf.length(); i++) {
            System.out.print((int) sf.charAt(i) + ",");
        }
        System.out.println("\n");

        String test = "This is a test string for testing subtring method";
        String sub2 = test.substring(0, 14);
        System.out.println(sub2);
        sf.delete(0, 6);
        System.out.println(sf.toString());
    }

}