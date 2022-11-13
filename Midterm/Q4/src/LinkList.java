public class LinkList  {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
    }

    public void insert(Integer data){
        // Insert in sorted manner
        Node newNode = new Node(data);
        Node dummy = new Node(-1);
        dummy.next = head;
        Node current = dummy;
        while(current.next != null) {
            if (current.next.data > data) {
                Node temp = current.next;
                current.next = newNode;
                newNode.next = temp;
                break;
            }
            else {
                current = current.next;
            }
        }
    }
}
