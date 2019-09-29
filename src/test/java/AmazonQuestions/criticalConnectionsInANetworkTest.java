package AmazonQuestions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class criticalConnectionsInANetworkTest {

    @Test
    public void criticalConnectionsTest()
    {
        int n=4;
     //   int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}};
        List<List<Integer>> edgeList = new ArrayList<List<Integer>>();
        edgeList.add(new ArrayList<Integer>(asList(0,1)));
        edgeList.add(new ArrayList<Integer>(asList(1,2)));
        edgeList.add(new ArrayList<Integer>(asList(2,0)));
        edgeList.add(new ArrayList<Integer>(asList(1,3)));
//        edgeList.add(new ArrayList<Integer>(asList(3,4)));
//        edgeList.add(new ArrayList<Integer>(asList(4,5)));
//        edgeList.add(new ArrayList<Integer>(asList(5,3)));


        CriticalConnectionsinANetwork csn = new CriticalConnectionsinANetwork();
        csn.criticalConnections(n,edgeList);
    }
}
