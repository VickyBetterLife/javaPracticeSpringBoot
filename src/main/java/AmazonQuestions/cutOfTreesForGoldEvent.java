package AmazonQuestions;

import java.util.*;

public class cutOfTreesForGoldEvent {

    public int cutOfTrees(List<List<Integer>> forest){

        if(forest == null || forest.size() == 0)  //no any element, no trees,just return -1
            return -1;

    int m = forest.size();
    int n = forest.get(0).size();
    PriorityQueue<Tree> treesToBeCut = new PriorityQueue<Tree>(20,new Comparator<Tree>() {
        @Override
        public int compare(Tree o1, Tree o2) {
            return o1.height - o2.height;
        }
    });

    int[] curLocation = new int[]{0, 0};
    int steps = 0;

    //get all the trees need to be cut
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            if (forest.get(i).get(j) > 1)
            treesToBeCut.add(new Tree(forest.get(i).get(j), new int[] {i, j}));

        while (!treesToBeCut.isEmpty()) {
        Tree tree = treesToBeCut.poll();
        int minSteps = getMinSteps(forest, curLocation, tree.height);
        if (minSteps == -1) return -1;
        steps += minSteps;
        curLocation = tree.coord;
    }

        return steps;
}

    private int getMinSteps(List<List<Integer>> forest, int[] start, int targetHeight) {
        int m = forest.size();
        int n = forest.get(0).size();
        Queue<int[]> queue = new LinkedList();
        boolean[][] seen = new boolean[m][n];
        queue.add(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curLocation = queue.poll();
                int r = curLocation[0];
                int c = curLocation[1];
                if (seen[r][c]) continue;
                seen[r][c] = true;
                int val = forest.get(r).get(c);
                if (val == 0) return -1;
                if (val != targetHeight) {
                    if (r - 1 >= 0 && forest.get(r - 1).get(c) != 0 && !seen[r-1][c]) queue.add(new int[] {r - 1, c});
                    if (r + 1 < m && forest.get(r + 1).get(c) != 0 && !seen[r+1][c]) queue.add(new int[] {r + 1, c});
                    if (c - 1 >= 0 && forest.get(r).get(c - 1) != 0 && !seen[r][c-1]) queue.add(new int[] {r, c - 1});
                    if (c + 1 < n && forest.get(r).get(c + 1) != 0 && !seen[r][c+1]) queue.add(new int[] {r, c + 1});
                } else {
                    forest.get(r).set(c, 1);
                    return steps;
                }
            }
            steps++;
        }

        return -1;
    }
}

class Tree {
    int height;
    int[] coord;

    public Tree(int height, int[] coord) {
        this.height = height;
        this.coord = coord;
    }
}

