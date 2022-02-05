package Programmers;

public class FindBiggestSquare {
    public int solution(int [][]board){
        if(isAllZero(board))
            return 0;

        int answer = 1;
        for(int y = 1; y < board.length; ++y){
            for(int x = 1; x < board[y].length ; ++x){
                if(0 >= board[y][x])
                    continue;

                board[y][x] = Math.min(board[y - 1][x], Math.min(board[y][x - 1], board[y - 1][x - 1])) + 1;
                answer = Math.max(board[y][x], answer);
            }
        }

        return answer * answer;
    }

    private boolean isAllZero(int[][] board) {
        for(int y = 0; y < board.length; ++y){
            for(int x = 0; x < board[y].length; ++x){
                if(board[y][x] == 1)
                    return false;
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int y1 , int y2, int x1, int x2){
        for(int y = y1; y < y2; ++y){
            for(int x = x1; x < x2; ++x){
                if(board[y][x] == 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        var ret = new FindBiggestSquare().solution(new int[][]{
            {0,1,1,1},
            {1,1,1,1},
            {1,1,1,1},
            {0,0,1,0},
        });
    }
}
