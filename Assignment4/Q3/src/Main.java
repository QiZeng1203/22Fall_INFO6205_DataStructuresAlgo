public class Main {

    public static void main(String[] args) {
	// Q3 Validate Binary Search Tree
    }
    class Solution {
        TreeNode max;
        public boolean isValidBST(TreeNode root) {
            if(root == null) {
                return true;
            }
            boolean left = isValidBST(root.left);
            if(!left) {
                return false;
            }
            if(max != null && root.val <= max.val) {
                return false;
            }
            max = root;
            boolean right = isValidBST(root.right);
            return right;
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
