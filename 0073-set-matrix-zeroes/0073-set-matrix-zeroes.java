class Solution {
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<int[]> zeros = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < zeros.size(); i++) {
            int[] idxes = zeros.get(i);
            int r = idxes[0];
            int c = idxes[1];
            fillRow(r, n, matrix);
            fillCol(c, m, matrix);
        }
    }


    public void fillRow(int row, int n, int[][] matrix) {

        for (int i = 0; i < n; i++) {
            matrix[row][i] = 0;
        }

    }

    public void fillCol(int col, int m, int[][] matrix) {

        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;
        }

    }
}