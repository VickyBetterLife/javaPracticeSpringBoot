package AmazonQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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