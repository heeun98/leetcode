import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        int[][][] cost = new int[n][n][4];
        for (int[][] a : cost) for (int[] b : a) Arrays.fill(b, Integer.MAX_VALUE);
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{0, 0, -1, 0});
        
        int result = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1], dir = cur[2], sum = cur[3];
            
            if (row == n - 1 && col == n - 1) {
                result = Math.min(result, sum);
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (board[nr][nc] == 1) continue;
                
                int nSum = (dir == -1 || dir == i) ? sum + 100 : sum + 600;
                
                if (nSum < cost[nr][nc][i]) {
                    cost[nr][nc][i] = nSum;
                    q.offer(new int[]{nr, nc, i, nSum});
                }
            }
        }
        
        return result;
    }
}