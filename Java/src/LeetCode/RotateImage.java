
package LeetCode;

import java.util.Arrays;

class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseY(matrix);
    }

    private void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length - 1; ++i){
            for(int j = i + 1 ; j < matrix.length; ++j){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        print("Transpose", matrix);
    }

    private void reverseY(int[][] matrix){
        for(int i = 0; i < matrix[0].length / 2; ++i){
            for(int j = 0; j < matrix.length; ++j){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix[0].length - i - 1];
                matrix[j][matrix[0].length - i - 1] = tmp;
            }
        }
        print("Reverse", matrix);
    }

    private void print(String ret, int[][] matrix){
        System.out.println(ret + ":");
        System.out.println("--------------------");
        for(var mat : matrix){
            System.out.println(Arrays.toString(mat));
        }
    }

    public static void main(String[] args){
        new RotateImage().rotate(new int[][]{
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        });
    }
}