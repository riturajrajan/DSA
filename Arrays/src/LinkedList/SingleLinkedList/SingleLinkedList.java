package LinkedList.SingleLinkedList;

public class SingleLinkedList {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 21);
        head = insertAtEnd(head, 33);
        head = insertAtEnd(head, 40);
        head = insertAtEnd(head, 60);
        head = insertAtEnd(head, 50);
        printNode(head);
        head= insertAtPos(2, 15, head);
        printNode(head);
        head = deleteFirstNode(head);
        printNode(head);
        head = deleteLastNode(head);
        printNode(head);
        //System.out.println(search(head, 30));
        head = reverseNode(head);
        printNode(head);
        head = reverseNodeRecursive(head);
        printNode(head);

    }

    private static Node insertAtBeg(Node head, int val) {
        Node temp = new Node(val);
        temp.next = head;
        return temp;
    }

    private static Node insertAtPos(int pos, int item, Node head) {
        Node temp = new Node(item);
        if(pos == 1) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        for(int i = 1; i < (pos - 1) && curr != null; i++) {
            curr = curr.next;
        }
        if(curr == null) return head;
        temp.next = curr.next;
        curr.next = temp;
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

    public static Node deleteFirstNode(Node head) {
        if(head == null) {
            return null;
        } else {
            return head.next;
        }
    }

    public static Node deleteLastNode(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public static int search(Node head, int item) {
        if(head == null) return -1;
        if(head.value == item) return 1;
        int res = search(head.next, item);
        return (res == -1) ? -1 : (res+1);
    }

    public static Node reverseNode(Node head) {
        if(head == null) return null;
        Node curr = head, prev = null;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node reverseNodeRecursive(Node head) {
        if(head == null || head.next == null) return head;
        Node rest_head = reverseNodeRecursive(head.next);
        Node rest_tail = head.next;
        head.next = null;
        rest_tail.next = head;
        return rest_head;
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
