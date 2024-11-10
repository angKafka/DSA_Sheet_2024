package stacks.problems;

import java.util.Stack;

public class MinSumSubArrays {
    //Brute Force: O(N^2)
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int mod = (int) (1e9 + 7);
        for(int i=0; i<arr.length; i++){
            int mini = arr[i];
            for(int j=i; j<arr.length; j++){
                mini = Math.min(mini, arr[j]);
                sum = (sum+mini)%mod;
            }
        }

        return sum;
    }


    //Optimal: O(N)
    public int sumSubArrayMin(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        int mod = (int) (1e9 + 7);
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            nse[i] = n;
            pse[i] = -1;
        }
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                pse[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
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
        for(int i=0; i<n; i++){
            int leftCount = i - pse[i];
            int rightCount = nse[i] - i;

            sum = (sum + (long) arr[i] * leftCount * rightCount) % mod;
        }

        return (int) sum;
    }
}
