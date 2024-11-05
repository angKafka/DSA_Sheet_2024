package stacks.implementation;

public class StackLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{
        public static Node head;

        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }
        public static boolean isEmpty(){
            return head == null;
        }


        public static void main(String[] args) {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            System.out.println("Pop: "+ stack.pop());
            System.out.println("Top: "+ stack.peek());
            System.out.println("Empty process start:\n");
            do{
                System.out.println("Pop: "+stack.pop());
            }while(!isEmpty());

            System.out.println("Empty: "+stack.isEmpty());
        }
    }
}
