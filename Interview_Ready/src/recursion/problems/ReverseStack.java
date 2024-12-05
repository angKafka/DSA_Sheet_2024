package recursion.problems;

import java.util.Stack;

public class ReverseStack {
    static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty()) return;

        int top = s.pop();
        reverse(s);
        insertAtBottom(s, top);
    }

    static void insertAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        insertAtBottom(s, data);
        s.push(top);
    }
}
