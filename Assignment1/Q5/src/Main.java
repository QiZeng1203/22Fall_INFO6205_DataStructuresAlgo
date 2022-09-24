public class Main {

    public static void main(String[] args) {
	// Q5. Insert into a Sorted Circular Linked List
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(6);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = head;

        insertSortedCircular(head, 3);
        printList(head);
    }

    public static Node insertSortedCircular(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if(head == null) {
            head = insert;
            head.next = head;
            return head;
        }

        if(head.next == null) {
            head.next = insert;
            head.next.next = head;
            return head;
        }

        Node front = head.next;
        Node back = head;
        while(front != head) {
            if(front.val >= insertVal && back.val <= insertVal) break;
                if(front.val < back.val) {
                    if(front.val > insertVal || back.val < insertVal) break;
                }
                front = front.next;
                back = back.next;
            }

            back.next = insert;
            insert.next = front;
            return head;
    }

    public static class Node{
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.printf(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }
}
