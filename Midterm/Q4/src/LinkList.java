public class LinkList  {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    public void insert(Integer data){
        // Insert in sorted manner
        Node newNode = new Node(data);
        Node dummy = new Node(-1);
        dummy.next = head;
        Node pointer = dummy;
        while(pointer != null || pointer.next != null) {
            if(pointer.data < data) {
                pointer = pointer.next;
            }
            else if(pointer.data >= data && pointer.next.data <= data) {
                Node temp = pointer.next;
                pointer.next = newNode;
                newNode.next = temp;
            }
            else {
                newNode.next = pointer;
            }
        }

    }
}
