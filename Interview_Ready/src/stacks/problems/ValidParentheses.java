package stacks.problems;

import java.util.Stack;

public class ValidParentheses {
    //Brute Force: O(N^2)
    public boolean isValid(String s) {
        int n = s.length();
        if(n == 0) return true;

        do{
            boolean foundPair = false;

            for(int i = 0; i < n; i++) {
                char curr = s.charAt(i);
                char next = s.charAt(i+1);
                if((curr == '(' && next == ')') || (curr == '{' && next == '}')) {
                    //Removing the matching pairs for string
                    s = s.substring(0, i) + s.substring(i+2);
                    foundPair = true;
                    break;
                }
            }

            if(!foundPair) return false;
        }while(n > 0);

        return true;
    }


    //Optimal approach: O(N)
    public boolean isValid2(String s) {
        int n = s.length();
        if(n == 0) return true;

        Stack<Character> char_stack = new Stack<Character>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                char_stack.push(c);
            }else{
                if(char_stack.isEmpty()) {
                    return false;
                }

                char top = char_stack.pop();
                if((c == ')' && top != '(') || (c == ']' && top != '[') ||(c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return char_stack.isEmpty();
    }
}
