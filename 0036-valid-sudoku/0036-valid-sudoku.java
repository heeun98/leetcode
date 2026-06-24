class Solution {
    public boolean isValidSudoku(char[][] board) {
        

        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) {
                return false;
            }
        }


        for (int i = 0; i < 9; i++) {
            if (!checkCol(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j+= 3) {
                if (!checkSquare(board, i, j)) {
                    return false;
                }
            }
        }


        return true;

        
    }

    public boolean checkRow(char[][] board, int col) {

        int[] number = new int[10];
        for (int i = 0; i < 9 ; i++) {

            
            char idx = board[i][col];
            if (!Character.isDigit(idx)) continue;

            if (number[idx - '0'] == 0) {
                number[idx - '0'] = 1;
            } else {
                return false;
            }


        }
        return true;
    }



    public boolean checkCol(char[][] board, int row) {

        int[] number = new int[10];
        for (int i = 0; i < 9 ; i++) {
            
            char idx = board[row][i];
            if (!Character.isDigit(idx)) continue;


            if (number[idx - '0'] == 0) {
                number[idx - '0'] = 1;
            } else {
                return false;
            }

        }
        return true;
    }


    public boolean checkSquare(char[][] board, int row, int col) {

        int[] number = new int[10];

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char idx = board[i][j];
                if (!Character.isDigit(idx)) continue;
                
                if (number[idx - '0'] == 0) {
                    number[idx - '0'] = 1;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}