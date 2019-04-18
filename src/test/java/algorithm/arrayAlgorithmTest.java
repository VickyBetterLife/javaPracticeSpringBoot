package algorithm;
import org.junit.Assert;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。

public class arrayAlgorithmTest {

    @Test
    public void RemoveElementTest()
    {
        RemoveElement re = new RemoveElement();
        int[] array1 = {3,2,2,3};
        Assert.assertEquals(re.removeElement(array1,3),2);

        int[] array2 = {2,2,3};
        Assert.assertEquals(re.removeElement(array2,3),2);

        int[] array3 = {2,2};
        Assert.assertEquals(re.removeElement(array3,3),2);

        int[] array4 = {};
        Assert.assertEquals(re.removeElement(array4,3),0);
    }
}
