package linkedlist.problem;

public class SortLinkedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public ListNode sortList(ListNode head) {
        // Base case: If the list is empty or has only one node, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode middle = getMiddle(head);
        ListNode leftHalf = head;
        ListNode rightHalf = middle.next;
        middle.next = null; // Cut the list into two halves

        // Step 2: Sort each half recursively
        leftHalf = sortList(leftHalf);
        rightHalf = sortList(rightHalf);

        // Step 3: Merge the two sorted halves
        return merge(leftHalf, rightHalf);
    }

    // Helper function to find the middle of the list
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // Move `fast` by two steps and `slow` by one step
        // When `fast` reaches the end, `slow` will be at the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper function to merge two sorted linked lists
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Merge nodes from both lists in sorted order
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Append any remaining nodes from either list
        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        return dummy.next;
    }

}
