import java.util.*;

public class CharArray {
    public static void main(String[] args) {
        char[] arr = new char[256];
        String str = "ABC";
        for (int i = 0; i < str.length(); i++) {
            int counter = str.charAt(i);
            arr[(int) counter]++;
        }
        for (char c : arr) {
            System.out.print((int) c + " ");
        }
    }
}