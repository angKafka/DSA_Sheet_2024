package linkedlist.problem;

public class SearchLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static boolean searchKey(int n, Node head, int key) {
        // Code here

        Node curr = head;
        while(curr.next != null){
            if(curr.data == key){
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}
