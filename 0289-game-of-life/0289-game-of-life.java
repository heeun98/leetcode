class Solution {

    int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    int n;
    int m;

    public void gameOfLife(int[][] board) {

        n = board.length;
        m = board[0].length;

        int[][] result = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 1) { // 현재 살아 있는 경우
                    result[i][j] = check1(i, j, board);
                } else { // 뒤져있는 경우
                    result[i][j] = check2(i, j, board);
                }


            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = result[i][j];
            } 
        }
        
    }

    public int check1(int row, int col, int[][] nums) {

        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

            if (nums[nr][nc] == 1) {
                count++;
            }
        }
        if (count < 2) {
            return 0;
        } else if (count <= 3) {
            return 1;
        } else {
            return 0;
        }
    }

    public int check2(int row, int col, int[][] nums) {

        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];


            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            

            if (nums[nr][nc] == 1) {
                count++;
            }
        }

        if (count == 3) return 1;
        return 0;

    }
}