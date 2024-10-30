package linkedlist.problem;

public class InsertionAtEnd {
    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node insertAtEnd(Node head, int x) {
        Node newnode=new Node(x);
        if(head==null) return newnode;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        return head;
    }
}
