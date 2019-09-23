package AmazonQuestions;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class optimalUtilizationTests {

    @Test
    public void optimalUtilization_2Test_1() {
        OptimalUtilization ou = new OptimalUtilization();


                /*
        Input:
a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]
target = 10

Output: [[2, 4], [3, 2]]
         */
        Integer[] a_elment1 = new Integer[]{1, 3};
        Integer[] a_elment2 = new Integer[]{2, 5};
        Integer[] a_elment3 = new Integer[]{3, 7};
        Integer[] a_elment4 = new Integer[]{4, 10};
        List<Integer[]> a = new ArrayList<Integer[]>();
        a.add(a_elment1);
        a.add(a_elment2);
        a.add(a_elment3);
        a.add(a_elment4);

        Integer[] b_elment1 = new Integer[]{1, 2};
        Integer[] b_elment2 = new Integer[]{2, 3};
        Integer[] b_elment3 = new Integer[]{3, 4};
        Integer[] b_elment4 = new Integer[]{4, 5};
        List<Integer[]> b = new ArrayList<Integer[]>();
        b.add(b_elment1);
        b.add(b_elment2);
        b.add(b_elment3);
        b.add(b_elment4);

        List<Integer[]> result = ou.optimalUtilization_2(a,b,10);

        Assert.assertEquals(2,result.get(0)[0].intValue());
        Assert.assertEquals(4,result.get(0)[1].intValue());
        Assert.assertEquals(3,result.get(1)[0].intValue());
        Assert.assertEquals(2,result.get(1)[1].intValue());
    }

    @Test
    public void optimalUtilization_2Test_2() {
        OptimalUtilization ou = new OptimalUtilization();


                /*
Input:
a = [[1, 8], [2, 7], [3, 14]]
b = [[1, 5], [2, 10], [3, 14]]
target = 20

Output: [[3, 1]]
         */
        Integer[] a_elment1 = new Integer[]{1, 8};
        Integer[] a_elment2 = new Integer[]{2, 7};
        Integer[] a_elment3 = new Integer[]{3, 14};
        List<Integer[]> a = new ArrayList<Integer[]>();
        a.add(a_elment1);
        a.add(a_elment2);
        a.add(a_elment3);

        Integer[] b_elment1 = new Integer[]{1, 5};
        Integer[] b_elment2 = new Integer[]{2, 10};
        Integer[] b_elment3 = new Integer[]{3, 14};
        List<Integer[]> b = new ArrayList<Integer[]>();
        b.add(b_elment1);
        b.add(b_elment2);
        b.add(b_elment3);

        List<Integer[]> result = ou.optimalUtilization_2(a,b,20);

        Assert.assertEquals(3,result.get(0)[0].intValue());
        Assert.assertEquals(1,result.get(0)[1].intValue());

    }


    @Test
    public void optimalUtilization_2Test_3() {
        OptimalUtilization ou = new OptimalUtilization();


                /*
Input:
a = [[1, 8], [2, 15], [3, 9]]
b = [[1, 8], [2, 11], [3, 12]]
target = 20

Output: [[1, 3], [3, 2]]
         */
        Integer[] a_elment1 = new Integer[]{1, 8};
        Integer[] a_elment2 = new Integer[]{2, 15};
        Integer[] a_elment3 = new Integer[]{3, 9};
        List<Integer[]> a = new ArrayList<Integer[]>();
        a.add(a_elment1);
        a.add(a_elment2);
        a.add(a_elment3);

        Integer[] b_elment1 = new Integer[]{1, 8};
        Integer[] b_elment2 = new Integer[]{2, 11};
        Integer[] b_elment3 = new Integer[]{3, 12};
        List<Integer[]> b = new ArrayList<Integer[]>();
        b.add(b_elment1);
        b.add(b_elment2);
        b.add(b_elment3);

        List<Integer[]> result = ou.optimalUtilization_2(a,b,20);

        Assert.assertEquals(1,result.get(0)[0].intValue());
        Assert.assertEquals(3,result.get(0)[1].intValue());
        Assert.assertEquals(3,result.get(1)[0].intValue());
        Assert.assertEquals(2,result.get(1)[1].intValue());

    }
}