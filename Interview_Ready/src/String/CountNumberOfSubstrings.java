package String;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubstrings {

    //O(N^3) Time Complexity/
    static long substrCount (String S, int K) {
        if(S.length() == 0) return 0;
        if(S == null) return 0;

        int totalCount = 0;
        int n = S.length();

        // Loop to generate all substrings
        for (int i = 0; i < n; i++) {
            // Use StringBuilder to build the substring
            StringBuilder sb = new StringBuilder();

            for (int j = i; j < n; j++) {
                sb.append(S.charAt(j)); // Append character to StringBuilder

                // Frequency array to count occurrences of characters
                int[] freq = new int[26];
                for (int index = 0; index < sb.length(); index++) {
                    freq[sb.charAt(index) - 'a']++;
                }

                // Count distinct characters
                int distinctCount = 0;
                for (int count : freq) {
                    if (count > 0) {
                        distinctCount++;
                    }
                }

                // Check if we have exactly K distinct characters
                if (distinctCount == K) {
                    totalCount++;
                }
            }
        }

        return totalCount;
    }

//O(N^2) Time Complexity
    static long substrCountNew (String S, int K){
        if(S.length() == 0) return 0;
        if(S == null) return 0;

        int totalCount = 0;
        int n = S.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinctCount = 0;

            for (int j = i; j < n; j++) {
                char currentChar = S.charAt(j);
                int currentIndex = currentChar - 'a';

                if(freq[currentIndex] == 0){
                    distinctCount++;
                }
                freq[currentIndex]++;

                if (distinctCount == K) {
                    totalCount++;
                }else if(distinctCount > K){
                    break;
                }
            }
        }

        return totalCount;
    }

    static long substrCountNew2 (String S, int K) {

        if (S == null || S.length() == 0 || K == 0) return 0;

        return countSubstringsWithKDistinct(S, K) - countSubstringsWithKDistinct(S, K - 1);

    }

    static long countSubstringsWithKDistinct(String S, int K) {
        int n = S.length();
        int left = 0, right = 0;
        long count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        while (right < n) {
            // Expand the window by including the character at `right`
            char rightChar = S.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            // Shrink the window until we have exactly `K` distinct characters
            while (freqMap.size() > K) {
                char leftChar = S.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            // Count all substrings ending at `right` with exactly `K` distinct characters
            count += right - left + 1;
            right++;
        }

        return count;
    }


    public static void main(String[] args) {
        String s = "aba";
        int K = 2;

        System.out.println(substrCountNew2(s,K));
    }
}
