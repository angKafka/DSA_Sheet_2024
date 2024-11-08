package stacks.problems;

import java.util.Stack;

public class NextGreaterElement2 {

    //Optimized: O(N)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Manually initialize each element in nextGreater to -1
        for (int i = 0; i < n; i++) {
            nextGreater[i] = -1;
        }

        // Traverse the array twice to simulate the circular array
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                nextGreater[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }

        return nextGreater;
    }
}
