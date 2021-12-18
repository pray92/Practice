package LeetCode;

public class ValidSudoku {

    private final int MAX_VALID_BLOCK = 3;

    public boolean isValidSudoku(char[][] board) {
        // Block
        for(int y = 0; y < 9; y += 3){
            for(int x = 0; x < 9 ; x += 3){
                if(!isBlockValid(board, y, x))
                    return false;
            }
        }

        // Row
        for(int y = 0; y < 9; ++y){
            if(!isRowValid(board, y))
                return false;
        }

        // Col
        for(int x = 0; x < 9; ++x){
            if(!isColValid(board, x))
                return false;
        }

        return true;
    }

    private boolean isBlockValid(char[][] board, int row, int col){
        boolean[] check = new boolean[10];
        for(int y = row; y < row + 3; ++y){
            for(int x = col; x < col + 3; ++x){
                if('1' <= board[y][x] && board[y][x] <= '9'){
                    int value = Character.getNumericValue(board[y][x]);
                    if(check[value])
                        return false;
                    check[value] = true;
                }
            }
        }
        return true;
    }

    private boolean isRowValid(char[][] board, int row){
        boolean[] check = new boolean[10];
        for(int x = 0; x < 9; ++x){
            if('1' <= board[row][x] && board[row][x] <= '9'){
                int value = Character.getNumericValue(board[row][x]);
                if(check[value])
                    return false;
                check[value] = true;
            }
        }

        return true;
    }

    private boolean isColValid(char[][] board, int col){
        boolean[] check = new boolean[10];
        for(int y = 0; y < 9; ++y){
            if('1' <= board[y][col] && board[y][col] <= '9'){
                int value = Character.getNumericValue(board[y][col]);
                if(check[value])
                    return false;
                check[value] = true;
            }
        }

        return true;
    }
}
