import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) {
	// Q2 Convert Binary Search Tree to Sorted Doubly Linked List
    }

    class Solution {
        Node first;
        Node pre;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            dfs(root);
            first.left = pre;
            pre.right = first;
            return first;
        }

        public void dfs(Node node) {
            if(node == null) return;
            dfs(node.left);
            if(first == null) {
                first = node;
            }
            if(pre == null) {
                pre = node;
            }
            else {
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            dfs(node.right);
        }
    }

    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


}
