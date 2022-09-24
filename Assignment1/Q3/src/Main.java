public class Main {

    public static void main(String[] args) {
	// Q3. Swapping Nodes in a Linked List(https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        swapNodes(head, 2);
        printList(head);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp;

        for(int i = 1; i < k; i++) {
            fast = fast.next;
        }

        temp = fast;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        int cur = slow.val;
        slow.val = temp.val;
        temp.val = cur;

        return head;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.printf(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }
}
