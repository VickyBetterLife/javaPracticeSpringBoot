package AmazonQuestions;

import org.junit.Assert;
import org.junit.Test;

public class subarraysWithKDifferentIntegersTest {

    @Test
    public void subArraysWithKDifferentIntegerTest(){
        int[] a = new int[]{1,2,1,2,3};

        SubarrayswithKDifferentIntegers swk = new SubarrayswithKDifferentIntegers();
        int result = swk.subarraysWithKDistinct(a,2);

        Assert.assertEquals(7,result);
    }
}
