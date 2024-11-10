package stacks.problems;

public class TrappingRainWater {

    //Brute Force: O(N^2)
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0; // No bars to trap water
        }

        int waterTrapped = 0;

        // For each bar at index i
        for (int i = 0; i < n; i++) {
            // Find maximum height to the left of bar[i]
            int maxLeft = 0;
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            // Find maximum height to the right of bar[i]
            int maxRight = 0;
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            // Calculate water trapped at current index
            waterTrapped += Math.min(maxLeft, maxRight) - height[i];
        }

        return waterTrapped;
    }

    //Optimal: O(N)
    public int trap2(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        int[] max_left = new int[n];
        int[] max_right = new int[n];

        max_left[0] = height[0];

        for(int i=1; i<n; i++){
            max_left[i] = Math.max(max_left[i-1], height[i]);
        }

        max_right[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            max_right[i] = Math.max(max_right[i+1], height[i]);
        }

        int waterTrapped = 0;

        for(int i=0; i<n; i++){
            waterTrapped += Math.min(max_left[i], max_right[i]) - height[i];
        }

        return waterTrapped;
    }
}
