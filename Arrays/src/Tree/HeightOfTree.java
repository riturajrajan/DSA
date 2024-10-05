package Tree;

public class HeightOfTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(70);
        System.out.println(heightOfTree(root));
    }

    private static int heightOfTree(Node root) {
        if(root == null) return 0;
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }
}
