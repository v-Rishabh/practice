import java.util.*;
import java.io.*;

public class MyComparator implements Comparator<Laptop> {
    public int compare(Laptop l1, Laptop l2) {
        int l1_Ram = l1.getRam();
        int l2_Ram = l2.getRam();
        return l1_Ram - l2_Ram;
    }
}