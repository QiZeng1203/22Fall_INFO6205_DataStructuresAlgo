import java.util.*;

public class Main {

    public static void main(String[] args) {
	// Q4 Binary Tree Zigzag Level Order Traversal
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        boolean bPrint = true;
        Stack<TreeNode> stack =  new Stack<>();
        List<Integer> tempList = new ArrayList<>();

        while(queue.size() !=0) {
            TreeNode node = queue.remove();
            if(node != null) {
                if(bPrint) {
                    tempList.add(node.val);
                }
                else {
                    stack.push(node);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            else {
                while(!stack.empty()) {
                    tempList.add(stack.pop().val);
                }
                result.add(tempList);
                tempList = new ArrayList<>();
                if(queue.size() == 0) {
                    break;
                }
                queue.add(null);
                bPrint = !bPrint;
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
