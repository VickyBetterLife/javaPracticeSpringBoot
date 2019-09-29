package AmazonQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSumUniquePairs {

    public static int getUniquePairs(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return 0;

        HashMap<Integer,Integer> hp = new HashMap<Integer, Integer>();
        Set<Integer[]> st = new HashSet<Integer[]>();

        for(int i=0;i<nums.length;i++){
            int tmp = target - nums[i];
            if(!hp.containsKey(tmp)){
                hp.put(nums[i],i);
            }
            else{
                st.add(new Integer[]{hp.get(tmp),i});
            }
        }
        return st.size();
    }
}
