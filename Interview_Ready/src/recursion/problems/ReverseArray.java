package recursion.problems;

public class ReverseArray {
    public static  void reverseArray(int[] arr) {
        reversing(arr, arr.length-1);
    }

    private static  void reversing(int[] arr, int i) {
        if(i < 0) return;

        System.out.print(arr[i]+" ");
        reversing(arr, i - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverseArray(arr);
    }
}
