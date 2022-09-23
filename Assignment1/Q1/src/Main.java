public class Main {

    public static void main(String[] args) {
	// Q1 Rotate List
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = rotateRight(head, 2);
        printList(newHead);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        int length = 1;

        while(fast.next != null) {
            fast = fast.next;
            length ++;
        }

        for(int i = 1; i < length - k%length; i++) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    public static class ListNode{
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.printf(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

}
