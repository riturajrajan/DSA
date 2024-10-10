package Tree;

public class SizeOfTree {
    public static void main(String[] args) {
        //we will use recursion and go to left tree and right tree and add them. Time Complexity is O(N) and Space Complexity is O(H)
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(70);
        System.out.println(sizeOfTree(root));
    }

    private static int sizeOfTree(Node root) {
        if(root == null) return 0;
        return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
    }
}
