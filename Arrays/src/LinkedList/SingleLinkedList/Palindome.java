package LinkedList.SingleLinkedList;

public class Palindome {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 21);
        head = insertAtEnd(head, 21);
        head = insertAtEnd(head, 10);
        printNode(head);
        Node mid = findMiddle(head);
        Node res = reverseNode(mid.next);
        mid.next = res;
        System.out.println(checkPalindrome(head, res));

    }

    private static boolean checkPalindrome(Node head, Node res) {
        while(res != null) {
            if(head.value != res.value)
                return false;
            res = res.next;
            //head = head.next;
        }
        return true;
    }

    public static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static Node reverseNode(Node res) {
        Node prev = null, curr = res, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
