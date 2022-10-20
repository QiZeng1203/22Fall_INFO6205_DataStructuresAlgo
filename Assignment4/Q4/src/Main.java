public class Main {

    public static void main(String[] args) {
	// Q4 Recover Binary Search Tree
    }

    class Solution {
        TreeNode firstMax = null;
        TreeNode lastMin = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        public void recoverTree(TreeNode root) {
            inOrder(root);
            if(firstMax != null && lastMin != null) {
                int temp = firstMax.val;
                firstMax.val = lastMin.val;
                lastMin.val = temp;
            }
        }

        public void inOrder(TreeNode root) {
            if(root == null) {
                return;
            }
            inOrder(root.left);
            if(root.val < pre.val) {
                lastMin = root;
                if(firstMax == null) {
                    firstMax = pre;
                }
            }
            pre = root;
            inOrder(root.right);
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
