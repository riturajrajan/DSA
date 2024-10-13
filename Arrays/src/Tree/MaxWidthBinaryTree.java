package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(5);
        root.right.right = new Node(2);
        root.left.left = new Node(10);
        root.left.right = new Node(5);
        root.right.left = new Node(3);
        System.out.println(maxWidth(root));
    }

    private static int maxWidth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int max = -1;
        queue.add(root);
        if(root == null) return -1;
        while(queue.isEmpty() == false) {
            int size = queue.size();
            max = Math.max(max, size);
            for(int i = 0; i < size; i++) {
                Node elem = queue.poll();
                if(elem.left != null) queue.add(elem.left);
                if(elem.right != null) queue.add(elem.right);
            }
        }
        return max;
    }
}
