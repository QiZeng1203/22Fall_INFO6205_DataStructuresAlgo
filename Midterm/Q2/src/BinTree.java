public class BinTree <T> {
    public Node<T> root;

    public BinTree() {

    }

    public void populateParentNode() {
        if (root == null) {
            return;
        }
        dfs(root);
        return;

    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;

        if (left != null) {
            left.parent = root;
        }

        if (right != null) {
            right.parent = root;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
