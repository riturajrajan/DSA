package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BurnTreeFromLeaf {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.right.right = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.left.right.right = new Node(4);
        root.left.right.left = new Node(7);
        Queue<Node> queue = new ArrayDeque<>();
        burnTreeFromAnyNode(root, 2, queue);
        //There can be chance that queue contains some element so, we need to process the node and burn the child node
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node burnCurrNode = queue.poll();
                System.out.println(burnCurrNode.key);
                if (burnCurrNode.left != null) queue.add(burnCurrNode.left);
                if (burnCurrNode.right != null) queue.add(burnCurrNode.right);
            }
        }
    }

    private static int burnTreeFromAnyNode(Node root, int burnNode, Queue<Node> queue) {
        if (root == null) return 0;
        if (root.key == burnNode) {
            System.out.println(burnNode);
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
            return 1;
        }
        //We will see if the burNode is present in left or right. If it is present in left then we need to store its children and then return 1. If 1 is returned from left call
        //it means node was present in left tree and we need to pop from queue and see their children. Since node was on left so we need to store it right children which can be done
        //at line 50. Same goes to right call
        int leftBurn = burnTreeFromAnyNode(root.left, burnNode, queue);
        if(leftBurn == 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node burnCurrNode = queue.poll();
                System.out.println(burnCurrNode.key);
                if (burnCurrNode.left != null) queue.add(burnCurrNode.left);
                if (burnCurrNode.right != null) queue.add(burnCurrNode.right);
            }
            if(root.right != null) queue.add(root.right);
            System.out.println(root.key);
            return 1;
        }
        int rightBurn = burnTreeFromAnyNode(root.right, burnNode, queue);
        if(rightBurn == 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node burnCurrNode = queue.poll();
                System.out.println(burnCurrNode.key);
                if (burnCurrNode.left != null) queue.add(burnCurrNode.left);
                if (burnCurrNode.right != null) queue.add(burnCurrNode.right);
            }
            if(root.left != null) queue.add(root.left);
            System.out.println(root.key);
            return 1;
        }
        return 0;
    }
}
