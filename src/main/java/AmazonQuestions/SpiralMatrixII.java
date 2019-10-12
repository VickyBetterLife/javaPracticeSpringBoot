package AmazonQuestions;


/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {

        if(n==0)
            return null;

        int[][] result = new int[n][n];

        int startRow = 0;
        int startCol = 0;
        int endRow = n-1;
        int endCol = n-1;
        int value = 1;

        while(startRow <= endRow && startCol <= endCol){
            for(int i=startCol;i<=endCol;i++){
               result[startRow][i] = value++;
            }

            startRow ++;

            for(int i = startRow;i<=endRow;i++)
                result[i][endCol] = value++;

            endCol--;

            if(startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    result[endRow][i] = value++;
                }
                endRow--;
            }

            if(startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--)
                    result[i][startCol] = value++;
                startCol++;
            }

        }
        return result;
    }

}
