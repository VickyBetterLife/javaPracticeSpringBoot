package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of integers, find two numbers such that they add up to a specific target number. The
function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2 Please note that your returned answers (both index1 and
index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSumAndThreeSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;
        HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hp.containsKey(temp)) {
                return new int[]{hp.get(temp), i};
            }
            if (!hp.containsKey(temp)) {
                hp.put(nums[i], i);
            }

        }
        return new int[2];
    }


    public int[] twoSum_2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;

        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            int tmp = target - nums[i];

            if(hm.containsKey(nums[i]))
                return new int[]{hm.get(nums[i]),i};

            hm.put(tmp,i);
        }

        return new int[2];
    }

    /*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all
unique triplets in the array which gives the sum of zero.
Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set
must not contain duplicate triplets.
题目翻译：
给定一个整型数组num，找出这个数组中满足这个条件的所有数字： num[i]+num[j]+num[k] = 0. 并且所有
的答案是要和其他不同的，也就是说两个相同的答案是不被接受的。
     */

    //if want to find the target sum, can change zero to that target number
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        if (nums == null || nums.length < 2)
            return null;

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                List<Integer> list = new ArrayList<Integer>();
                if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j - 1] == nums[j])
                        ++j;
                    while (j < k && nums[k] == nums[k + 1])
                        --k;
                }
                else if (nums[i] + nums[j] + nums[k] < 0)
                    ++j;
                else
                    --k;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum_2(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        return result;
    }


    /*
    Given an array S of n integers, find three integers in S such that the sum is closest to a given
number, target. Return the sum of the three integers. You man assume that each input would have
exactly one solution.
     */
    public int threeSumClosest(int[] nums,int target) {

        Arrays.sort(nums);
        if (nums == null || nums.length < 2)
            return 0;
        int result = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];
                int gap = Math.abs(sum - target);
                if(gap == 0){
                    return sum;
                }
                else if ( gap < minDistance ) {
                    result = sum;
                    j++;
                    while (j < k && nums[j - 1] == nums[j])
                        ++j;
                    while (j < k && nums[k] == nums[k + 1])
                        --k;
                }
                else
                    --k;

            }
        }
        return result;
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums == null || nums.length < 2)
            return null;

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                List<Integer> list = new ArrayList<Integer>();
                if (nums[i] + nums[j] + nums[k] == target) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j - 1] == nums[j])
                        ++j;
                    while (j < k && nums[k] == nums[k + 1])
                        --k;
                }
                else if (nums[i] + nums[j] + nums[k] < target)
                    ++j;
                else
                    --k;
            }
        }
        return result;
    }
}
