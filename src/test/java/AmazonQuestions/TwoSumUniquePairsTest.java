package AmazonQuestions;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumUniquePairsTest {

    @Test
    public void twoSumUniquePairTest(){
        int[] arr = new int[]{1, 1, 2, 45, 46, 46};

        TwoSumUniquePairs tsp = new TwoSumUniquePairs();
        int result = tsp.getUniquePairs(arr,47);

        Assert.assertEquals(2,result);

    }
}
