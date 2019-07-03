import java.util.*;

public class Main {
    public static void main(String[] arg) {
        List<Laptop> laps = new ArrayList<>();
        laps.add(new Laptop("Dell", 8, 800));
        laps.add(new Laptop("Apple", 12, 1200));
        laps.add(new Laptop("Acer", 10, 700));

        System.out.println("Sort on Basis of Name using Comparable");
        Collections.sort(laps);
        System.out.println(laps.toString());

        System.out.println("Sort on basis of Ram using Comparator");
        MyComparator mCom = new MyComparator();
        Collections.sort(laps, mCom);
        System.out.println(laps.toString());
    }
}