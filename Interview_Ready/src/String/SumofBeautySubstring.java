package String;

import java.util.HashMap;
import java.util.Map;

public class SumofBeautySubstring {
    //O(N^2)
    public int beautySum(String s) {
        int beauty = 0;
        int strLen = s.length();
        for(int i=0; i<strLen; i++){
            Map<Character,Integer> freq_Map = new HashMap<>();
            for(int j=i; j<strLen; j++){
                char ch = s.charAt(j);
                freq_Map.put(ch, freq_Map.getOrDefault(ch, 0)+1);
                beauty += frequencyDifference(freq_Map);
            }
        }

        return beauty;
    }


    public int frequencyDifference(Map<Character,Integer> freq_Map){
        int MOST_FREQUENT = Integer.MIN_VALUE;
        int LEAST_FREQUENT = Integer.MAX_VALUE;

        for(int freq: freq_Map.values()){
            MOST_FREQUENT = Math.max(MOST_FREQUENT, freq);
            LEAST_FREQUENT = Math.min(LEAST_FREQUENT, freq);
        }

        return (MOST_FREQUENT - LEAST_FREQUENT);
    }
}
