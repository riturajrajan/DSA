package Tree;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.left.left = new Node(1);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(70);
        root.right.right.left.right = new Node(80);
        lowestCommonAncestor(root);
    }

    private static void lowestCommonAncestor(Node root) {

    }
}
