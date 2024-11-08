package Tree;

import java.util.ArrayDeque;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.right = new Node(30);
        tree.right.left = new Node(40);
        tree.right.right = new Node(50);
        preOrderTraversal(tree);
    }

    private static void preOrderTraversal(Node root) {
        if(root == null) return;
        System.out.println(root.key);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //Time Complexity is O(N) and space complexity is O(N) since we are pushing every node into the stack
    private static void iterativePreOrderTraversal(Node root) {
        if(root == null) return;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node popElem = stack.pop();
            System.out.println(popElem.key);
            if(popElem.right != null) stack.push(popElem.right);
            if(popElem.left != null) stack.push(popElem.left);
        }
    }

    //Time Complexity is O(N) and space complexity is O(H) since we will push only right child because we will be printing left
    private static void iterativePreOrderTraversalOptimized(Node root) {
        if(root == null) return;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.println(curr.key);
                if(curr.right != null) stack.push(curr.right);
                curr = curr.left;
            }
            if(!stack.isEmpty()) curr = stack.pop();
        }
    }
}
