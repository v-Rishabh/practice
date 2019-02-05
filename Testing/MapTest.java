import java.util.*;

public class MapTest {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void addData() {
        map.put(1, 24);
        map.put(2, 25);
        map.put(3, 26);
        map.put(4, 27);
        map.put(5, 28);
        map.put(6, 29);
        map.put(7, 30);
    }

    public static void main(String[] args) {
        System.out.println(map);
        addData();
        System.out.println(map);
        map.forEach((k, v) -> System.out.println(k + " --> " + v));

        if (map.containsKey(2)) {
            System.out.println(map.get(2));
        }

        for (Integer k : map.keySet()) {
            System.out.println(map.get(k));
        }

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        Iterator itr = al.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        ListIterator lItr = al.listIterator();

        while (lItr.hasNext()) {
            System.out.print(lItr.next() + " ");
        }
        System.out.print("\n");

        while (lItr.hasPrevious()) {
            System.out.print(lItr.previous() + " ");
        }
    }
}