import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// Q1 Convert Sorted List to Binary Search Tree
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return new TreeNode(head.val);
        }

        List<Integer> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }

        return buildTree(0, arr.size()-1, arr);

    }

    public TreeNode buildTree(int left, int right, List<Integer> arr) {
        if(left > right) { return null; }
        int mid = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildTree(left, mid-1, arr);
        root.right = buildTree(mid+1, right, arr);
        return root;
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
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
