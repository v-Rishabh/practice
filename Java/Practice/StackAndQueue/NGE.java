import java.util.*;

public class NGE {
    public void nextGreaterElement(int[] arr, int len) {
        // Stack<Integer> st = new Stack<>();
        MyStack st = new MyStack();
        int element;
        int next;
        // Push first element of array to stack.
        st.push(arr[0]);

        for (int i = 1; i < len; i++) {
            next = arr[i];
            // Check if stack has element.
            if (!st.isEmpty()) {
                element = st.pop();

                while (element < next) {
                    System.out.println(element + " --> " + next);
                    if (st.isEmpty()) {
                        break;
                    }
                    element = st.pop();
                }
                // If element popped from stack is not greater than next, push it back to stack.
                if (element > next) {
                    st.push(element);
                }
            }
            // Push next to stack.
            st.push(next);
        }
        // Elements left in array have none next greater element.
        while (!st.isEmpty()) {
            int elementPopped = st.pop();
            System.out.println(elementPopped + " -- > -1");
        }
    }
}