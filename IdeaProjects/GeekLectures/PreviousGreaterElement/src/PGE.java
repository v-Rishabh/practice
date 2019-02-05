import java.util.Stack;

public class PGE {
    public void previousGreaterElement(int[] arr){
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        System.out.println("Previous Greater for "+arr[0]+" is -1");

        int arrLen = arr.length;
        for(int i=1; i<arrLen; i++){
            while(st.isEmpty() == false && st.peek() < arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                System.out.println("Previous Greater for "+arr[i]+" is -1");
            }
            else{
                System.out.println("Previous Greater for "+arr[i]+" is "+st.peek());
            }
            st.push(arr[i]);
        }
    }
}
