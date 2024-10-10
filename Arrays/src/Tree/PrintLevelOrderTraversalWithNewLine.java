package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrderTraversalWithNewLine {
    public static void main(String[] args) {

        //We push NULL when we are at the end of the current level. The while run for size() > 1 because at last only NULL and then we need to come out of the loop.
        //Time Complexity is O(N) but it O(N+H) as we are adding h NULL node, since h is smaller so, we ignore it and Space Complexity is O(W) where W is the width of the tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.right = new Node(60);
        root.left.left = new Node(8);
        root.left.right = new Node(7);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(15);
        levelOrderTraversal(root);
        System.out.println("===============");
        levelOrderTraversalApproach2(root);
    }

    //Approach 1: Here we are adding NULL at the end of the queue which is taking more space so, we can use Approach 2 in this case
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

    //Approach 2: In this we will use two loops. Outer loop will print the node and inner loop will enqueue the next level child. Time Complexity is O(N)
    private static void levelOrderTraversalApproach2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node curr = queue.poll();
                System.out.print(curr.key + " ");
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            System.out.println();
        }
    }
}
