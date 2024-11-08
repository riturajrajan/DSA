package Tree;

public class CeilingInBST {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.right.right = new Node(80);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.left.right = new Node(65);
        root.right.left.left = new Node(55);
        System.out.println(findCeiling(root, 63).key);
    }

    private static Node findCeiling(Node root, int num) {
        Node res = null;
        while(root != null) {
            if(root.key == num) {
                return root;
            } else if(num < root.key){
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
