package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeTree {
    //We can any technique to form the arraylist, technique like any preorder, postorder, inorder or level order traversal. Same technique we have to use while deserializing
    //Time Complexity is O(N) and Space Complexity is O(N). Question can be asked to convert into String as well
    public static int index = 0;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.right = new Node(60);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        List<Integer> serializeKeys = serializeTree(root);
        serializeKeys.forEach(key -> System.out.print(key + " "));
        deSerializeTree(serializeKeys);
        List<Integer> list = new ArrayList<>();
        serializeTreePreOrderTraversal(root, list);
    }

    //Preorder traversal for serialization
    private static void serializeTreePreOrderTraversal(Node root, List<Integer> list) {
        if(root == null) {
            list.add(-1);
            return;
        }
        list.add(root.key);
        serializeTreePreOrderTraversal(root.left, list);
        serializeTreePreOrderTraversal(root.right, list);
    }

    //use same traversal technique just check if the element is -1 it means we need to assign null to its current node left or right
    private static Node deSerializeTreePreOrderTraversal(List<Integer> list) {
        if(index == list.size()) return null;
        int val = list.get(index);
        index++;
        if(val == -1) return null;
        Node root = new Node(val);
        root.left = deSerializeTreePreOrderTraversal(list);
        root.right = deSerializeTreePreOrderTraversal(list);
        return root;
    }

    //This is level order traversal and code is bigger so we will use preorder traversal
    private static List<Integer> serializeTree(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> serializeKeys = new ArrayList<>();
        queue.add(root);
        serializeKeys.add(root.key);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node popElem = queue.poll();
                if(popElem.left != null) {
                    queue.add(popElem.left);
                    serializeKeys.add(popElem.left.key);
                } else {
                    serializeKeys.add(-1);
                }
                if(popElem.right != null) {
                    queue.add(popElem.right);
                    serializeKeys.add(popElem.right.key);
                } else {
                    serializeKeys.add(-1);
                }
            }
        }
        return serializeKeys;
    }

    private static void deSerializeTree(List<Integer> serializeKeys) {

    }

}
