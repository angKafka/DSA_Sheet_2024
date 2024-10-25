package String;

public class LeetCode_1021 {
    public String removeOuterParentheses(String s) {
        if(s.length() == 1) return s;

        StringBuilder sb = new StringBuilder();

        int left = 0;
        int right = 0;

        int bracketsTracker = 0;

        while(right < s.length()){

            if(s.charAt(right) == '('){
                bracketsTracker++;
            }


            if(s.charAt(right) == ')'){
                bracketsTracker--;
            }



            if(bracketsTracker == 0){
                sb.append(s.substring(left+1,right));
                left = right+1;
            }

            right++; // 5
        }

        return sb.toString();
    }
}
