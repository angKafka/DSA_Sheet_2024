package recursion.problems;

import java.util.Stack;

public class SortStack {
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return stack;

        int top = stack.pop();
        sortStack(stack);

        insertTop(stack, top);
        return stack;
    }

    public static void insertTop(Stack<Integer> stack, int top) {
        if(stack.isEmpty() || top < stack.peek()) stack.push(top);
        else{
            int temp = stack.pop();
            insertTop(stack, top);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        sortStack(stack);
        System.out.println(stack);
    }
}
