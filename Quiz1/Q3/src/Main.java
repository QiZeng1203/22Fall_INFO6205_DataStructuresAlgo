import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        List<Integer> tempList = new ArrayList<>();

        while(queue.size() !=0) {

            TreeNode node = queue.remove();
            if(node != null) {
                tempList.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            else {
                result.add(tempList);
                tempList = new ArrayList<>();
                if(queue.size() == 0) {
                    break;
                }
                queue.add(null);
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

