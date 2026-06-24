class Solution {

    int[] dr = {0, 1, 0,-1};
    int[] dc = {1, 0, -1,0};
    public List<Integer> spiralOrder(int[][] matrix) {
        


        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visit = new boolean[n][m];
        int total = n * m;
        List<Integer> result = new ArrayList<>();
        int row = 0;
        int col = 0;
        int idx = 0;

        result.add(matrix[0][0]);
        visit[0][0] = true;
        total--;

        if (total == 0) return result;

        while (true) {
            int nr = row + dr[idx];
            int nc = col + dc[idx];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                idx = (idx + 1) % 4;
                continue;
            }
            if (visit[nr][nc]) {
                idx = (idx + 1) % 4;
                continue;
            }
            row = nr;
            col = nc;
            result.add(matrix[nr][nc]);
            visit[nr][nc] = true;
            total--;

            if (total == 0) break;
        }

        return result;



    }
}