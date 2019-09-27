package AmazonQuestions;

import java.util.HashMap;

public class FindPairWithGivenSum {

    public int[] findPairWithGivenSum(int[] arr, int target){
        int[] result = new int[2];
        if(arr == null || arr.length == 0)
        {
            return result;
        }

        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<arr.length;i++){
            int tmp = target-30-arr[i];
            if(map.containsKey(tmp)){
                int mValue = map.get(tmp).intValue();
                if(max < tmp || max < arr[i]) {
                    result[0] = i;
                    result[1] = mValue;
                    max = Math.max(arr[i],tmp);
                }
            }
            else
                map.put(arr[i],i);
        }

        return result;
    }
}
