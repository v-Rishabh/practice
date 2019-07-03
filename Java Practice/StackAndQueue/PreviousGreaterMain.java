public class PreviousGreaterMain {
    public static void main(String[] args) {
        int arr[] = { 10, 4, 2, 20, 40, 12, 30 };
        int n = arr.length;
        PGE pge = new PGE();
        pge.previousGreaterElement(arr, n);
    }

}