package linkedlist.problem;

public class PalindromeLinkedList {
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public boolean isPalindromes(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode currReversed = reverseList(slow);
        ListNode curr = head;
        ListNode reversed = currReversed;
        while (curr != null && reversed != null) {
            if(curr.data != reversed.data){
                return false;
            }
            curr = curr.next;
            reversed = reversed.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = null;

        while(curr != null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        if(size == 1) return true;

        int[] p = new int[size];
        curr = head;
        int index = 0;
        while (curr != null) {
            p[index] = curr.data;
            index++;
            curr = curr.next;
        }

        for (int i = 0; i < size / 2; i++) {
            if (p[i] != p[size - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
