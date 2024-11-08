package stacks.problems;

import java.util.*;

public class NextGreaterElement {
    //Brute Force: O(N^2)
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();

        int left = nums1.length;
        int right = nums2.length;

        for(int i=0; i<left; i++){
            int nextGreater = -1;

            boolean found = false;
            for(int j=0; j<right; j++){
                if(nums1[i] == nums2[j]){//  1
                    found = true;
                }

                if (found && nums2[j] > nums1[i]){
                    nextGreater = nums2[j];
                    break;
                }
            }
            temp.add(nextGreater);
        }


        int[] nge = new int[temp.size()];

        for(int i=0; i<temp.size(); i++){
            nge[i] = temp.get(i);
        }

        return nge;
    }

    //Optimized: O(N)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> prevOccurance = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                prevOccurance.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            prevOccurance.put(stack.pop(), -1);
        }

        int[] nextGreater = new int[nums1.length];

        for(int i=0 ; i<nums1.length; i++){
            nextGreater[i] = prevOccurance.get(nums1[i]);
        }

        return nextGreater;
    }
}
