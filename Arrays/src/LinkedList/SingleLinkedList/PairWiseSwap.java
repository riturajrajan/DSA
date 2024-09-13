package LinkedList.SingleLinkedList;

public class PairWiseSwap {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 8);
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 12);
        head = insertAtEnd(head, 20);
        printNode(head);
        head = swapInPair(head);
        printNode(head);
    }

    //We need to handle two nodes prior because head will change to head.next. Once we are done with this we go inside loop and point curr next to prev next because they will be
    //swapped. Before entering into the loop join the link by prev.next = curr.next;
    private static Node swapInPair(Node head) {
        if(head == null || head.next == null) return head;
        Node prev = head, curr = head.next.next, next;
        head = head.next;
        head.next = prev;
        while(curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;   //If some nodes are left then using this line they will be connected to the link. For even it will be null and for odd it will be last ndoe
        return head;
    }

    public static Node insertAtEnd(Node head, int value) {
        Node temp = new Node(value);
        if(head == null) return temp;
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    public static void printNode(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
        System.out.println();
    }
}
