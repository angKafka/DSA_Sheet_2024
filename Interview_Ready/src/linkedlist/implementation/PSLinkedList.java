package linkedlist.implementation;

public class PSLinkedList {
   static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head = null;


    public static void insertAtHead(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void insertAtTail(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }

        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public static void insertAtIndex(int data, int index) {
        Node tempNode = head;
        int counter = 1;
        while(counter < index - 1) {
            tempNode = tempNode.next;
            counter++;
        }
        Node newNode = new Node(data);
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    public static void deleteAtHead(){
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
    }

    public static void deleteAtTail(){
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while(currNode.next != null) {
            prevNode = prevNode.next;
            currNode = currNode.next;
        }

        prevNode.next = null;
    }

    public static void printNodeByNode() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {

        /*Inserting at the head*/
//        insertAtHead(1);
//        insertAtHead(2);
//        insertAtHead(3);
//        printNodeByNode(); //For this 3->2->1->NULL which is a reverse


        /*Inserting at the end - for this we have to insert a head first*/
        insertAtHead(1);
        insertAtTail(2);
        insertAtTail(3);
        insertAtTail(4);
        insertAtIndex(5, 2); // 1->5->2->3->4->NULL
        printNodeByNode(); // For this 1->2->3->4->NULL

        System.out.println("\n");
        deleteAtHead(); // 5->2->3->4->NULL
        printNodeByNode();

        System.out.println("\n");
        deleteAtTail(); // 5->2->3->NULL
        printNodeByNode();
    }
}
