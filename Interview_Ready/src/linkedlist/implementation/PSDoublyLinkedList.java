package linkedlist.implementation;

public class PSDoublyLinkedList {
    static class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static Node head = null;

    public static void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }


    public static void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
        newNode.prev = currNode;
    }

    public static void printNodeByNode(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        insertAtHead(1);
        insertAtHead(2);
        insertAtHead(3);
        insertAtHead(4);
        printNodeByNode(); // NULL<-4-><-3-><-2-><-1->NULL

        insertAtTail(5);
        insertAtTail(6);
        printNodeByNode();
    }
}
