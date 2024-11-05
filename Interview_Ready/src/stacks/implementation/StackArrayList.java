package stacks.implementation;


import java.util.ArrayList;
import java.util.List;

public class StackArrayList {
    List<Integer> stackList;

    StackArrayList() {
        stackList = new ArrayList<>();
    }
    
    void push(int data) {
        stackList.add(data);
    }

    int pop() {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return - 1;
        }

        return stackList.remove(stackList.size()-1);
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return - 1;
        }

        return stackList.get(stackList.size()-1);
    }
    private boolean isEmpty() {
        return stackList.isEmpty();
    }

    public static void main(String[] args) {
        StackArrayList stackArrayList = new StackArrayList();
        stackArrayList.push(1);
        stackArrayList.push(2);
        stackArrayList.push(3);
        stackArrayList.push(4);
        stackArrayList.push(5);

        System.out.println("Top: " + stackArrayList.peek());

        System.out.println("Empty process start:\n");
        do{
            System.out.println("Pop: " + stackArrayList.pop());
        }while(!stackArrayList.isEmpty());

        System.out.println("Empty: " + stackArrayList.isEmpty());
    }
}
