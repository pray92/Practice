package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<Integer>();

        int maxCol = matrix[0].length, maxRow = matrix.length;
        int nCol = 0, nRow = 0;
        for(int nCnt = 0; nCnt < maxCol; ++nCnt){
            answer.add(matrix[nRow][nCol + nCnt]);
        }
        nCol = (--maxCol);
        ++nRow;

        for(int nCnt = 0; nCnt < maxRow; ++nCnt){
            answer.add(matrix[nRow + nCnt][nCol]);
        }
        nRow = (--maxRow);
        --nCol;

        for(int nCnt = 0; nCnt < maxCol; ++nCnt){
            answer.add(matrix[nRow][nCol - nCnt]);
        }
        nCol -= (--maxCol);
        ++nRow;

        for(int nCnt = 0; nCnt < maxRow; ++nCnt){
            answer.add(matrix[nRow - nCnt][nCol]);
        }
        nRow -= (--maxRow);
        --nCol;
        
        return answer;
    }

    public static void main(String[] args){
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{
            {1,2,3,4,5,6},
            {14,15,16,17,18,7},
            {13,12,11,10,9,8},
        }).toString());
    }
}
