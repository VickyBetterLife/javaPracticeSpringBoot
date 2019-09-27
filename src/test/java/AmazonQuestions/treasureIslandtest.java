package AmazonQuestions;

import org.junit.Assert;
import org.junit.Test;

public class treasureIslandtest {

    @Test
    public void shortestPathTest(){
        TreasureIsland ti = new TreasureIsland();
        char[][] input = new char[][]{{'O', 'O', 'O', 'O'},{'D', 'O', 'D', 'O'},{'O', 'O', 'O', 'O'},{'X', 'D', 'D', 'O'}};
        int result= ti.minRouts_method3(input);
        Assert.assertEquals(5,result);

        char[][] input2 = new char[][]{{'O', 'O', 'O', 'O'},{'D', 'D', 'D', 'O'},{'O', 'O', 'O', 'O'},{'X', 'D', 'D', 'O'}};
        int result2= ti.minRouts_method3(input2);
        Assert.assertEquals(9,result2);

        char[][] input3 = new char[][]{{'O', 'O', 'O', 'O'},{'X', 'D', 'D', 'O'},{'O', 'O', 'O', 'O'},{'X', 'D', 'D', 'O'}};
        int result3= ti.minRouts_method3(input3);
        Assert.assertEquals(1,result3);


        char[][] input4 = new char[][]{{'O', 'O', 'O', 'O'},{'O', 'D', 'D', 'O'},{'O', 'O', 'O', 'O'},{'O', 'D', 'D', 'O'}};
        int result4= ti.minRouts_method3(input4);
        Assert.assertEquals(0,result4);
    }


    @Test
    public void minRouts_method2(){
        TreasureIsland ti = new TreasureIsland();
        char[][] input = new char[][]{{'O', 'O', 'O', 'O'},{'D', 'O', 'D', 'O'},{'O', 'O', 'O', 'O'},{'X', 'D', 'D', 'O'}};

        int result = ti.minRouts_method2(input);
        Assert.assertEquals(5,result);
    }


    @Test
    public void treaserIslandII_test()
    {
        TreasureIslandII ti2 = new TreasureIslandII();
        char[][] input = new char[][]{{'S', 'O', 'O', 'S', 'S'},{'D', 'O', 'D', 'O', 'D'},{'O', 'O', 'O', 'O', 'X'},{'X', 'D', 'D', 'O', 'O'},{'X', 'D', 'D', 'D', 'O'}};
        int result = ti2.minRouts_method3(input);
        Assert.assertEquals(3,result);
    }
}
