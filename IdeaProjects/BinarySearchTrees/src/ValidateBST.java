public class ValidateBST {
    public boolean isValidBST(Node root) {
        Node prev = null;

        if(root != null){
            if(!isValidBST(root.leftChild)){
                return false;
            }
            if(prev !=null && root.key <= prev.key){
                return false;
            }

            prev = root;

            return isValidBST(root.rightChild);
        }
        return true;
    }
}
