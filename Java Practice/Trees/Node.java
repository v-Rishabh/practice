public class Node {
    int key;
    Node LC;
    Node RC;

    Node(int key) {
        this.key = key;
        LC = null;
        RC = null;
    }
}