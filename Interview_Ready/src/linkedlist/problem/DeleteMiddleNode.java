package linkedlist.problem;

public class DeleteMiddleNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode deleteMiddle(ListNode head) {

        ListNode curr = head;
        int lengthOfList = 0;

        while(curr != null){
            lengthOfList++;
            curr = curr.next;
        }

        ListNode prev = null;
        curr = head;
        int pos = lengthOfList/2;

        if(pos == 0) return head.next;

        int tracker = 0;

        while(curr != null){
            if(tracker == pos){
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
            tracker++;
        }

        return head;
    }
}
