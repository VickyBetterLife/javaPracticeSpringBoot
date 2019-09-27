package AmazonQuestions;

/*
You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to one of the treasure islands.

Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from one of the starting point (marked as S) of the map and can move one block up, down, left or right at a time. The treasure island is marked as X. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. Output the minimum number of steps to get to any of the treasure islands.

Example:

Input:
[['S', 'O', 'O', 'S', 'S'],
 ['D', 'O', 'D', 'O', 'D'],
 ['O', 'O', 'O', 'O', 'X'],
 ['X', 'D', 'D', 'O', 'O'],
 ['X', 'D', 'D', 'D', 'O']]

Output: 3
Explanation:
You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
 */


import java.util.*;


public class TreasureIslandII {


    private List<Location> findTreasurePoint(char[][] routs,char aim){
        List<Location> aims = new ArrayList<Location>();

        for(int i=0;i<routs.length;i++){
            for(int j=0;j<routs[i].length;j++){
                if(routs[i][j] == aim) {
                    aims.add(new Location(i,j));
                }
            }
        }
        return aims;
    }

    public int minRouts_method3(char[][] input){

        if(input == null || input[0].length == 0)
            return 0;

        int row = input.length;
        int col = input[0].length;


        List<Location> xLocations = findTreasurePoint(input,'X');

        List<Location> sLocations = findTreasurePoint(input,'S');

        if(xLocations == null || xLocations.size() == 0 || sLocations == null || sLocations.size() == 0)
            return 0;


        int step = Integer.MAX_VALUE;
        for(int si = 0;si<sLocations.size();si++)
        {
            Location curLocation = sLocations.get(si);
            Queue<Location> ql = new LinkedList<Location>();

            boolean[][] visited = new boolean[row][col];

            int curStep = 0;
            ql.add(curLocation);
            boolean isFound = false;
            while(!ql.isEmpty()){
                int qSize = ql.size();

                for(int i=0;i<qSize;i++){
                    Location tmp = ql.poll();
                    int x = tmp.x;
                    int y = tmp.y;

                    if(visited[x][y]) continue;

                    visited[x][y] = true;

                    if(input[x][y] == 'X'){
                        step = curStep < step ? curStep:step;
                        isFound = true;
                        break;
                    }

                    if(x-1>=0 && input[x-1][y] != 'D' &&input[x+1][y] != 'S' && !visited[x-1][y]) {
                        ql.add(new Location(x - 1, y));
                    }

                    if(x+1 < row && input[x+1][y] != 'D' && input[x+1][y] != 'S' && !visited[x+1][y]) {
                        ql.add(new Location(x + 1, y));
                    }

                    if(y-1>=0 && input[x][y-1] != 'D' && input[x+1][y] != 'S' && !visited[x][y-1]) {
                        ql.add(new Location(x, y - 1));
                    }

                    if(y+1<col && input[x][y+1] != 'D' && input[x+1][y] != 'S' && !visited[x][y+1]) {
                        ql.add(new Location(x, y + 1));
                    }

                }

                if(isFound)
                    break;
                curStep++;
            }

        }

        return step == Integer.MAX_VALUE?0:step;
    }
}

