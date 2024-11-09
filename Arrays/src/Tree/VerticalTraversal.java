package Tree;

import java.util.*;

public class VerticalTraversal {
    //We have to use only level order traversal for this problem because we have to print the parent vertices first followed by children. We need to maintain the vertices
    //and the key so we need to create a wrapper Pair class.
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.right = new Node(25);
        root.left.left = new Node(35);
        root.left.left.left = new Node(40);
        root.left.right = new Node(20);
        root.left.right.right = new Node(75);
        root.left.right.right.right = new Node(80);
        Map<Integer, List<Integer>> ds = new TreeMap<>();
        verticalTraversal(root, ds);
        System.out.println(ds);
    }

    private static void verticalTraversal(Node root, Map<Integer, List<Integer>> ds) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.verticesDistance;
            if(ds.containsKey(hd)) {
                ds.get(hd).add(curr.key);
            } else {
                List<Integer> keys = new ArrayList<>();
                keys.add(curr.key);
                ds.put(hd, keys);
            }
            if(curr.left != null) queue.add(new Pair(curr.left, hd - 1));
            if(curr.right != null) queue.add(new Pair(curr.right, hd + 1));
        }
    }
}

class Pair {
    Node node;
    int verticesDistance;

    public Pair(Node node, int verticesDistance) {
        this.node = node;
        this.verticesDistance = verticesDistance;
    }
}
