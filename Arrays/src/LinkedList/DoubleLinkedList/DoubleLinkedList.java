package LinkedList.DoubleLinkedList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        Node head = null;
        Node insertHead = insertAtEnd(head, 10);
        insertHead = insertAtEnd(insertHead, 20);
        insertHead = insertAtEnd(insertHead, 30);
        insertHead = insertAtEnd(insertHead, 40);
        printNode(insertHead);
        insertHead = reverseNode(insertHead);
        printNode(insertHead);
    }

    public static Node insertAtEnd(Node head, int item) {
        Node temp = new Node(item);
        if(head == null) return temp;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        temp.prev = curr;
        curr.next = temp;
        return head;
    }

    public static Node reverseNode(Node head) {
        if(head == null) return null;
        Node curr = head;
        head.prev = head.next;
        curr = head.next;
        head.next = null;
        while(curr != null) {

        }
        return null;
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
