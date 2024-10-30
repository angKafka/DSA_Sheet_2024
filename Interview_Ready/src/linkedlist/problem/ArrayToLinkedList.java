package linkedlist.problem;

public class ArrayToLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    static Node tail;
    static Node constructLL(int arr[]) {
        if(arr.length == 0) return null;
        int arrLen = arr.length;
        head = new Node(arr[0]);// 1->
        tail = head;

        //O(N)
        for(int i=1; i<arrLen; i++){
            insertAtTail(arr[i]); // 1->2->3->4->5->NULL
        }

        return head;
    }

    //O(1)
    static void insertAtTail(int data){
        Node nodeToInsert = new Node(data);

        if(head == null){
            head = nodeToInsert;
            return;
        }

        tail.next = nodeToInsert;
        tail = nodeToInsert;
    }
}
