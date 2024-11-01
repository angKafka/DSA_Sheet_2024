package linkedlist.problem;

import java.util.HashMap;
import java.util.Map;

public class StartingPointLinkedList {
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public ListNode detectCycles(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();

        ListNode curr = head;
        int pos = 0;
        while(curr != null){
            if(map.containsKey(curr)){
                return curr;
            }
            pos++;
            map.put(curr, pos);
            curr = curr.next;
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(fast == null || fast.next == null) return null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
