import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// Q6 Maximum Width of Binary Tree
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        q.add(root);
        list.add(1);
        int result = 1;
        while(!q.isEmpty()) {
            int count =q.size();
            for(int i = count; i > 0; i--) {
                TreeNode cur = q.poll();
                Integer curIndex = list.removeFirst();
                if(cur.left != null) {
                    q.offer(cur.left);
                    list.add(curIndex *2);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                    list.add(curIndex *2 + 1);
                }
            }
            if(list.size() >= 2) {
                result = Math.max(result, list.getLast() - list.getFirst() +1);
            }
        }
        return result;

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
