import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// Q5 Binary Tree Vertical Order Traversal
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> posQueue = new LinkedList<>();
        posQueue.offer(0);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int minPos = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int pos = posQueue.poll();
            List<Integer> list = map.getOrDefault(pos, new LinkedList<>());
            list.add(node.val);
            map.put(pos,list);

            if(node.left != null) {
                queue.offer(node.left);
                posQueue.offer(pos - 1);
            }
            if(node.right != null) {
                queue.offer(node.right);
                posQueue.offer(pos + 1);
            }
            minPos = Math.min(minPos, pos);
        }
        for(int i = minPos; i < minPos + map.size(); i++) {
            result.add(map.get(i));
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
