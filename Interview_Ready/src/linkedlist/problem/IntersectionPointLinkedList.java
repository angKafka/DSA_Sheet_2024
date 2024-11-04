package linkedlist.problem;

import java.util.HashMap;
import java.util.Map;

public class IntersectionPointLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //O(N^2)
    int intersectPoint(Node head1, Node head2) {
        // If either head is null, return -1 (no intersection)
        if (head1 == null || head2 == null) return -1;

        // Loop through each node in head2
        while (head2 != null) {
            Node temp = head1;

            // For each node in head2, check against all nodes in head1
            while (temp != null) {
                // If we find a matching node, return its data
                if (temp == head2) {
                    return head2.data; // Return the intersecting data value
                }
                temp = temp.next; // Move to the next node in head1
            }
            head2 = head2.next; // Move to the next node in head2
        }

        // If no intersection is found, return -1
        return -1;
    }



    //O(N)
    Node intersectPoint2(Node headA, Node headB) {
        if(headA == null || headB == null) return null;

        Map<Node,Boolean> map = new HashMap<>();

        Node ptrA = headA;

        while(ptrA != null){
            map.put(ptrA, true);
            ptrA = ptrA.next;
        }

        Node ptrB = headB;

        while(ptrB != null){
            if(map.containsKey(ptrB)){
                return ptrB;
            }

            ptrB = ptrB.next;
        }

        return null;
    }


    //time: O(N) space: O(1)
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) return null;

        Node ptrA = headA;
        Node ptrB = headB;

        while (ptrA != ptrB) {
            if (ptrA == null) {
                ptrA = headB;
            } else {
                ptrA = ptrA.next;
            }

            if (ptrB == null) {
                ptrB = headA;
            } else {
                ptrB = ptrB.next;
            }
        }

        return ptrA;
    }

}
