package AmazonQuestions;

import org.junit.Assert;
import org.junit.Test;

public class treasureIslandtest {

    @Test
    public void findTreasurePoint(){
        TreasureIsland ti = new TreasureIsland();
        char[][] input = new char[][]{{'O', 'O', 'O', 'O'},{'D', 'O', 'D', 'O'},{'O', 'O', 'O', 'O'},{'X', 'D', 'D', 'O'}};

        int result = ti.minRouts_method2(input);
        Assert.assertEquals(5,result);
    }


}
