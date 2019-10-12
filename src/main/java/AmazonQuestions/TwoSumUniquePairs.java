package AmazonQuestions;


/*
Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.

Example 1:

Input: nums = [1, 1, 2, 45, 46, 46], target = 47
Output: 2
Explanation:
1 + 46 = 47
2 + 45 = 47
Example 2:

Input: nums = [1, 1], target = 2
Output: 1
Explanation:
1 + 1 = 2
Example 3:

Input: nums = [1, 5, 1, 5], target = 6
Output: 1
Explanation:
[1, 5] and [5, 1] are considered the same.
 */
import java.util.*;

public class TwoSumUniquePairs {

    public int getUniquePairs(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return 0;

        HashMap<Integer,Integer> hp = new HashMap<Integer, Integer>();
        HashSet<String> st = new HashSet<String>();

        for(int i=0;i<nums.length;i++){
            int tmp = target - nums[i];
            if(!hp.containsKey(tmp)){
                hp.put(nums[i],i);
            }
            else{
                int a = tmp;
                int b = nums[i];
                if(tmp > nums[i]){
                    a = nums[i];
                    b = tmp;
                }
                String m = a + "#" + b;
                st.add(m);
            }
        }
        return st.size();
    }
}
