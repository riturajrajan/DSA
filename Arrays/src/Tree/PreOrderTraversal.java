package Tree;

public class PreOrderTraversal {
    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.right = new Node(30);
        tree.right.left = new Node(40);
        tree.right.right = new Node(50);
        preOrderTraversal(tree);
    }

    private static void preOrderTraversal(Node root) {
        if(root == null) return;
        System.out.println(root.key);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
