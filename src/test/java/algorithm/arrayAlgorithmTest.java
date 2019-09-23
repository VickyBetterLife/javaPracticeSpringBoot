package algorithm;
import org.junit.Assert;
import org.junit.Test;
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

    @Test
    public void PlusOneTest()
    {
        PlusOne po = new PlusOne();
        int[] array1 = {1,2,9};
        int[] result = po.plusOne_method2(array1);
        Assert.assertEquals(3,result.length);

    }

    @Test
    public void PascalTriangleTest()
    {

        PascalTriangle po = new PascalTriangle();

        po.generate(5);


    }

    @Test
    public void findPeakElementTest(){
        FindPeakElement fpe = new FindPeakElement();
        int[] array1 = {1,2};
        Assert.assertEquals(1,fpe.findPeakElement(array1));

    }

    @Test
    public void constructBianaryTreeTest(){
        BinaryTree cbt = new BinaryTree();
        int[] inorder = {4,2,5,1,6,3,7};
        int[] postorder = {4,5,2,6,7,3,1};
        cbt.constructTreeWithInorderAndPostOrder(inorder,postorder);
    }

    @Test
    public void validateBinarySearchTreeTest(){
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        TreeNode rightNode = new TreeNode(Integer.MAX_VALUE);
        root.right = rightNode;
        rightNode.left = null;
        rightNode.right = null;
        root.left = null;

        BinaryTree cbt = new BinaryTree();
        Assert.assertFalse(cbt.validateBinarySearchTree(root));
    }

//    @Test
//    public void postOrder(){
//        int[] treeNodes = {1,null,2,3};
//
//    }

}
