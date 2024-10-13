package Tree;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        //When we have a base condition then directly return true. If both the left node and right node are null it means we are at the leaf node then simply return true. If not
        //then add the left node and right node and if they are equal call for left subtree and right subtree
        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(5);
        root.right.right = new Node(2);
        root.left.left = new Node(10);
        root.left.right = new Node(5);
        root.right.left = new Node(3);
        System.out.println(childrenSumProperty(root) ? "Yes" : "No");
    }

    private static boolean childrenSumProperty(Node root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;        //Leaf Node
        int sum = 0;
        if(root.left != null) sum += root.left.key;             //This two condition are required because there can be case when a node has only left or right children.
        if(root.right != null) sum += root.right.key;
        return (root.key == sum && childrenSumProperty(root.left) && childrenSumProperty(root.right));
    }
}
