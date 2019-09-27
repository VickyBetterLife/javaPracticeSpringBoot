package AmazonQuestions;

/*
You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.

Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of steps to get to the treasure.

Example:

Input:
[['O', 'O', 'O', 'O'],
 ['D', 'O', 'D', 'O'],
 ['O', 'O', 'O', 'O'],
 ['X', 'D', 'D', 'O']]

Output: 5
Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
Solution
Java BFS: https://leetcode.com/playground/uQoVfEmr
Time complexity: O(r * c).
Space complexity: O(r * c).
 */


import java.util.LinkedList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Queue;



public class TreasureIsland {

    public int minRouts_method1(char[][] input){

        if(input == null || input.length == 0)
           return 0;

        int m = input.length;
        int n = input[0].length;
        boolean[][] visited = new boolean[m][n]; //indicate whether it is visited.

        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        int level = 0;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{ 0, 0, 1, -1};

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0 ; i < size ; i++) {
                int[] current = q.remove();

                for (int j = 0 ; j < 4 ; j++) {
                    int x = current[0] + dx[j];
                    int y = current[1] + dy[j];

                    if (x < 0 || y < 0 || x >= m || y >= n || input[x][y] == 'D' || visited[x][y])
                        continue;

                    if (input[x][y] == 'X')
                        return level + 1;

                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }

            level++;
        }

        return level;

    }


    public int minRouts_method2(char[][] input){
        Location destination = findTreasurePoint(input);
        Queue<Location> points = new ArrayDeque<Location>();
        points.add(new Location(0, 1));
        int i = 0;
        int j = 1;
        boolean isFound = false;
        while (!isFound) {
            System.out.println("Values [i][j] " + i + "," + j + " : " + input[i][j]);

            if (input[i][j] == 'X') {
                isFound = true;
            } else if (input[i + 1][j] != 'D') {
                i++;
                points.add(new Location(i, j));
            } else if (destination.y <= j && input[i][j - 1] != 'D') {
                j--;
                points.add(new Location(i, j));
            } else {
                j++;
                points.add(new Location(i, j));
            }
        }
        return points.size();
    }


    private Location findTreasurePoint(char[][] routs){

        Location treasure = null;
        for(int i=0;i<routs.length;i++){
            for(int j=0;j<routs[i].length;j++){
                if(routs[i][j] == 'X') {
                    treasure = new Location(i,j);
                    break;
                }
            }
            if(treasure != null)
                break;
        }
        return treasure;
    }

    public int minRouts_method3(char[][] input){

        if(input == null || input[0].length == 0)
            return 0;

        int row = input.length;
        int col = input[0].length;
        Location xLocation = findTreasurePoint(input);

        if(xLocation == null)
            return 0;

        Location curLocation = new Location(0,0);

        Queue<Location> ql = new LinkedList<Location>();

        boolean[][] visited = new boolean[row][col];

        int step =0;
        ql.add(curLocation);

        while(!ql.isEmpty()){
            int qSize = ql.size();

            for(int i=0;i<qSize;i++){
                Location tmp = ql.poll();
                int x = tmp.x;
                int y = tmp.y;

                if(visited[x][y]) continue;

                visited[x][y] = true;

                if(input[x][y] == 'X'){
                   return step;
                }

                if(x-1>=0 && input[x-1][y] != 'D' && !visited[x-1][y]) {
                    ql.add(new Location(x - 1, y));
                }

                if(x+1 < row && input[x+1][y] != 'D' && !visited[x+1][y]) {
                    ql.add(new Location(x + 1, y));
                }

                if(y-1>=0 && input[x][y-1] != 'D' && !visited[x][y-1]) {
                    ql.add(new Location(x, y - 1));
                }

                if(y+1<col && input[x][y+1] != 'D' && !visited[x][y+1]) {
                    ql.add(new Location(x, y + 1));
                }

            }
            step++;
        }
        return 0;
    }
}




