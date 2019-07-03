public class BNode {
    int key;
    BNode leftChild;
    BNode rightChild;

    BNode(int Mykey) {
        this.key = Mykey;
    }

    @Override
    public String toString() {
        return key + " ";
    }
}