package AmazonQuestions;


import org.junit.Assert;
import org.junit.Test;

public class minCosttoConnectRopesTest {

    @Test
    public void minCosttoConnectRopes_test() {
        MinCosttoConnectRopes ou = new MinCosttoConnectRopes();

        int[] a = new int[]{8, 4, 6, 12};

        Assert.assertEquals(58,ou.minCosttoConnectRopes(a));

        int[] b = new int[]{20, 4, 8, 2};
        Assert.assertEquals(54,ou.minCosttoConnectRopes(b));

        int[] c = new int[]{1, 2, 5, 10, 35, 89};
        Assert.assertEquals(224,ou.minCosttoConnectRopes(c));

        int[] d = new int[]{2, 2, 3, 3};
        Assert.assertEquals(20,ou.minCosttoConnectRopes(d));

    }
}
