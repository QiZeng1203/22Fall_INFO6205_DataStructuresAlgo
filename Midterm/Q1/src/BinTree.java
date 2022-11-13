public class BinTree <T> {
    public Node<T> root;

    public BinTree() {

    }

    public void populateNextLeft() {
        if (root == null) {
            return;
        }
        dfs(root);
        return;
    }
    public static void dfs(Node root) {
        if (root == null) {
            return;
        }

        Node left = root.left;
        Node right = root.right;

        while(right != null) {
            right.nextLeft = left;
            right = right.left;
            left = left.right;
        }
        dfs(root.left);
        dfs(root.right);

    }
}