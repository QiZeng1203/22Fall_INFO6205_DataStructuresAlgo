import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// Q5 Binary Search Tree Iterator
    }

    class BSTIterator {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        public BSTIterator(TreeNode root) {
            TreeNode node = root;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            if(node.right != null) {
                TreeNode p = node.right;
                while(p != null) {
                    stack.push(p);
                    p = p.left;
                }
            }
            return node.val;

        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
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
