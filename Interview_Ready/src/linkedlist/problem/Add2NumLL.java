package linkedlist.problem;

public class Add2NumLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Dummy node to simplify the result list handling
        ListNode current = dummy;
        int carry = 0;

        // Loop through both lists until all nodes and carry are processed
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Update carry and the current node value
            carry = sum / 10;
            current.next = new ListNode(sum % 10);

            // Move to the next node in the result list
            current = current.next;
        }

        return dummy.next;
    }
}
