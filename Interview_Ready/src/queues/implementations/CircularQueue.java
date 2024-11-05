package queues.implementations;

public class CircularQueue {
    private int[] queue;
    private int front = -1;
    private int rear = -1;
    private int maxSize;
    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
    }

    public boolean isEmpty(){
        return rear == -1 && front == -1;
    }

    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }

        if(front == -1){
            front = 0;
        }
        rear = (rear+1)%maxSize;
        queue[rear] = data;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int result = queue[front];
        if(rear == front){
            rear = front = -1;
        }else {
            front = (front + 1) % maxSize;
        }
        return result;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());

        System.out.println("Empty process starts");
        do{
            System.out.println("Dequeue: " + queue.dequeue());
        }while(!queue.isEmpty());

        System.out.println("Empty process ends\n");
        System.out.println("Queue is Empty: "+queue.isEmpty());
    }
}
