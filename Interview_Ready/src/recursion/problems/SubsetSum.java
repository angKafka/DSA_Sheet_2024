package recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        generateSubsets(0, nums, new ArrayList<>(), output);
        return output;
    }

    void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> output) {
        // Add the current subset to the output
        output.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            // Include nums[i] in the current subset
            current.add(nums[i]);

            // Recurse for the next elements
            generateSubsets(i + 1, nums, current, output);

            // Backtrack by removing the last added element
            current.remove(current.size() - 1);
        }
    }
}
