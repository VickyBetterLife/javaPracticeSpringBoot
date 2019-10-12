package AmazonQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<List<String>>();
        if(n == 0)
            return result;

        int[] colsUsed = new int[n];
        Arrays.fill(colsUsed,-1);
        dfsSearch(0,n,colsUsed,result);
        return result;
    }

    private void dfsSearch(int row,int n,int[] colsUsed,List<List<String>> result){
        if(row == n){
            List<String> curList = new ArrayList<String>();

            for(int i=0;i<n;i++){
                StringBuffer buff = new StringBuffer();
                for(int j=0;j<n;j++){
                    buff.append(colsUsed[i] == j? "Q" : ".");
                }
                curList.add(buff.toString());
            }

            result.add(curList);
            return;
        }

        for(int col=0;col<n;col++){
            if(isValid(colsUsed,row,col)){
                colsUsed[row] = col;
                dfsSearch(row+1,n,colsUsed,result);
                colsUsed[row] = -1;
            }
        }
    }

    private boolean isValid(int[] colsUsed,int row,int col) {
        for (int i = 0; i < row; i++) {
            if (colsUsed[i] == col)
                return false;

            if (Math.abs(row - i) == Math.abs(col - colsUsed[i]))
                return false;
        }

        return true;
    }
}
