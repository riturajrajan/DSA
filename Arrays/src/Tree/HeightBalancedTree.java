package Tree;

public class HeightBalancedTree {
    public static void main(String[] args) {
        //Question: Check from any node if the height of left subtree - height of right subtree <= 1.
        //Approach: Parent node will call for left subtree and left subtree will tell whether it is balanced or not. If not then return -1 else call for right subtree. If it is
        //balanced then return height of the current node which will be used by its parent to determine whether it is balanced or not. So, we are doing two things checking if the
        //tree is balanced and returning the height of the current node.
        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(5);
        root.right.right = new Node(2);
        root.left.left = new Node(10);
        root.left.right = new Node(5);
        root.right.left = new Node(3);
        System.out.println(balancedHeightTree(root) == -1 ? "Yes" : "No");
    }

    private static int balancedHeightTree(Node root) {
        if(root == null) return 0;
        int leftTree = balancedHeightTree(root.left);       //Left subtree telling whether i am balanced or not
        if(leftTree == -1) return -1;
        int rightTree = balancedHeightTree(root.left);      //Right subtree telling whether i am balanced or not
        if(rightTree == -1) return -1;
        if(Math.abs(leftTree - rightTree) > 1) return -1;   //If the difference is greater than 1 then return -1
        else return Math.max(leftTree, rightTree) + 1;      //Else return the height of the current node
    }
}
