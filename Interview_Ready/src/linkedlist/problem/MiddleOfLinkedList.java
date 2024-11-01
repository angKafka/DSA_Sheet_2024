package linkedlist.problem;

public class MiddleOfLinkedList {
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public ListNode middleNode(ListNode head) {
        ListNode curr = head; // curr = 1
        int listSize = 1;
        while(curr.next != null){ // 1 2 3 4 5
            listSize++; // 5
            curr = curr.next; // 5
        }

        int midNode = listSize/2; // 2.5 but will take 2

        curr = head; // 3
        int nodePos = 0; // 0
        while(nodePos < midNode){ // 2 < 2 false
            nodePos++; //2
            curr = curr.next; // 3 4 5
        }

        return curr; // 3 4 5
    }
}
