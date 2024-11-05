package stacks.implementation;

public class StacksArray {
    int maxSize;
    int[] stackArray;
    int top;
    public StacksArray(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int data) {
        if(isFull()){
            System.out.println("Stack is full");
        }else{
            stackArray[++top] = data;
        }
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            return stackArray[top--];
        }
    }

    public int peek() {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            return stackArray[top];
        }
    }

    public boolean isEmpty(){
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        StacksArray s = new StacksArray(5);
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Top: " + s.peek());

        System.out.println("Making the stack empty:\n");
        do {
            System.out.println("Top: " + s.pop());
        } while (!s.isEmpty());

        System.out.println("Stack is empty: " + s.isEmpty());
    }
}
