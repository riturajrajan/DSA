package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {
    //Idea here is we will attach a vertices to every node. Whenever we are going left we will decrement the vertices and whenever we are going right we will
    //increment the vertices and at the same time we need to check in the map. If key exists then the current node key else insert into map
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
        verticalSum(root, ds, 0);
        System.out.println(ds);
    }

    private static void verticalSum(Node root, Map<Integer, Integer> ds, int vertices) {
        if(root == null) return;
        if(ds.containsKey(vertices)) {
            ds.put(vertices, ds.get(vertices) + root.key);
        } else {
            ds.put(vertices, root.key);
        }
        verticalSum(root.left, ds, vertices - 1);
        verticalSum(root.right, ds, vertices + 1);
    }
}
