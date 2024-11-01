package linkedlist.problem;

public class DetectLoopLinkedList {
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
