package Tree;

public class NodeAtKDistance {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(70);
        int distance = 2;
        printNodeAtKDistance(root, distance);
    }

    private static void printNodeAtKDistance(Node root, int distance) {
        if(root == null) return;
        if(distance == 0) {
            System.out.println(root.key);
            return;
        }
        printNodeAtKDistance(root.left, distance - 1);
        printNodeAtKDistance(root.right, distance - 1);
    }
}
