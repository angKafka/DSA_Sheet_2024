package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_451 {
    public String frequencySort(String s) {
        // Step 1: Build the frequency map
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0 ; i<s.length(); i++){
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0)+1);
        }
        /*
          e-2
          r-1
          t-1
         */

        // Step 2: Find the maximum frequency
        int mxFreq = 0;
        for(int freq : frequencyMap.values()){
            mxFreq = Math.max(mxFreq, freq);
        }

        // Step 3: Create buckets
        List<Character>[] buckets = new ArrayList[mxFreq+1];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }

        // Step 4: Fill the buckets
        for(Map.Entry<Character, Integer> entry: frequencyMap.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(ch);
        }

        // Step 5: Build the result string
        StringBuilder result = new StringBuilder();
        for(int i=mxFreq; i>0; i--){ // Start from the highest frequency
            for(char ch: buckets[i]){
                for(int j=0;j<i; j++){
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
