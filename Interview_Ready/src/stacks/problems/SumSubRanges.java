package stacks.problems;

import java.util.Stack;

public class SumSubRanges {
    //Brute Force: O(N^2)
    public long subArrayRanges(int[] nums) {
        long sum = 0;

        for(int i=0 ; i < nums.length ; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j=i; j<nums.length; j++){
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);

                sum += max - min;
            }
        }

        return sum;
    }


    //Optimal: O(N)
    public long subArrayRange(int[] nums) {
        long sumMax = sumSubarrayMaxs(nums);
        long sumMin = sumSubarrayMins(nums);

        // Ensure result is positive by adding mod twice, then applying % mod
        long result = (sumMax - sumMin);

        return result;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            nse[i] = n;
            pse[i] = -1;
        }

        // Calculate Previous Greater Element (PGE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        // Calculate Next Greater Element (NGE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int leftCount = i - pse[i];
            int rightCount = nse[i] - i;

            // Apply mod at each step to prevent overflow
            sum = (sum + ((long) arr[i] * leftCount) * rightCount);
        }

        return sum;
    }

    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            nse[i] = n;
            pse[i] = -1;
        }

        // Calculate Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        // Calculate Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int leftCount = i - pse[i];
            int rightCount = nse[i] - i;

            // Apply mod at each step to prevent overflow
            sum = (sum + ((long) arr[i] * leftCount) * rightCount);
        }

        return sum;
    }
}
