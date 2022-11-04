import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// Q7 Inorder Successor in BST
    }

    public TreeNode inOderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || ! stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode n = stack.pop();
            if (pre == p) {
                return n;
            }
            pre = n;
            root = n.right;
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
