package linkedlist.problem;

public class LengthOfLoop {
    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow = head; // 1
        Node fast = head; // 1


        if(fast == null || fast.next == null) return 0; // 0

        while(fast != null && fast.next != null){ // 1
            slow = slow.next; // 1 2
            fast = fast.next.next; // 3 5

            if(slow == fast){ // No
                // Step 2: Find the start of the cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Step 3: Count the nodes in the cycle
                int nodeCount = 1;
                Node current = slow.next;
                while (current != slow) {
                    nodeCount++;
                    current = current.next;
                }
                return nodeCount;
            }
        }
        return 0;
    }
}
