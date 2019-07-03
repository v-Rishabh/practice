import java.util.*;

class StockSPanTest {
    public static void main(String[] args) {
        unitTest();
    }

    static void unitTest() {
        StockSpan span = new StockSpan();
        int[] arr = { 100, 60, 70, 65, 80, 85 };
        ArrayList<Integer> al = new ArrayList<>();
        al = span.printSpan(arr);
        ArrayList<Integer> Expected = new ArrayList<>();
        Expected.add(1);
        Expected.add(1);
        Expected.add(2);
        Expected.add(1);
        Expected.add(4);
        Expected.add(5);

        if (al.equals(Expected)) {
            System.out.println("Unit Test passed.");
        } else {
            System.out.println("Test Failed.");
        }

        System.out.println("Stock Span is : " + al.toString());
    }
}