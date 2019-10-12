package AmazonQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

Update (2017-09-26):
We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph. For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
 */

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges){
        // 使用邻接表存储图的信息
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        // 遍历每一条边
        for(int[] edge : edges) {
            // Each element of edges is a pair [u, v] with u < v
            int u = edge[0];
            int v = edge[1];

            // 深度优先遍历该图，判断u到v之间是否已经存在了一条路径
            boolean hasPath = dfs(graph, u, v, new ArrayList<Integer>());

            if(hasPath == true) {
                return edge;
            }
            else {
                // 将该边加入到邻接表中
                if(!graph.containsKey(u)) {
                    graph.put(u, new ArrayList<Integer>());
                }
                graph.get(u).add(v);

                if(!graph.containsKey(v)) {
                    graph.put(v, new ArrayList<Integer>());
                }
                graph.get(v).add(u);
            }
        }

        return null;
    }

    // 深度优先遍历该图，判断start到end之间是否已经存在了一条路径
    public boolean dfs(Map<Integer, List<Integer>> graph, int start, int end, List<Integer> visited) {
        if(!graph.containsKey(start) || !graph.containsKey(end)) {
            return false;
        }

        if(start == end) {
            return true;
        }

        visited.add(start);

        // 遍历start的所有相邻节点
        for(int adj : graph.get(start)) {
            if(!visited.contains(adj)) {
                if(dfs(graph, adj, end, visited) == true) {
                    return true;
                }
            }
        }

        return false;
    }
}