import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// Q8 Find Leaves of Binary Tree
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while(root != null) {
            List list = new ArrayList<>();
            root = dfs(root, list);
            result.add(list);
        }
        return result;
    }

    public TreeNode dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = dfs(root.left, list);
        root.right = dfs(root.right, list);
        return root;
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
