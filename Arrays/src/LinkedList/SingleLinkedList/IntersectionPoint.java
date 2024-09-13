package LinkedList.SingleLinkedList;

public class IntersectionPoint {
    public static void main(String[] args) {
        Node head1 = null;
        head1 = insertAtEnd(head1, 5);
        head1 = insertAtEnd(head1, 8);
        head1 = insertAtEnd(head1, 7);
        head1 = insertAtEnd(head1, 10);
        head1 = insertAtEnd(head1, 12);
        head1 = insertAtEnd(head1, 15);
        printNode(head1);

        Node head2 = null;
        head2 = insertAtEnd(head2, 9);
        createIntersection(head1, head2, 10);
        printNode(head2);
        intersectionPointCheck(head1, head2);
    }

    //Idea here is we will find the count of both the list and find abs(c1-c2). This will tell how many nodes we have to skip from bigger list to remove uncommon list and then
    //start the pointer from both the list at same time. Now we will get intersection point. Time Complexity: O(m+n). Space Complexity: O(1)
    private static void intersectionPointCheck(Node head1, Node head2) {
        int count1 = 0, count2 = 0;
        Node curr1 = head1, curr2 = head2;
        while(curr1 != null) {
            count1++;
            curr1 = curr1.next;
        }
        while(curr2 != null) {
            count2++;
            curr2 = curr2.next;
        }
        int abs = Math.abs(count1 - count2);
        curr1 = head1;
        curr2 = head2;
        if(count1 > count2) {
            for(int i = 0; i < abs; i++) {
                curr1 = curr1.next;
            }
        } else {
            for(int i = 0; i < abs; i++) {
                curr2 = curr2.next;
            }
        }
        while (curr1 != null || curr2 != null) {
            if(curr1 == curr2) {
                System.out.println("Intersection point is " + curr1.value);
                return;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        System.out.println("No Intersection point");
    }

    private static void createIntersection(Node head1, Node head2, int intersectionValue) {
        Node curr1 = head1, curr2 = head2, intersectionNode = null;
        while (curr1.next != null) {                           //Iterate over any of the linked list to find the intersection point and then iterate over second list till end and link them
            if(curr1.value == intersectionValue) {
                intersectionNode = curr1;
                break;
            }
            curr1 = curr1.next;
        }
        if(intersectionNode != null) {
            while(curr2.next != null) {
                curr2 = curr2.next;
            }
            curr2.next = intersectionNode;    //Joining two links here
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
