package Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSpiralTraversal {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(5);
        root.right.right = new Node(2);
        root.left.left = new Node(10);
        root.left.right = new Node(5);
        root.right.left = new Node(3);
        //myWayspiralTraversal(root);
        bestApproach(root);
    }

    //We will maintain two stack. Stack 1 contains children of stack2 in reverse order while stack2 contains children of stack1 in correct order. In this case we are
    //processing evert items twice for pushing and popping so Time Complexity is O(2N) = O(N)
    private static void bestApproach(Node root) {
        ArrayDeque<Node> stack1 = new ArrayDeque<>();
        ArrayDeque<Node> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node elem = stack1.pop();
                System.out.print(elem.key + " ");
                if(elem.left != null) stack2.push(elem.left);
                if(elem.right != null) stack2.push(elem.right);
            }
            System.out.println();
            while(!stack2.isEmpty()) {
                Node elem = stack2.pop();
                System.out.print(elem.key + " ");
                if(elem.right != null) stack1.push(elem.right);
                if(elem.left != null) stack1.push(elem.left);
            }
            System.out.println();
        }
    }

    //In my approach i am processing the item thrice. One for enqueuing and dequeueing and then reverse the queue which takes O(N) and then processing on that reverse queue and
    //then enqueuing and dequeuing children. So Time Complexity is O(3N) = O(N)
    private static void myWayspiralTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int height = 1;
        queue.add(root);
        while (queue.isEmpty() == false) {
            int size = queue.size();
            height += 1;
            for(Node elem : queue) System.out.print(elem.key + " ");
            reverseQueue(queue);
            for(int i = 0; i < size; i++) {
                Node elem = queue.poll();
                if(height % 2 == 0) {
                    if(elem.right != null) queue.add(elem.right);
                    if(elem.left != null) queue.add(elem.left);
                } else {
                    if(elem.left != null) queue.add(elem.left);
                    if(elem.right != null) queue.add(elem.right);
                }
            }
        }
    }

    private static void reverseQueue(Queue<Node> queue) {
        if(queue.isEmpty()) return;
        Node front = queue.poll();
        reverseQueue(queue);
        queue.add(front);
    }
}
