package LinkedList.CircularLinkedList;

public class CircularLinkedList {
    public static void main(String[] args) {
        Node head = null;
        Node tail = null;
        head = insertAtBeg(head, tail, 10);
        head = insertAtBeg(head, tail, 20);
        head = insertAtBeg(head, tail, 30);
        head = insertAtBeg(head, tail, 40);
        print(head);
    }

    private static Node insertAtBeg(Node head, Node tail, int item) {
        Node temp = new Node(item);
        if(head == null) {
            temp.next = temp;
            tail = temp;
            return temp;
        } else {

        }
        return null;
    }

    private static void print(Node head) {
        if(head == null) return;
        Node curr = head;
        do {
            System.out.println(curr.value);
            curr = curr.next;
        } while(curr != head);
    }
}
