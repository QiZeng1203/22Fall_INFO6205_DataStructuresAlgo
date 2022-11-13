public class Main {

    public static void main(String[] args) {
	// write your code here
        Node<Integer> tree = getBST();
        valueRangeInBST( tree, 5, 8);

    }

    // Given range between 5 and 8 it will print 6, 8
    private static Node<Integer> getBST(){
        Node<Integer> root = new Node<>(8);

        root.left = new Node<>(3);
        root.right = new Node<>(10);

        root.left.left = new Node<>(1);
        root.left.right = new Node<>(6);

        root.right.right = new Node<>(14);

        root.left.right.left = new Node<>(4);
        root.left.right.right = new Node<>(17);

        root.right.right.left = new Node<>(13);

        return root;
    }

    public static void valueRangeInBST(Node<Integer> root, int low, int high) {
        if(root == null) {
            return;
        }

        if(root.data > low) {
            valueRangeInBST(root.left, low, high);
        }

        if(root.data >= low && root.data <= high) {
            System.out.println(root.data);
        }

        valueRangeInBST(root.right, low, high);

    }

}
