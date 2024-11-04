package linkedlist.problem;

public class Add1NumLL {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node reverse(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node forward = null;

        while(curr != null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
    }
    public Node addOne(Node head) {
        head = reverse(head);

        Node current = head;
        int carry = 1;

        while (carry > 0) {
            current.data += 1; // Add one to the current node

            if (current.data < 10) {
                // No carry, reverse the list back and return
                return reverse(head);
            } else {
                // Carry over, set the current node to 0
                current.data = 0;
            }

            if (current.next == null) {
                // If at the end of the list, break out of the loop
                break;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        // If there's still a carry, add a new node at the end
        current.next = new Node(1);

        // Reverse the list back to its original order and return
        return reverse(head);
    }


}
