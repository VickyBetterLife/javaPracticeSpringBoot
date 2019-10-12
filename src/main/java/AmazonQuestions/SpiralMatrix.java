package AmazonQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length ==0)
            return result;

        int r = matrix.length;
        int l = matrix[0].length;

        int startRow =0;
        int endRow = r-1;
        int startCol = 0;
        int endCol = l-1;

        while(startRow <= endRow && startCol <= endCol){
            for(int i=startCol;i<=endCol;i++)
                result.add(matrix[startRow][i]);

            startRow ++;

            for(int i= startRow;i<=endRow;i++)
                result.add(matrix[i][endCol]);

            endCol--;

            if(startRow <= endRow){
                for(int i= endCol;i>=startCol;i--){
                    result.add(matrix[endRow][i]);
                }
                endRow--;
            }

            if(startCol <= endCol){
                for(int i=endRow;i>=startRow;i--)
                    result.add(matrix[i][startCol]);

                startCol++;
            }

        }
        return result;
    }

}
