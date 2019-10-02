package AmazonQuestions;

import java.util.*;

public class SubarrayswithKDifferentIntegers
{
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> valToIndex=new LinkedHashMap<Integer, Integer>();

        int l=0;
        int r=0;
        int c=0;
        while(r<A.length) {
            int val=A[r];
            if(valToIndex.containsKey(val)) {
                valToIndex.remove(val);
            }

            valToIndex.put(val, r);
            if(valToIndex.size()>K) {
                java.util.Map.Entry<Integer, Integer> oldest=valToIndex.entrySet().iterator().next();
                int oldVal=oldest.getKey();
                int oldIndex=oldest.getValue();
                valToIndex.remove(oldVal);
                l=oldIndex+1;
            }

            if(valToIndex.size()==K) {
                java.util.Map.Entry<Integer, Integer> oldest=valToIndex.entrySet().iterator().next();
                int oldIndex=oldest.getValue();
                c+=oldIndex-l+1;
            }

            r++;
        }

        return c;
    }
}
