import java.util.*;

public class maxSumSubSet {
    int input[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
    int max_so_far = 0;
    int max_ending_here = 0;
    int start = 0;
    int end = 0;
    int s = 0;

    public ArrayList<Integer> returnMax() {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            max_ending_here = max_ending_here + input[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = s + 1;
            }
        }
        res.add(max_so_far);
        res.add(start);
        res.add(end);
        return res;
    }

    public static void main(String[] args) {
        maxSumSubSet mss = new maxSumSubSet();
        ArrayList<Integer> myList = mss.returnMax();
        System.out.println(
                "Total Sum: " + myList.get(0) + ", Start Index: " + myList.get(1) + ", End Index: " + myList.get(2));
    }
}