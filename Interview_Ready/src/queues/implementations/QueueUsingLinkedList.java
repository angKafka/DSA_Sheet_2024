package queues.implementations;

public class QueueUsingLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
        Node front;
        Node rear;
        public Queue() {
            front = null;
            rear = null;
        }

        public void enqueue(int data) {
            Node newNode = new Node(data);
            if(rear == null) {
                rear = front = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        public int dequeue() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int top = front.data;

            if(front == rear){
                rear = null;
            }
            front = front.next;
            return top;
        }

        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }

        public boolean isEmpty() {
            return front == null && rear == null;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());

        System.out.println("Empty process starts\n");
        do{
            System.out.println("Dequeue: " + queue.dequeue());
        }while(!queue.isEmpty());

        System.out.println("Empty process ends\n");

        System.out.println("Queue is empty? " + queue.isEmpty());

    }
}
