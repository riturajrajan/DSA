package Tree;

public class BinaryTreeToDoubleLinkedList {

    //We are not using any extra space we are modifying the tree itself. We are using inorder traversal so we go to extreme left and when we are the current node we have
    // to something and then call for right subtree. If we see prev = null it means we need to mark it as head and if prev is not null then we have to play with pointers
    //and at the end we need to mark prev as root so then in next iteration we can link it up.

    public static Node prev = null;

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(5);
        root.right.right = new Node(2);
        root.left.left = new Node(10);
        root.left.right = new Node(5);
        root.right.left = new Node(3);
        listFormation(root);
    }

    private static Node listFormation(Node root) {
        if(root == null) return root;
        Node head = listFormation(root.left);
        if(prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        listFormation(root.right);
        return head;
    }
}
