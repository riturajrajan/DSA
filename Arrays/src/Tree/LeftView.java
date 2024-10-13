package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    //We just need to print the left view of the tree which means we are standing left to tree and viewing it we don't need to print the right node which gets overlap with left node.
    //We will use breadth first search and whenever we have processed the left view we will increase the maxLevel which means at that level we have printed the left node and
    //no need to print the right node at the save level.
    public static int maxLevel = 0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.left.left = new Node(1);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(70);
        root.right.right.left.right = new Node(80);
        recursiveLeftView(root, 1);
        iterativeLeftView(root);
    }

    private static void recursiveLeftView(Node root, int level) {
        if(root == null) return;
        if(maxLevel < level) {     // we will have global variable which means when we go to right side of tree the left side is already processed because maxLevel was updated at next line
            System.out.println(root.key);
            maxLevel = level;
        }
        recursiveLeftView(root.left, level + 1);
        recursiveLeftView(root.right, level + 1);
    }

    private static void iterativeLeftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node elem = queue.poll();
                if(i == 0) System.out.println(elem.key);    //In queue we have node at the same level so when we are i = 0 which means the we are processing left node at that level
                if(elem.left != null) queue.add(elem.left);
                if(elem.right != null) queue.add(elem.right);
            }
        }
    }
}
