package String;

public class LongestPSubstring {

    //O(N^2)
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;

        for (int i = 1; i < s.length(); i++) {
            // Even length palindrome
            int l = i - 1;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
                l--;
                r++;
            }

            // Odd length palindrome
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(start, start + maxLen);
    }

    //O(N)
    public String longestPalindrome1(String s) {
        int start = 0;
        int maxLen = 1;

        for (int i = 1; i < s.length(); i++) {
            // Even length palindrome
            int l = i - 1;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
                l--;
                r++;
            }

            // Odd length palindrome
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new LongestPSubstring().longestPalindrome1(s));
    }
}
