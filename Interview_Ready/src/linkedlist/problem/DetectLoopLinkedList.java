package linkedlist.problem;

import java.util.HashMap;
import java.util.Map;

public class DetectLoopLinkedList {
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean hasCycles(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();

        ListNode curr = head;
        while(curr != null){
            if (map.containsKey(curr)) {
                return true;
            }
            map.put(curr, true);
            curr = curr.next;
        }

        return false;
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
