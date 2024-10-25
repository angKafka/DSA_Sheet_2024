package String;

public class LeetCode_1614 {
    public int maxDepth(String s) {
        if(s.length() == 0) return 0;
        int bracketTracker = 0, maxDepth = 0;

        for(int i=0; i < s.length(); i++){

            if(s.charAt(i) == '('){
                bracketTracker++; // 1
            }

            if(s.charAt(i) == ')'){
                bracketTracker--; // 1
            }

            if(bracketTracker == 0 || bracketTracker >= 1){
                maxDepth = Math.max(maxDepth, bracketTracker); // 3
            }
        }
        return maxDepth; // 3
    }
}
