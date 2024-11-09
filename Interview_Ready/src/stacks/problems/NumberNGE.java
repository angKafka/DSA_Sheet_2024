package stacks.problems;


public class NumberNGE {
    //Brute Force: O(q*N)
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        // code here
        int[] nextGreaterFound = new int[queries];
        for(int i = 0; i < queries; i++){
            int nextGreaterCount = 0;
            for(int j = indices[i]; j<arr.length; j++){
                int currElement = arr[indices[i]];
                if(currElement < arr[j]){
                    nextGreaterCount++;
                }
            }

            nextGreaterFound[i] = nextGreaterCount;
        }
        return nextGreaterFound;
    }
}
