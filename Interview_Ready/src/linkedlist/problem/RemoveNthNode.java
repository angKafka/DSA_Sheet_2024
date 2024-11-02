package linkedlist.problem;

public class RemoveNthNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // First pass: Determine the size of the list
        ListNode curr = head;
        int sizeOfList = 0;
        while (curr != null) {
            sizeOfList++;
            curr = curr.next;
        }

        // Calculate the position from the start to remove
        int posToRemove = sizeOfList - n;

        // If removing the first node (head)
        if (posToRemove == 0) {
            return head.next;
        }

        // Second pass: Traverse to the node just before the one to remove
        ListNode prev = null;
        curr = head;
        int track = 0;
        while (curr != null) {
            if (track == posToRemove) {
                prev.next = curr.next; // Remove the node by skipping it
                break;
            }
            prev = curr;
            curr = curr.next;
            track++;
        }

        return head; // Return the modified head
    }
}
