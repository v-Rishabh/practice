import java.util.*;

class PGE {
    Stack<Integer> st = new Stack<>();
    int element;
    int next;

    /**
     * Add First element to stack, and print -1 for it. Add the next item in array
     * to local variable next. Match : If next is greater than stack-Top If true :
     * Print next -> Current Stack Top Push next to stack. If false: print next ->
     * current stack top i++;
     */

    public void previousGreaterElement(int[] arr, int len) {
        st.push(arr[0]);
        System.out.println(arr[0] + " --> -1");

        // If stack is empty or not
        if (!st.isEmpty()) {
            for (int i = 1; i < len; i++) {
                next = arr[i];
                element = st.peek();

                if (next > element) {
                    System.out.println(next + " --> " + element);
                    st.push(next);
                } else if (next < element) {
                    System.out.println(next + " --> " + element);
                }
            }
        }
    }
}