package algorithm;

public class RemoveDuplicatesfromSortedArray {

    // less runtime than method2, runtime:1 ms	Memory:39.7 MB
    public int removeDuplicatesfromSortedArray(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;

        int pre = 1;
        int post = 1;
        int count = 0;
        while (post < nums.length) {

            if (nums[post - 1] == nums[post]) {
                if (count < 1) {
                    count++;
                }

            } else {
                nums[pre++] = nums[post];
                count = 0;
            }
            post++;
        }
        return pre;
    }

    //runtime: 8 ms   memory:N/A
    public int removeDuplicatesfromSortedArray_method2(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length <= 1)
            return nums.length;

        int lastNum = nums[0];
        int lastPos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lastNum) {
                lastNum = nums[i];
                nums[lastPos++] = nums[i];
            }
        }
        return lastPos;
    }

    /*
    80. Remove Duplicates from Sorted Array II
    Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     */
    public int removeDuplicatesfromSortedArray2(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;

        int pre = 1;
        int post = 1;
        int count = 0;
        while (post < nums.length) {
            count++;
            if (nums[post - 1] == nums[post]) {
                if (count < 2) {
                    nums[pre] = nums[post];
                    pre++;
                }

                post++;

            } else {
                nums[pre++] = nums[post++];
                count = 0;
            }
        }
        return pre;
    }

    public int removeDuplicatesfromSortedArray2_method2(int nums[]) {
        if(nums.length == 0) {
            return 0;
        }
        int j = 0;
        int num = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[j] == nums[i]) {
                num++;
                if(num < 2) {
                    nums[++j] = nums[i];
                }
            } else {
                nums[++j] = nums[i];
                num = 0;
            }
        }
        return j + 1;
    }
}
