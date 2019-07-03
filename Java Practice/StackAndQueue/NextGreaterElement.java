import java.util.*;

public class NextGreaterElement {

    static void printNextGreater(int[] arr, int len) {
        Stack<Integer> st = new Stack<>();
        int element;
        int next;
        // Add the first element to stack
        st.push(arr[0]);

        // Traverse the array from 1...lenght of array
        for (int i = 1; i < len; i++) {
            next = arr[i];

            // If stack is not empty then pop()
            if (!st.isEmpty()) {
                element = st.pop();
                while (element < next) {
                    System.out.println(element + " -> " + next);
                    if (st.isEmpty()) {
                        break;
                    }
                    element = st.pop();
                }

                if (element > next) {
                    st.push(element);
                }
            }
            st.push(next);
        }

        while (!st.isEmpty()) {
            element = st.pop();
            next = -1;
            System.out.println(element + " -> " + next);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNextGreater(arr, n);
    }
}