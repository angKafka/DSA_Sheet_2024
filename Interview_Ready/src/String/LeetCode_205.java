package String;

public class LeetCode_205
{
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] mapS = new int[256];
        int[] mapT = new int[256];


        for (int i = 0; i < 256; i++) {
            mapS[i] = -1;
            mapT[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);


            if (mapS[charS] == -1 && mapT[charT] == -1) {

                mapS[charS] = charT;
                mapT[charT] = charS;
            } else if (mapS[charS] != charT || mapT[charT] != charS) {

                return false;
            }
        }

        return true;
    }
}
