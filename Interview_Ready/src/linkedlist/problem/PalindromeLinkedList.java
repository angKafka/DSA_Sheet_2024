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
