package Tree;

public class MaxInTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(70);
        System.out.println(maxInTree(root));
    }

    //Time Complexity: O(N) and Space Complexity: O(H)
    private static int maxInTree(Node root) {
        if(root == null) return -1;
        return Math.max(root.key, (Math.max(maxInTree(root.left), maxInTree(root.right))));
    }

    //We can use iterative solution as well. We need to maintain a queue and every element we pop out just we need to do Max with max variable. If the tree is skewed then
    //iterative solution will perform bad but when the tree is perfect tree then iterative will perform bad. So it depends on the tree we are using.
    //Time Complexity: O(N) and Space Complexity: O(W)
}
