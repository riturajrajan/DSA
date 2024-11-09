package Tree;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewBinaryTree {
    //We will use same vertical Traversal and do level order traversal. Since we are doing level order traversal, we want bottom view, so we need to override the map
    //at every level if the key exists. If key is not there then simply add into the ds
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
        bottomView(root, ds, 0);
        System.out.println(ds);
    }

    private static void bottomView(Node root, Map<Integer, Integer> ds, int verticalDistance) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, verticalDistance));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.verticesDistance;
            ds.put(hd, curr.key);
            if(curr.left != null) queue.add(new Pair(curr.left, hd - 1));
            if(curr.right != null) queue.add(new Pair(curr.right, hd + 1));
        }
    }
}
