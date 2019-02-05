public class TreeView {
    int max_level = 0;

    public void leftView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (max_level < level) {
            System.out.print(root.key + " ");
            max_level = level;
        }
        leftView(root.LC, level + 1);
        leftView(root.RC, level + 1);
    }

    public void rightView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (max_level < level) {
            System.out.print(root.key + " ");
            max_level = level;
        }
        leftView(root.RC, level + 1);
        leftView(root.LC, level + 1);
    }
}