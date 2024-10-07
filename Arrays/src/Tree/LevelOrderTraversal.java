package Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {

        //Idea here is we will enqueue the root first and then calling the function which will pop out the element, print it and then enqueue at the end of queue which basically
        //means enqueuing next level child. Time Complexity is O(N) and Space Complexity is O(W) where W is the width of the tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.right = new Node(60);
        root.left.left = new Node(8);
        root.left.right = new Node(7);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(15);
        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        levelOrderTraversal(levelQueue);
    }

    private static void levelOrderTraversal(Queue<Node> levelQueue) {
        Node elem = null;
        while (levelQueue.size() > 0) {
            elem = levelQueue.poll();
            System.out.println(elem.key);
            if (elem.left != null) {
                levelQueue.add(elem.left);
            }
            if (elem.right != null) {
                levelQueue.add(elem.right);
            }
        }
    }
}
