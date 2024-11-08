package Tree;

public class FloorInBST {
    public static void main(String[] args) {
        //BST is a tree where the left side is always smaller and right side is bigger. Idea here is to find the floor which means if the same key is present then
        //return it, if the num is greater than root it means we have to go right and find bigger node and at the same time update the result as well.
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.right.right = new Node(80);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.left.right = new Node(65);
        root.right.left.left = new Node(55);
        System.out.println(findFloor(root, 58).key);
    }

    private static Node findFloor(Node root, int num) {
        Node res = null;
        while(root != null) {
            if(root.key == num) {
                return root;
            } else if(num < root.key){
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }
}
