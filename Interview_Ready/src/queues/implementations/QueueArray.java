package queues.implementations;


public class QueueArray {
    static int[] queueArr;
    static int maxSize;
    static int rear;
    QueueArray(int maxSize){
            this.maxSize = maxSize;
            this.queueArr = new int[maxSize];
            this.rear = -1;
    }


    public  boolean isEmpty(){
        return rear == -1;
    }

    public  void enqueue(int data){
        if(rear == maxSize-1){
            System.out.println("Queue is full");
            return;
        }

        queueArr[++rear] = data;
    }

    public  int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int front = queueArr[0];

        for(int i=0; i<rear; i++){
            queueArr[i] = queueArr[i+1];
        }

        rear--;
        return front;
    }

    public  int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queueArr[0];
    }

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(6);
        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);
        queueArray.enqueue(5);

        System.out.println("Peek: " + queueArray.peek());
        System.out.println("Dequeue: " + queueArray.dequeue());
        System.out.println("Peek: " + queueArray.peek());
        System.out.println("Empty process starts\n");

        do{
            System.out.println("Dequeue: " + queueArray.dequeue());
        }while(!queueArray.isEmpty());

        System.out.println("Empty process ends\n");
        System.out.println("Queue is empty: "+queueArray.isEmpty());
    }
}
