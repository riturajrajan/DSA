package LinkedList.SingleLinkedList;

public class MergeSortedList {
    //Idea here is we check which head data is smaller that will become the head of main list and we need to maintain a tail pointer. We will do comparison between two current
    //nodes and attach to tail and move ahead
    public static void main(String[] args) {
        Node head1 = null, head = null, tail = null;
        head1 = insertAtEnd(head1, 10);
        head1 = insertAtEnd(head1, 20);
        head1 = insertAtEnd(head1, 25);
        head1 = insertAtEnd(head1, 40);

        printNode(head1);

        Node head2 = null;
        head2 = insertAtEnd(head2, 5);
        head2 = insertAtEnd(head2, 6);
        head2 = insertAtEnd(head2, 30);
        printNode(head2);
        if(head1.value > head2.value) {
            head = tail = head2;
            head2 = head2.next;
        } else {
            head = tail = head1;
            head1 = head1.next;
        }
        mergeList(head1, head2, tail);
        printNode(head);
    }

    private static void mergeList(Node head1, Node head2, Node tail) {
        while(head1 != null && head2 != null) {
            if(head1.value < head2.value) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if(head1 == null) {
            tail.next = head2;
        }
        if(head2 == null) {
            tail.next = head1;
        }
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
