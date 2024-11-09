package Tree;

import java.util.*;

public class TopViewBinaryTree {
    //We will use the vertical traversal technique and if the key is already present no need to insert any other node because we are doing level order traversal and
    //top view are already added in the ds.
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.right = new Node(25);
        root.left.left = new Node(35);
        root.left.left.left = new Node(40);
        root.left.right = new Node(20);
        root.left.right.right = new Node(75);
        root.left.right.right.right = new Node(80);
        Map<Integer, Integer> ds = new TreeMap<>();
        topView(root, ds);
        System.out.println(ds);
    }

    private static void topView(Node root, Map<Integer, Integer> ds) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.verticesDistance;
            if(!ds.containsKey(hd)) {
                ds.put(hd, curr.key);
            }
            if(curr.left != null) queue.add(new Pair(curr.left, hd - 1));
            if(curr.right != null) queue.add(new Pair(curr.right, hd + 1));
        }
    }
}