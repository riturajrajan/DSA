package LinkedList.SingleLinkedList;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedList {
    public static void main(String[] args) {
        Node head = null;
        cloneNode(head);
    }

    //Approach1: We will use hashmap to store the original list and the cloned list then iterate over the original list and then pointer to point in clone node. Time Complexity:
    //O(N) and space complexity is O(N)
    private static Node cloneNode(Node head) {
        Node curr = head;
        Map<Node, Node> mapp = new HashMap<>();
        while(curr != null) {
            mapp.put(curr, new Node(curr.value));   //storing the cloned list with original key
        }
        curr = head;
        while(curr != null) {
            Node clone = mapp.get(curr);
            clone.next = mapp.get(curr.next);
        }
        return mapp.get(head);
    }
}
