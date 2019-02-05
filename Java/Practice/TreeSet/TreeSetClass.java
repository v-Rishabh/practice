import java.util.*;

public class TreeSetClass {
    static TreeSet<Integer> ts = new TreeSet<>();

    public static void main(String[] args) {
        ts.add(20);
        ts.add(150);
        ts.add(10);
        ts.add(40);
        ts.add(15);

        System.out.println("TreeSet size :" + ts.size());
        System.out.println("Smallest element is : " + ts.first());
        System.out.println("Largest Element is : " + ts.last());

        System.out.println("Printing all the elements of TreeSet");
        Iterator itr = ts.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println("\n------- Elements Greater than (15) -------");
        System.out.println(ts.tailSet(15).toArray().length - 1 + " elements higher than 15");
    }
}