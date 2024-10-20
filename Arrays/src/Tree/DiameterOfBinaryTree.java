package Tree;

public class DiameterOfBinaryTree {
    //Idea here is we will use height function to calculate the height of every node and at the same time we will calculate the diameter of a tree.

    public static int max = 0;
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(5);
        root.right.right = new Node(2);
        root.left.left = new Node(10);
        root.left.right = new Node(5);
        root.right.left = new Node(3);
        System.out.println(diameterOfTree(root));
    }

    private static int diameterOfTree(Node root) {
        if(root == null) return 0;
        int leftHeight = diameterOfTree(root.left);
        int rightHeight = diameterOfTree(root.right);
        max = Math.max(max, (leftHeight + rightHeight));   //Extra code added in height function to find the diameter of a tree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
