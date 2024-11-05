package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountNodeInCompleteBinaryTree {
    //Complete Tree is a Tree where the right height and left height from a particular node is equal and we can find the total node inside this tree by using formula 2^h-1
    //where h is the height of the complete tree. Let say is the tree is not complete from a particular node then we again check for root.left and root.right. Since we are
    //going left and right so we need to add 1 because we want total count of the nodes inside a tree.
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.right = new Node(70);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        System.out.println(countNodes(root));
    }

    private static int countNodes(Node root) {
        Node curr = root;
        int lh = 0, rh = 0;
        while(curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while(curr != null) {
            rh++;
            curr = curr.right;
        }
        if(lh == rh) return (int)Math.pow(2, lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
