public class Main {

    public static void main(String[] args) {
	// Q4. Split Linked List in Parts (https://leetcode.com/problems/split-linked-list-in-parts/)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        ListNode[] result = splitListToParts(head, 5);
        for(int i = 0; i < 5; i++) {
            printList(result[i]);
        }
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode p = head;

        while(p != null) {
            p = p.next;
            length ++;
        }

        int quotient = length / k;
        int remainder = length % k;

        ListNode[] result = new ListNode[k];

        p = head;
        int num;
        for(int i = 0; i < k && p != null; i++) {
            result[i] = p;
            if(i < remainder) {
                num = quotient + 1;
            }
            else {
                num = quotient;
            }

            for(int j = 1; j < num; j++) {
                p = p.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        return result;

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
