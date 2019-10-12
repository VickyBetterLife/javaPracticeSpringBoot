package AmazonQuestions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Given a string s and an int k, return an int representing the number of substrings (not unique) of s with exactly k distinct characters. If the given string doesn't have k distinct characters, return 0.
https://leetcode.com/problems/subarrays-with-k-different-integers

Example 1:

Input: s = "pqpqs", k = 2
Output: 7
Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]
Example 2:

Input: s = "aabab", k = 3
Output: 0
Constraints:

The input string consists of only lowercase English letters [a-z]
0 ≤ k ≤ 26
 */
public class SubarrayWithKDifferentChars {

    public int getSubstringWithKChars(String s,int k){

        int count = 0;
        if(s == null || s.length() == 0)
            return count;

        int i = 0;
        int start = 0;

        Map<String,Integer> hm = new LinkedHashMap<String, Integer>();

        while(i<s.length()){
            String val = s.substring(i,i+1);
            if(hm.containsKey(val)){
                hm.remove(val);
            }

            hm.put(val,i);

            if(hm.size() == k){
                Integer firstIndex = hm.entrySet().iterator().next().getValue();
                count += firstIndex - start + 1;
            }

        }
        return count;
    }
}
