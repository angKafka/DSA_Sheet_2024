package linkedlist.problem;

public class Sort012s {
    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node segregate(Node head) {
        if (head == null) return null;

        int count0 = 0, count1 = 0, count2 = 0;
        Node curr = head;

        // Step 1: Count the occurrences of 0s, 1s, and 2s
        while (curr != null) {
            if (curr.data == 0) count0++;
            else if (curr.data == 1) count1++;
            else if (curr.data == 2) count2++;
            curr = curr.next;
        }

        // Step 2: Modify the linked list based on the counts
        curr = head;
        while (count0-- > 0) {
            curr.data = 0;
            curr = curr.next;
        }
        while (count1-- > 0) {
            curr.data = 1;
            curr = curr.next;
        }
        while (count2-- > 0) {
            curr.data = 2;
            curr = curr.next;
        }

        return head;
    }
}
