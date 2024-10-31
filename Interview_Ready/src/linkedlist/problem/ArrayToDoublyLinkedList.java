package linkedlist.problem;

public class ArrayToDoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    Node constructDLL(int arr[]) {
        // Code here
        if(arr.length == 0) return null;
        int arrLen = arr.length;
        head = new Node(arr[0]);// 1->
        tail = head;

        for(int i=1; i<arr.length; i++){
            insertAtTail(arr[i]);
        }

        return head;
    }

    void insertAtTail(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
}
