package algorithm;

public class FindPeakElement {

    /*
    the runtime is too high,O(n)
     */
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;


        int start = Integer.MIN_VALUE;
        int end;
        int result = 0;


        for(int i=0;i<nums.length;i++)
        {
            if(i>0)
                start = nums[i-1];

            if(i < nums.length-1)
                end = nums[i+1];
            else
                end = Integer.MIN_VALUE;

            if(nums[i] > start && nums[i] > end)
                result = i;
        }

        return result;

    }

    /*
    binary search, the run time is O(logn)
     */

    public int findPeakElement_binarySearch(int[] nums)
    {
        if(nums == null || nums.length==0)
            return -1;

        int start = 0;
        int end = nums.length-1;

        while(start<= end){
            int mid = (start+end)/2;
            if((mid==0 || nums[mid] > nums[mid-1]) & (mid==nums.length-1 || nums[mid]>nums[mid+1]) )
            {
                return mid;
            }
            else if(mid>0 && nums[mid] < nums[mid-1])
                end = mid-1;
            else
                start = mid+1;
        }

        return -1;
    }


}
