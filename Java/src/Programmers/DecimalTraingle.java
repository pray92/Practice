package Programmers;

// 21:19
public class DecimalTraingle {
    public int solution(int[][] triangle) {
        for(int i = 1; i < triangle.length; ++i) {
            for(int j = 0; j <= i; ++j) {
                if(j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if( j == i) {
                    triangle[i][j] += triangle[i -1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }
        return triangle[triangle.length - 1][triangle.length - 1];
    }

    public static void main(String[] args) {
    }
}
