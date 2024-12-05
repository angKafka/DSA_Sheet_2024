package recursion.problems;

public class CountGoodNum {
    public static final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        return (int) (power(5, (n+1)/2) * power(4, n/2) % MOD);
    }

    public long power(long base, long exp){
        long result = 1;

        while(exp != 0){
            if((exp & 1) == 1){
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
