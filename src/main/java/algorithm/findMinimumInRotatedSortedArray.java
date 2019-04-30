package algorithm;

public class findMinimumInRotatedSortedArray {

    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //{1 3 5 6 8}
        if(nums[nums.length-1] > nums[0])
            return nums[0];


        int result = nums[0];
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= result) {
                low = mid + 1;
                result = nums[high];
            } else {
                high = mid;
                result = nums[mid];
            }
        }
        return result;

    }
}
