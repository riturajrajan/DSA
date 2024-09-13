package LinkedList.SingleLinkedList;

public class EvenOddAtEnd {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 11);
        head = insertAtEnd(head, 21);
        head = insertAtEnd(head, 33);
        printNode(head);
        head = evenOdd(head);
        printNode(head);
    }

    //Idea here is we will make a separate odd list and even list. We will have even start pointer which points to start and end will be adding the element at the last. Same goes
    //to odd. Now the head will be even start pointer and we need to connect two list now by evenEnd.next = oddStart;
    private static Node evenOdd(Node head) {
        if(head == null || head.next == null) return head;
        Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null, curr = head;
        while(curr != null) {
            if(curr.value % 2 == 0) {
                if(evenStart == null) {
                    evenEnd = evenStart = curr;
                } else {
                    evenEnd.next = curr;
                    evenEnd = curr;
                }
            } else {
                if(oddStart == null) {
                    oddEnd = oddStart = curr;
                } else {
                    oddEnd.next = curr;
                    oddEnd = curr;
                }
            }
            curr = curr.next;
        }
        if(evenStart == null || oddStart == null) return head;   // When the list has only odd list or even the list has only even list
        evenEnd.next = oddStart;                                 //connecting two list together
        oddEnd.next = null;
        return evenStart;
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
