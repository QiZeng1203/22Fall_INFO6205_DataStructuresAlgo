public class Main {

    public static void main(String[] args) {
	// Q6 Serialize and Deserialize BST
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        dfs1(root, sb);
        return sb.toString();
    }

    public void dfs1(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append((char) root.val);
        dfs1(root.left, sb);
        dfs1(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) {
            return null;
        }
        return dfs2(0, data.length()-1, data);

    }

    public TreeNode dfs2(int l, int r, String data) {
        if(l > r) return null;
        int j = l+1;
        int t = data.charAt(l);
        TreeNode result = new TreeNode(t);
        while(j <= r && data.charAt(j) <= t) {
            j++;
        }
        result.left = dfs2(l+1, j-1, data);
        result.right = dfs2(j, r, data);
        return result;
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
