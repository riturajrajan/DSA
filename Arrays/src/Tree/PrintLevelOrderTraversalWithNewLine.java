package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrderTraversalWithNewLine {
    public static void main(String[] args) {

        //We push NULL when we are at the end of the current level. The while run for size() > 1 because at last only NULL and then we need to come out of the loop.
        //Time Complexity is O(N) and Space Complexity is O(W) where W is the width of the tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.right = new Node(60);
        root.left.left = new Node(8);
        root.left.right = new Node(7);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(15);
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(Node root) {
        if(root == null) return;
        Queue<Node> levelQueue = new LinkedList<>();
        Node elem = null, dummy = null;
        levelQueue.add(root);
        levelQueue.add(dummy);
        while (levelQueue.size() > 1) {
            elem = levelQueue.poll();
            if (elem == null) {
                System.out.println();
                levelQueue.add(dummy);
            } else {
                System.out.print(elem.key + "  ");
                if (elem.left != null) {
                    levelQueue.add(elem.left);
                }
                if (elem.right != null) {
                    levelQueue.add(elem.right);
                }
            }
        }
    }
}
