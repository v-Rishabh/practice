import java.util.*;

public class StockSpan {
    public ArrayList<Integer> printSpan(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        // Add First element to stack.
        st.push(0);
        // Print 1 for the first element as it has no preceding element.
        result.add(1);

        int arrLen = arr.length;
        for (int i = 1; i < arrLen; i++) {
            int current = arr[i];
            // If Previous element is greater than current, Just print 1 and add current to
            // stack.
            if (arr[st.peek()] > current) {
                result.add(1);
                st.push(i);
            }
            // Else if Previous is smaller than current, then keep popping from stack util a
            // greater element is found. Add the diffrence[span] to stack and result list.
            else {
                while (arr[st.peek()] < current) {
                    // Edge condition : When no preceding element is greater than current.
                    if (st.size() > 1) {
                        st.pop();
                    } else {
                        break;
                    }
                }
                // Count Span
                int count = i - st.peek();
                result.add(count);
                st.push(i);
            }
        }
        // System.out.println("Stock Span is : " + result.toString());
        return result;
    }
}