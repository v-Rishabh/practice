class Node{
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name){
        this.key = key;
        this.name = name;
    }
    Node(int key){
        this.key = key;
    }

    //@Override
    //public String toString(){
        //return name + " has a key "+ key;
    //}
    @Override
    public String toString(){
        return key+ " ";
    }
}
