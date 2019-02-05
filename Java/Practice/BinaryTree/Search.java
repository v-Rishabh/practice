public class Search{
    public BNode searchElement(BNode root, int key){
        if(root == null || root.key == key){
            return root;
        }
        else{
            if(root.key < key){
                return searchElement(root.rightChild,key);
            }
            else{
                return searchElement(root.leftChild,key);
            }
        }
    }
}