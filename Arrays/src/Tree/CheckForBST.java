package Tree;

public class CheckForBST {
    public static void main(String[] args) {
        //Idea here is we will maintain a range for every node. For a particular node it should be smaller than left side and greater than right side. Time Complexity is O(N)
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.right.right = new Node(80);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.left.right = new Node(65);
        root.right.left.left = new Node(55);
        System.out.println(checkForBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(checkForBSTApproach2(root));
    }

    //Approach 1: Here we are maintaining range for every node
    private static boolean checkForBST(Node root, int minValue, int maxValue) {
        if(root == null) return true;
        return root.key > minValue &&
                root.key < maxValue &&
                checkForBST(root.left, minValue, root.key) &&
                checkForBST(root.right, root.key, maxValue);
    }

    //Approach 2: Here we will do inorder traversal and maintain a prev value. If current node is greater than prev before making right call then left sub tree is sorted
    // before making right call we will update the prev value
    private static int prev = Integer.MIN_VALUE;
    private static boolean checkForBSTApproach2(Node root) {
        if(root == null) return true;
        if(!checkForBSTApproach2(root.left)) return false;
        if(root.key <= prev) return false;
        prev = root.key;
        return checkForBSTApproach2(root.right);
    }
}
