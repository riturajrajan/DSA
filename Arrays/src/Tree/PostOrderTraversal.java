package Tree;

public class PostOrderTraversal {
    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.right = new Node(30);
        tree.right.left = new Node(40);
        tree.right.right = new Node(50);
        postOrderTraversal(tree);
    }

    private static void postOrderTraversal(Node root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.key);
    }

}
