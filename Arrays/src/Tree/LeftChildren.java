package Tree;

public class LeftChildren {

    //We will traverse the left child and set the flag to true to know that this is the left child and for right tree we set as false so that we know that we are
    //processing right child.
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.left.left = new Node(1);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(70);
        leftChildren(root, true);
    }

    private static void leftChildren(Node root, boolean isLeft) {
        if(root == null) return;
        if(isLeft) {
            System.out.println(root.key);
        }
        leftChildren(root.left, true);
        leftChildren(root.right, false);
    }
}
