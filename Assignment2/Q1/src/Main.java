public class Main {

    public static void main(String[] args) {
	// Q1

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }

        return dfs(root.left, root.right);

    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);

    }

    public static class TreeNode {
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
