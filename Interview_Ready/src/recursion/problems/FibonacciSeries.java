package recursion.problems;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;

        if(map.containsKey(n)) return map.get(n);
        int result = fib(n-1) + fib(n-2);
        map.put(n,result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
    }
}
