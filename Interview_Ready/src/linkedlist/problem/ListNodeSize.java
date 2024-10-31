package linkedlist.problem;

public class ListNodeSize {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int getCount(Node head) {
        // code here
        Node curr = head;
        int listLength = 0;

        while(curr.next != null){
            curr = curr.next;
            listLength++;
        }

        return listLength+1;
    }
}
