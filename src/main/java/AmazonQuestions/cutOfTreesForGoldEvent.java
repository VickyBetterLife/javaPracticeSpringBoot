package AmazonQuestions;

/*
You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.


You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:

Input:
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6


Example 2:

Input:
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1


Example 3:

Input:
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.

 */
import java.util.*;

public class cutOfTreesForGoldEvent {

    public int cutOfTrees(List<List<Integer>> forest){

        if(forest == null || forest.size() == 0)  //no any element, no trees,just return -1
            return -1;

    int m = forest.size();
    int n = forest.get(0).size();
//    PriorityQueue<Tree> treesToBeCut = new PriorityQueue<Tree>(20,new Comparator<Tree>() {
//        @Override
//        public int compare(Tree o1, Tree o2) {
//            return o1.height - o2.height;
//        }
//    });

        Queue<Tree> treesToBeCut = new LinkedList<Tree>();

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

