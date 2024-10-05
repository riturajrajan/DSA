package Tree;

public class InorderTraversal {
    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.right = new Node(30);
        tree.right.left = new Node(40);
        tree.right.right = new Node(50);
        inOrderTraversal(tree);
    }

    private static void inOrderTraversal(Node root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.key);
        inOrderTraversal(root.right);
    }
}
