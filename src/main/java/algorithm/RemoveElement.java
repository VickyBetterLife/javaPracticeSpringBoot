package algorithm;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;

        /*
        int pre = 0;
        int post = 1;

        while (post < nums.length) {
            if (nums[pre] == val) {
                if (nums[post] != val) {
                    int temp = nums[pre];
                    nums[pre] = nums[post];
                    nums[post] = temp;
                    pre++;
                    post++;
                }
                else
                    post++;

            } else {
                pre++;
                post++;
            }
        }

        if(nums[post-1] != val)
            pre++;

        return pre;
*/
        int i = 0;
        int j = 0;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                continue;
            }
            nums[j] = nums[i];
            j++;
        }
        return j;
    }
}
