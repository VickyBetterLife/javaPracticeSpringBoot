package algorithm;

public class findMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums ==null || nums.length == 0)
        {
            return 0;
        }

        int result = nums[0];
        int low = 0;
        int high = nums.length-1;

        while(low < high)
        {
            int mid = (low+high)/2;
            if(nums[mid] >= result){
                low = mid+1;
                result = nums[high];
            }
            else
            {
                high = mid;
                result = nums[mid];
            }
        }

        if(result > nums[0])
            result = nums[0];

        return result;

    }
}
